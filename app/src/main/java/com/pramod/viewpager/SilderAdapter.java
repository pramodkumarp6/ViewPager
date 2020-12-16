package com.pramod.viewpager;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SilderAdapter extends PagerAdapter {
    private ArrayList<CarsModel> carsModelArrayList;
    private Context context;

    public SilderAdapter(ArrayList<CarsModel> carsModelArrayList, Context context) {
        this.carsModelArrayList = carsModelArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return carsModelArrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.cars_list_item,container,false);
        ImageView image = view.findViewById(R.id.imageView);

       Picasso.get().load(carsModelArrayList.get(position).getImage()).into(image);


        container.addView(view ,0 );


        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
