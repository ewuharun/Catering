package com.example.catering.Customer.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.catering.Customer.Adapter.ProductCategoryAdapter;
import com.example.catering.Customer.DataModel.Category;
import com.example.catering.Customer.Listener.CategoryListener;
import com.example.catering.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;


public class CustomerHomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView rv_product_category;
    private ArrayList<Category> categoryList;
    private ProductCategoryAdapter adapter;
    private TextView pageTitleTv;
    private SwipeRefreshLayout swipeRefreshLayout;

    private DatabaseReference databaseReference;



    public CustomerHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_customer_home, container, false);

        initView(view);
        initVariable();

        swipeRefreshLayout.setOnRefreshListener(this);

        populateCategoryRecyclearView(view);

        return view;
    }


    @SuppressLint("WrongConstant")
    private void populateCategoryRecyclearView(View view) {

        categoryList.add(new Category(1,"Shirt","Samsung is my favourite",60));
        categoryList.add(new Category(2,"Pant","Samsung is my favourite",60));
        categoryList.add(new Category(3,"Biscuit","Samsung is my favourite",60));
        categoryList.add(new Category(4,"Phone","Samsung is my favourite",60));
        categoryList.add(new Category(5,"Rice","Samsung is my favourite",60));
        categoryList.add(new Category(6,"Drinks","Samsung is my favourite",60));

        categoryList.add(new Category(1,"Shirt","Samsung is my favourite",60));
        categoryList.add(new Category(2,"Pant","Samsung is my favourite",60));
        categoryList.add(new Category(3,"Biscuit","Samsung is my favourite",60));
        categoryList.add(new Category(4,"Phone","Samsung is my favourite",60));
        categoryList.add(new Category(5,"Rice","Samsung is my favourite",60));
        categoryList.add(new Category(6,"Drinks","Samsung is my favourite",60));

        categoryList.add(new Category(1,"Shirt","Samsung is my favourite",60));
        categoryList.add(new Category(2,"Pant","Samsung is my favourite",60));
        categoryList.add(new Category(3,"Biscuit","Samsung is my favourite",60));
        categoryList.add(new Category(4,"Phone","Samsung is my favourite",60));
        categoryList.add(new Category(5,"Rice","Samsung is my favourite",60));
        categoryList.add(new Category(6,"Drinks","Samsung is my favourite",60));

        adapter = new ProductCategoryAdapter(categoryList,getContext());
        rv_product_category.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL,false));
        rv_product_category.setAdapter(adapter);
        adapter.setCategoryListener(new CategoryListener() {
            @Override
            public void setListener(Category category) {
                Toast.makeText(getContext(), "item clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initVariable() {
        categoryList = new ArrayList<>();
    }

    private void initView(View view) {
        rv_product_category = view.findViewById(R.id.rv_product_category);
        pageTitleTv = view.findViewById(R.id.pageTitleTv);
        swipeRefreshLayout=view.findViewById(R.id.swipeRefreshLayout);

    }

    @Override
    public void onRefresh() {

        fetchCategoryData();
    }

    private void fetchCategoryData() {
        swipeRefreshLayout.setRefreshing(true);
        //fetch the data from the server and update the list
        Toast.makeText(getContext(), "Data is loaded", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();

        swipeRefreshLayout.setRefreshing(false);
    }
}