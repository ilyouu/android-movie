package com.example.movieproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject.R;
import com.example.movieproject.model.AllCategory;
import com.example.movieproject.model.CategoryItem;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {

    Context context;
    List<AllCategory> allCategoryList;

    public MainRecyclerViewAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recylerview_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.categoryName.setText(allCategoryList.get(position).getCategoryTitle());
        setItemRecyclerView(holder.itemRecyclerView, allCategoryList.get(position).getCategoryItemList());

    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;
        RecyclerView itemRecyclerView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.item_category);
            itemRecyclerView = itemView.findViewById(R.id.item_recyclerview);

        }
    }

    private void setItemRecyclerView(RecyclerView recyclerView, List<CategoryItem> categoryItemList){
        ItemRecylerViewAdapter itemRecylerViewAdapter = new ItemRecylerViewAdapter(context, categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecylerViewAdapter);
    }
}
