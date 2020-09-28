package com.example.id.ac.binus.volutry.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.id.ac.binus.volutry.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {
    private int[] MultipleImages = new int[]{
            R.drawable.iv_gambar1, R.drawable.iv_gambar2, R.drawable.iv_gambar3,
    };
    private int[] ViewImages = new int[]{
            R.drawable.iv_u144,
            R.drawable.iv_u145,
            R.drawable.iv_u146,
            R.drawable.iv_u148
    };
    private String[] MultipleImagesTitle = new String[]{
            "Join India Forest Fire Volunteering",
            "Volunteer in Indonesia Flood Program",
            "Help African Children From Starvation"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //CarouselView
        View ViewAll = inflater.inflate(R.layout.fragment_home, container, false);
        final CarouselView CarouselView = (CarouselView)ViewAll.findViewById(R.id.car_headline);

        CarouselView.setPageCount(MultipleImages.length);

        CarouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(MultipleImages[position]);
            }
        });

        CarouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
//                Toast.makeText(HomeFragment.this, MultipleImagesTitle[position], Toast.LENGTH_SHORT).show();
            }
        });

        //HorrizontalScrollView
        LinearLayout gallery = (LinearLayout)ViewAll.findViewById(R.id.gallery);

        LayoutInflater InflaterView = LayoutInflater.from(getActivity());

        for(int i = 0; i < ViewImages.length; i++){
            View view = InflaterView.inflate(R.layout.item, gallery, false);
            ImageView NewImageView = view.findViewById(R.id.imageView);
            NewImageView.setImageResource(ViewImages[i]);

            gallery.addView(view);
        }
        return ViewAll;
    }

}
