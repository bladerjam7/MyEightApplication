package com.americanairlines.myeightapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.americanairlines.myeightapplication.R;
import com.americanairlines.myeightapplication.model.GitResponse;

import java.util.List;

public class GitAdapterRV extends RecyclerView.Adapter<GitAdapterRV.GitViewHolder> {

    private List<GitResponse> responeseList;
    private GetDelegate delegate;

    public interface GetDelegate{
        void getdelegate(GitResponse responseList);
    }

    public GitAdapterRV(List<GitResponse> responeseList, GetDelegate delegate) {
        this.responeseList = responeseList;
        this.delegate = delegate;
    }

    @NonNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GitViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_git_responese, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder holder, int position) {
        holder.tv.setText(responeseList.get(position).getName());

        holder.itemView.setOnClickListener(v-> {
            delegate.getdelegate(responeseList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return responeseList.size();
    }

    class GitViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public GitViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv_response);
        }
    }

    public void getUpdate(List<GitResponse> responeseList){
        this.responeseList = responeseList;
        notifyDataSetChanged();
    }
}
