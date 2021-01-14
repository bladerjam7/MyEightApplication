package com.americanairlines.myeightapplication.network;

import com.americanairlines.myeightapplication.model.GitResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.americanairlines.myeightapplication.uttil.Constant.URL_PATH;
import static com.americanairlines.myeightapplication.uttil.Constant.USER_NAME_PATH;

public interface GitApi {

    @GET(URL_PATH)
    Call<List<GitResponse>> getGitResponse(@Path(USER_NAME_PATH) String userName);
}
