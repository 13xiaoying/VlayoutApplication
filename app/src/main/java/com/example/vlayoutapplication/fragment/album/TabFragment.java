package com.example.vlayoutapplication.fragment.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.vlayoutapplication.R;

public class TabFragment extends Fragment {
    private ImageView mTabImgIv;
    private TextView mTabTextTv;
    private ConstraintLayout mTabOutCl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_tab, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mTabImgIv = (ImageView) itemView.findViewById(R.id.iv_tab_img);
        mTabTextTv = (TextView) itemView.findViewById(R.id.tv_tab_text);
        mTabOutCl = (ConstraintLayout) itemView.findViewById(R.id.cl_tab_out);


    }
}