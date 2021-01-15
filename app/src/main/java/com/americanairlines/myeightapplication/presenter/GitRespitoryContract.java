package com.americanairlines.myeightapplication.presenter;

import android.content.Context;

import com.americanairlines.myeightapplication.model.GitResponse;

import java.util.List;

import retrofit2.Response;

public interface GitRespitoryContract {

    interface GitPresenter {
        void getList() throws InterruptedException;
    }

    interface GitView {
        void displayList(Response<List<GitResponse>> response);
        Context getContext();
    }

}
