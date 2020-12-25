package com.example.vlayoutapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.vlayoutapplication.R;

public class HomeFragment extends Fragment {
    private ImageView mMainImgIv;
    private TextView mMainTextTv;
    private LinearLayout mHomeOutLl;
    private RecyclerView mViewHomeRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {

    }

    private void initView(@NonNull final View itemView) {
        mMainImgIv = (ImageView) itemView.findViewById(R.id.iv_main_img);
        mMainTextTv = (TextView) itemView.findViewById(R.id.tv_main_text);
        mHomeOutLl = (LinearLayout) itemView.findViewById(R.id.ll_home_out);
        mViewHomeRv = (RecyclerView) itemView.findViewById(R.id.rv_view_home);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());

        mViewHomeRv.setLayoutManager(virtualLayoutManager);


    }
}