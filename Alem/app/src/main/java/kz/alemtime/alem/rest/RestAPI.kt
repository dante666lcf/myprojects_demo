package kz.alemtime.alem.rest

import kz.alemtime.alem.models.TResponseResultAuth
import kz.alemtime.alem.models.TResponseResultAuthRegistration
import kz.alemtime.alem.models.TResponseResultSubscriptions
import kz.alemtime.alem.models.otherModels.TCategoryType
import kz.alemtime.alem.models.otherModels.TPosts
import retrofit2.Response
import retrofit2.http.*
import rx.Observable
import rx.Single

interface RestAPI {

    /*===================================== ПРОТЕСТИРОВАННО ======================================*/


    @FormUrlEncoded
    @POST("auths/token")
    fun postAuth(@Field("email") email: String,
                 @Field("password") password: String): Single<Response<TResponseResultAuth>>


    /*============================================================================================*/


    @FormUrlEncoded
    @POST("auths/signup")
    fun postAuthRegistration(@Field("username") username: String,
                             @Field("email") email: String,
                             @Field("password") password: String): Single<Response<TResponseResultAuthRegistration>>

    @GET("posts")
    fun getPostByCategoryId(@Query("filter[category_id]") categoryId: Int): Observable<Response<ArrayList<TPosts>>>

    @GET("posts")
    fun getPostHot(@Query("filter[on_hot_news]") postHot: Int): Observable<Response<ArrayList<TPosts>>>

    @GET("categories")
    fun getCategoriesType(@Query("filter[type]") parentId: Int): Observable<Response<ArrayList<TCategoryType>>>
    //endregion

    @GET("subscriptions")
    fun getSubscriptions(): Observable<Response<ArrayList<TResponseResultSubscriptions>>>

    @GET("posts")
    fun getPosts(): Observable<Response<ArrayList<TPosts>>>
}

