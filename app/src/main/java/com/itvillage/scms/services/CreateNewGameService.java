package com.itvillage.scms.services;

import android.content.Context;


import com.itvillage.scms.api.Apis;
import com.itvillage.scms.config.ApiClient;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class CreateNewGameService {

    private final Context context;
    private final String LOGIN_REQUEST_BODY_FORMAT = "{ \"gameNumber\": \"%s\" , \"gameType\": \"%s\",\"gameName\": \"%s\",\"version\": \"%s\", \"map\": \"%s\", \"gameStatus\": \"%s\", \"roomId\": \"%s\", \"roomPassword\": \"%s\", \"totalPrize\": \"%s\", \"winnerPrize\": \"%s\", \"secondPrize\": \"%s\",\"thirdPrize\": \"%s\",\"perKillPrize\": \"%s\",\"entryFee\": \"%s\" }";

    public CreateNewGameService(Context context) {
        this.context = context;
    }

//    public Observable<String> createGame(String gameNumber,String gameType,String gameName , String version, String map,String gameStatus,
//                                                     String roomId,String roomPassword,String totalPrize,String winnerPrize,String secondPrize,String thirdPrize,String perKillPrize,String entryFee) {
//
//        String createGame = String.format(LOGIN_REQUEST_BODY_FORMAT, gameNumber,gameType,gameName,version,map,gameStatus,roomId,roomPassword,totalPrize,winnerPrize,secondPrize,thirdPrize,perKillPrize,entryFee);
//
//        return ApiClient.getClient(context)
//                .create(Apis.class)
//                .createNewGame(RequestBody.create(MediaType.parse("application/json"),createGame));
//    }



}
