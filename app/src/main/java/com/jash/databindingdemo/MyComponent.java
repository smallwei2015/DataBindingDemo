package com.jash.databindingdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by jash
 * Date: 16-1-8
 * Time: 上午9:46
 */
public class MyComponent {
    @BindingAdapter("bind:imageURL")
    public static void loadImage(ImageView image, String url){
        Picasso.with(image.getContext()).load(url).into(image);
    }
}
