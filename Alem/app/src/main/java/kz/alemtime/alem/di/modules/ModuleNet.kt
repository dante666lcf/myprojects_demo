package kz.alemtime.alem.di.modules

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kz.alemtime.alem.ApplicationMain
import kz.alemtime.alem.rest.RestAPI
import kz.alemtime.alem.support.stat.ZPrefs
import okhttp3.Cache
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ModuleNet(application: Application) {

    private val application: ApplicationMain = application as ApplicationMain
    //    private val headerAppKey = "APP-KEY"
    private val headerAuthToken = "Authorization"
//    private val headerMobileApp = "X-MobileApp"
//    private val headerOs = "X-OS"
//    private val headerProject = "X-Project"
//    private val headerAppVersion = "X-App-version"
//    private val headerDeviceId = "X-Device-id"
//    private val headerPhoneName = "X-Phone-name"

    @Provides
    @Singleton
    internal fun providesOkHttpCache(application: Application): Cache {
        val cacheSize = 50 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun providesGson(): Gson {
        return GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create()
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val request = chain.request()
                    val requestBuilder = request.newBuilder()
                    val token: String? = ZPrefs.getUserAuthToken()
                    if (token != null) {
                        val credential = Credentials.basic(token, "abekeabeke")
                        requestBuilder.header(headerAuthToken, credential)
                    }

                    chain.proceed(requestBuilder.build())
                }
//                .addNetworkInterceptor(StethoInterceptor())
                .cache(cache)
                .build()
    }

    @Provides
    @Singleton
    internal fun providesRetrofitBuilder(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ZPrefs.HOST)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    internal fun providesGatewayApi(retrofit: Retrofit): RestAPI {
        return retrofit.create<RestAPI>(RestAPI::class.java)
    }

}
