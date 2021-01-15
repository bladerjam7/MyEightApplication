package com.americanairlines.myeightapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.americanairlines.myeightapplication.R;
import com.americanairlines.myeightapplication.model.GitResponse;
import com.americanairlines.myeightapplication.presenter.GitPresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailFragment extends Fragment {

    public TextView tvAuthor, tvCommit, tvRepoTitle;
    public ImageView imAvatar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imAvatar = view.findViewById(R.id.im_avatar);
        tvAuthor = view.findViewById(R.id.tv_author);
        tvCommit = view.findViewById(R.id.tv_commit);
        tvRepoTitle = view.findViewById(R.id.tv_repo_title);

        /*GitResponse response = getArguments().getParcelable("num1");

        Glide.with(getContext())
                .setDefaultRequestOptions(RequestOptions.circleCropTransform())
                .load(response.getOwner().getAvatarUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(imAvatar);

        tvAuthor.setText(response.getOwner().getLogin());
        tvCommit.setText(response.getCommentsUrl());
        tvRepoTitle.setText(response.getName());*/
    }

}
