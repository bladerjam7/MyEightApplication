package com.americanairlines.myeightapplication.presenter;

import android.util.Log;

import com.americanairlines.myeightapplication.model.GitResponse;
import com.americanairlines.myeightapplication.network.GitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitPresenter implements GitRespitoryContract.GitPresenter {

    private GitRespitoryContract.GitView gitView;
    private GitRetrofit gitRetrofit;

    public GitPresenter(GitRespitoryContract.GitView gitView) {
        this.gitView = gitView;
        gitRetrofit = new GitRetrofit();
        Log.d("TAG_X", "GitPresenter: ");
    }


    @Override
    public void getList() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                gitRetrofit.getUserRepositories("bladerjam7")
                        .enqueue(new Callback<List<GitResponse>>() {
                            @Override
                            public void onResponse(Call<List<GitResponse>> call, Response<List<GitResponse>> response) {
                                if(response.isSuccessful() && response.body() != null){
                                    Log.d("TAG_X", "onResponse: " + response.body().size() + " " + response.body().toString());
                                    gitView.displayList(response);
                                }
                            }

                            @Override
                            public void onFailure(Call<List<GitResponse>> call, Throwable t) {
                                Log.d("TAG_X", "onResponse: oops " + t + " " + call.request().url());
                            }
                        });
            }
        }.start();
    }

}
