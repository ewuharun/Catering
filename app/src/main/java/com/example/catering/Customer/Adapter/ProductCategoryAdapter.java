package com.example.catering.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catering.Customer.DataModel.Category;
import com.example.catering.Customer.Listener.CategoryListener;
import com.example.catering.R;

import java.util.ArrayList;

/**
 * Created By Md.Harun or rashid on 10 th, aug,2021
 * MOBILE : 01531946638
 * UNiVERSITY : EWU (CSE)
 **/
public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ViewHolder> {

    private ArrayList<Category> categoryList;
    private Context context;
    private CategoryListener mListener;

    public ProductCategoryAdapter(ArrayList<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_listxml,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Category aCategory = categoryList.get(position);

        holder.tv_category_name.setText(aCategory.getCategory_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setListener(aCategory);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_category_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_category_name = itemView.findViewById(R.id.tv_category_name);
        }
    }

    public void setCategoryListener(CategoryListener mListener){
        if(mListener!=null){
            this.mListener = mListener;
        }
    }
}
