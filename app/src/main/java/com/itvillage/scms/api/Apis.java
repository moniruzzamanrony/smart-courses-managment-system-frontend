package com.itvillage.scms.api;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Apis {
    @POST("api/maintenance/create/teacher")
    Observable<String> signUpForFaculty(@Body RequestBody body);

}
