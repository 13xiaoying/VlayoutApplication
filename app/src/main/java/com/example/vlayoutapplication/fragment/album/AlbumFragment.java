package com.example.vlayoutapplication.fragment.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.vlayoutapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {
    private TabLayout mAlbumOutTl;
    private ViewPager mAlbumGerVp;
    private ArrayList<Object> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_album, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        list = new ArrayList<>();
        list.addAll(new )

        mAlbumOutTl.setupWithViewPager(mAlbumGerVp);

        mAlbumGerVp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return null;
            }

            @Override
            public int getCount() {
                return 0;
            }
        });
    }

    private void initView(@NonNull final View itemView) {
        mAlbumOutTl = (TabLayout) itemView.findViewById(R.id.tl_album_out);
        mAlbumGerVp = (ViewPager) itemView.findViewById(R.id.vp_album_ger);


    }
}