package com.example.jobsquare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobsquare.Entity.Category;

import java.util.ArrayList;

public class ExAdapter extends RecyclerView.Adapter<ExAdapter.ExampleViewHolder> {
    private ArrayList<Category> categoryList;

    class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ExampleViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.categoryName);
        }
    }

    public ExAdapter(ArrayList<Category> cateList){
        categoryList= cateList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Category currentItem = categoryList.get(position);

        holder.name.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
