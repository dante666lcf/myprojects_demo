package kz.app.bender.rest;

import java.util.ArrayList;

import kz.app.bender.models.TChildrenItem;
import kz.app.bender.models.TDate;
import kz.app.bender.models.TResponseResult;
import kz.app.bender.models.TSignIn;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RestApi {

    @FormUrlEncoded
    @POST("v1/representative-user/send-code")
    Observable<Response<TResponseResult>> postSendCode(@Field("iin") String iin);

    @FormUrlEncoded
    @POST("v1/representative-user/auth-user")
    Observable<Response<TResponseResult<TSignIn>>> postAuthUser(@Field("iin") String iin,
                                                                @Field("code") String code);

    @FormUrlEncoded
    @POST("v1/representative-user/get-my-children")
    Observable<Response<TResponseResult<ArrayList<TChildrenItem>>>> getMyChildren(@Field("iin") String iin);

    @FormUrlEncoded
    @POST("v1/image/get-prev-image")
    Observable<Response<TResponseResult<String>>> getPrevImage(@Field("id") Integer id);

    @FormUrlEncoded
    @POST("v1/timesheet/note-child")
    Observable<Response<TResponseResult<TDate>>> postNoteChild(@Field("childId") String childId,
                                                               @Field("code") String code);

    @FormUrlEncoded
    @POST("v1/representative-user/get-through-auth-token")
    Observable<Response<TResponseResult<String>>> getThroughAuthToken(@Field("iin") String iin);

}
