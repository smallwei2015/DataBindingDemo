package com.jash.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by jash
 * Date: 16-1-8
 * Time: 上午11:47
 */
public class BindingAdapter<T> extends BaseAdapter {
    private List<T> list;
    private int layoutId;
    private int bindingId;

    public BindingAdapter(List<T> list, int layoutId, int bindingId) {
        this.list = list;
        this.layoutId = layoutId;
        this.bindingId = bindingId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
            convertView = binding.getRoot();
        }
        ViewDataBinding binding = DataBindingUtil.getBinding(convertView);
        binding.setVariable(bindingId, list.get(position));
        return convertView;
    }
}
