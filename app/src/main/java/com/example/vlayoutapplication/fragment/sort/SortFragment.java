package com.example.vlayoutapplication.fragment.sort;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.base.BaseFragment;
import com.example.vlayoutapplication.bean.SortBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.contract.SortContract;
import com.example.vlayoutapplication.presenter.HomePresenter;
import com.example.vlayoutapplication.presenter.SortPresenter;
import com.example.vlayoutapplication.sortmadapter.SortMadapter;

import java.util.ArrayList;
import java.util.List;

public class SortFragment extends BaseFragment<SortPresenter> implements SortContract.CSortView  {
    private RecyclerView mViewSortRv;
    private RadioButton mPreviousPageButton;
    private RadioButton mNextPageButton;
    private RadioGroup mRadio;
    private int id=1;
    private ArrayList<SortBean.DataBeanX.DataBean> list;
    private SortMadapter sortMadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_sort, container, false);
        initView(inflate);
        return inflate;
    }
    @Override
    public void initView(@NonNull final View itemView) {
        mViewSortRv = (RecyclerView) itemView.findViewById(R.id.rv_view_sort);
        mPreviousPageButton = (RadioButton) itemView.findViewById(R.id.button_previous_page);
        mNextPageButton = (RadioButton) itemView.findViewById(R.id.button_next_page);
        mRadio = (RadioGroup) itemView.findViewById(R.id.radio);

        list = new ArrayList<>();
        sortMadapter = new SortMadapter(getActivity(), list);
        mViewSortRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewSortRv.setAdapter(sortMadapter);

        mPreviousPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list!=null){
                    list.clear();
                    id=1;
                    presenter.Result(id);
                }
            }
        });
        mNextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list!=null){
                    list.clear();
                    id=2;
                    presenter.Result(id);
                }
            }
        });
    }

    @Override
    public void initDate() {
        presenter.Result(id);
    }

    @Override
    public int getIcount() {
        return R.layout.fragment_sort;
    }

    @Override
    public SortPresenter getInterface() {
        return new SortPresenter();
    }

    @Override
    public void onInit(SortBean bean) {
        List<SortBean.DataBeanX.DataBean> data = bean.getData().getData();
        list.addAll(data);
        sortMadapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Log.i(TAG, "onError: sort错误信息"+error);
    }

    private static final String TAG = "SortFragment";
}