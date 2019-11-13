package com.example.homeworktask3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    private List<Cat> catList;

    public void setData(List<Cat> catList) {
        this.catList = catList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat, parent, false);
        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        final Cat catAtPosition = catList.get(position);

        holder.catNameTextView.setText(catAtPosition.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("CatID", catAtPosition.getId());
                context.startActivity(intent);
            }
        });


    }

    public int getItemCount() { return catList.size(); }

    public static class CatViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView catNameTextView;

        public CatViewHolder(View v) {
            super(v);
            view = v;
            catNameTextView = v.findViewById(R.id.catName);
        }
    }
}
