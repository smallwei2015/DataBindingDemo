package com.jash.databindingdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jash
 * Date: 16-1-8
 * Time: 上午9:31
 */
public class User extends BaseObservable{
    @Bindable
    private String name;
    private String email;
    private String phone;
    private String icon;
    private BindingAdapter<User> adapter;
    public User(String name, String email, String phone, String icon, Context context) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.icon = icon;
        if (context != null) {
            List<User> list = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                list.add(new User(String.format("人物%d", i), null, String.format("186%08d", i), null, null));
            }
            adapter = new BindingAdapter<>(list, R.layout.item, com.jash.databindingdemo.BR.user);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.jash.databindingdemo.BR.name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BindingAdapter<User> getAdapter() {
        return adapter;
    }

    public void setAdapter(BindingAdapter<User> adapter) {
        this.adapter = adapter;
    }

    public void clickIcon(View view){
        Toast.makeText(view.getContext(), "点击头像", Toast.LENGTH_SHORT).show();
        setName("Jash");
    }
    public void clickName(View view){
        Toast.makeText(view.getContext(), "点击名字", Toast.LENGTH_SHORT).show();
    }
    public boolean longClickName(View v){
        Toast.makeText(v.getContext(), "长击名字", Toast.LENGTH_SHORT).show();
        return true;
    }
    public void itemClick(AdapterView<?> adapterView, View view, int position, long id){
//        Toast.makeText(view.getContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
