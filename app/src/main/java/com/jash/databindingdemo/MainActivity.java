package com.jash.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jash.databindingdemo.databinding.MainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DataBindingUtil.setDefaultComponent(new MyComponent());
        MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(new User(null, "jash@163.com", null, "https://developer.android.com/assets/images/android_logo.png", this));
//        binding.setVariable(com.jash.databindingdemo.BR.user, new User("jash", "jash@163.com", "18600000000"));
    }
}
