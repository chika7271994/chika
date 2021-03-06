package com.example.kakeibo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.kakeibo.R;
import com.example.kakeibo.fragments.KakeiboFragment;

//BaseActivityとする

public class KakeiboListActivity extends AppCompatActivity {

    private String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_kakeibo);

        Intent intent = getIntent();
        currentDate = intent.getStringExtra("date");

        //フラグメントを表示
        addFragment(KakeiboFragment.newInstance(currentDate));
    }

    public void addFragment(Fragment fragment){
        final String aaa = fragment.getClass().getName();
        final String bbb = aaa.substring(aaa.lastIndexOf(".")+ 1);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.show_kakeibo_pg, fragment, bbb)
                .disallowAddToBackStack()
                .commit();
    }

    public void replaceFragment(Fragment fragment){
        final String aaa = fragment.getClass().getName();
        final String bbb = aaa.substring(aaa.lastIndexOf(".") + 1);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.show_kakeibo_pg, fragment, bbb)
                .commit();
    }
}