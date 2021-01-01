package com.example.vlayoutapplication.fragment.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.bean.SortBean;

import java.util.ArrayList;

public class SortFragment extends Fragment {
    private RecyclerView mViewSortRv;
    private RadioButton mPreviousPageButton;
    private RadioButton mNextPageButton;
    private RadioGroup mRadio;
    private ArrayList<SortBean.DataBeanX.DataBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_sort, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mViewSortRv = (RecyclerView) itemView.findViewById(R.id.rv_view_sort);
        mPreviousPageButton = (RadioButton) itemView.findViewById(R.id.button_previous_page);
        mNextPageButton = (RadioButton) itemView.findViewById(R.id.button_next_page);
        mRadio = (RadioGroup) itemView.findViewById(R.id.radio);

        list = new ArrayList<>();
    }
}