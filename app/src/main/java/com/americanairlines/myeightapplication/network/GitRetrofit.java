package com.americanairlines.myeightapplication.network;

import com.americanairlines.myeightapplication.model.GitResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.americanairlines.myeightapplication.uttil.Constant.*;

public class GitRetrofit {

    private GitApi gitApi;

    public GitRetrofit() {
        gitApi = createGitApi(createRetrofit());
    }

    private Retrofit createRetrofit(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private GitApi createGitApi(Retrofit retrofit){
        return retrofit.create(GitApi.class);
    }

    public Call<List<GitResponse>> getUserRepositories(String userName){
        return gitApi.getGitResponse(userName);
    }
}
