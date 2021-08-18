package com.example.catering.Customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catering.Customer.Fragments.CustomerCartFragment;
import com.example.catering.Customer.Fragments.CustomerHomeFragment;
import com.example.catering.Customer.Fragments.CustomerOrderFragment;
import com.example.catering.Customer.Fragments.CustomerProfileFragment;
import com.example.catering.Customer.Fragments.CustomerTrackFragment;
import com.example.catering.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class CustomerMainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;



    private Toolbar toolbar;
    private DrawerLayout mDrawer;
    private ImageView iv_drawer_menu;
    private TextView pageTitleTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);
        initView();

        setBottomNavigation();

        setSupportActionBar(toolbar);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        initListener();
        startCustomerHomeFragment();


    }

    private void initListener() {
        iv_drawer_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDrawer.isDrawerOpen(GravityCompat.START)){
                    mDrawer.closeDrawer(GravityCompat.START);
                }else{
                    mDrawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    private void startCustomerHomeFragment() {
        Fragment fragment = null;
        fragment = new CustomerHomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment_container,fragment).commit();

    }

    private void setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new CustomerHomeFragment();
                        pageTitleTv.setText("HOME");

                        break;
                    case R.id.cart:
                        fragment = new CustomerCartFragment();
                        pageTitleTv.setText("CART");
                        break;
                    case R.id.order:
                        fragment = new CustomerOrderFragment();
                        pageTitleTv.setText("ORDER");
                        break;
                    case R.id.track:
                        fragment = new CustomerTrackFragment();
                        pageTitleTv.setText("TRACK");
                        break;
                    case R.id.profile:
                        fragment = new CustomerProfileFragment();
                        pageTitleTv.setText("PROFILE");
                        break;
                }

                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
            return true;
        }
        return false;

    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        toolbar = findViewById(R.id.toolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        pageTitleTv=findViewById(R.id.pageTitleTv);
        iv_drawer_menu=findViewById(R.id.drawer_menu_iv);

    }

    @Override
    public void onBackPressed() {
        if(mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }
}