package com.americanairlines.myeightapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.americanairlines.myeightapplication.R;
import com.americanairlines.myeightapplication.model.GitResponse;
import com.americanairlines.myeightapplication.network.GitRetrofit;
import com.americanairlines.myeightapplication.presenter.GitPresenter;
import com.americanairlines.myeightapplication.presenter.GitRespitoryContract;
import com.americanairlines.myeightapplication.view.adapter.GitAdapterRV;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GitAdapterRV.GetDelegate, GitRespitoryContract.GitView{

    private GitRetrofit gitRetrofit = new GitRetrofit();
    private RecyclerView rv;
    private GitAdapterRV adapterRV;

    private GitRespitoryContract.GitPresenter presenter;

    private ListFragment listFragment;
    private DetailFragment detailFragment = new DetailFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_list);
        //adapterRV = new GitAdapterRV(new ArrayList<>(), this);

        //listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.frag_list);

        presenter = new GitPresenter(this);
        try {
            presenter.getList();
            Log.d("TAG", "onCreate: ");
        } catch (InterruptedException e) {
            Log.d("TAG", "onCreate: Failed");

            e.printStackTrace();
        }

        /*new Thread(){
            @Override
            public void run() {
                super.run();

                gitRetrofit.getUserRepositories("bladerjam7")
                        .enqueue(new Callback<List<GitResponse>>() {
                            @Override
                            public void onResponse(Call<List<GitResponse>> call, Response<List<GitResponse>> response) {

                                if(response.isSuccessful() && response.body() != null){
                                    Log.d("TAG_X", "onResponse: " + response.body().size() + " " + response.body().toString());
                                    adapterRV.getUpdate(response.body());
                                    rv.setAdapter(adapterRV);
                                } else {
                                    Log.d("TAG_X", "onResponse: Error something did not workout...");
                                }

                            }

                            @Override
                            public void onFailure(Call<List<GitResponse>> call, Throwable t) {
                                Log.d("TAG_X", "onResponse: oops " + t + " " + call.request().url());
                            }
                        });
            }
        }.start();*/
    }

    @Override
    public void getdelegate(GitResponse response) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("num1", response);
        detailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frag_detail, detailFragment)
                .addToBackStack(detailFragment.getTag())
                .commit();
    }

    @Override
    public void displayList(Response<List<GitResponse>> response) {
        Log.d("TAG_X", "displayList: Response: " + response.body());
    }

    @Override
    public Context getContext() {
        return this;
    }
}