package com.example.projectasg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomePage extends AppCompatActivity {

    PagerAdapter pagerAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(pagerAdapter.getFragmentTitle(position))).attach();


    }

    private void setViewPager2(ViewPager2 viewPager2) {
        if(pagerAdapter == null){
            pagerAdapter = new PagerAdapter(this);
            pagerAdapter.addFragment(new HomeFragment(), "Home");
            pagerAdapter.addFragment(new TransactionFragment(), "Transaction");
            viewPager2.setAdapter(pagerAdapter);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.logoutMenuItem:
                if (id == R.id.logoutMenuItem) {
                    showLogoutConfirmationDialog();
                    return true;
                }

            case R.id.aboutus:
                Intent intent = new Intent(this, AboutUs.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();


    }


}