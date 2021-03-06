package com.example.vlayoutapplication.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.vlayoutapplication.R;
import com.example.vlayoutapplication.base.BaseMainActivity;
import com.example.vlayoutapplication.bean.HomeBannerBean;
import com.example.vlayoutapplication.contract.HomeContract;
import com.example.vlayoutapplication.fragment.album.AlbumFragment;
import com.example.vlayoutapplication.fragment.home.HomeFragment;
import com.example.vlayoutapplication.fragment.my.MyFragment;
import com.example.vlayoutapplication.fragment.shopping.ShoppingFragment;
import com.example.vlayoutapplication.fragment.sort.SortFragment;
import com.example.vlayoutapplication.presenter.HomePresenter;

public class MainActivity extends BaseMainActivity<HomePresenter> implements View.OnClickListener, HomeContract.CHomeView {

    /**
     * 首页
     */
    private RadioButton mButtonOne;
    /**
     * 专题
     */
    private RadioButton mButtonTwo;
    /**
     * 分类
     */
    private RadioButton mButtonThree;
    /**
     * 购物车
     */
    private RadioButton mButtonFour;
    /**
     * 我的
     */
    private RadioButton mButtonFive;
    private RadioGroup mRadio;
    private ViewPager mVpMainGer;
    private LinearLayout mLlMainOut;
    private HomeFragment homeFragment;
    private AlbumFragment albumFragment;
    private MyFragment myFragment;
    private ShoppingFragment shoppingFragment;
    private SortFragment sortFragment;
    private FragmentManager manager;

    @Override
    public void initDate() {
        presenter.Result();
        presenter.Result();
        homeFragment = new HomeFragment();
        albumFragment = new AlbumFragment();
        myFragment = new MyFragment();
        shoppingFragment = new ShoppingFragment();
        sortFragment = new SortFragment();

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.ll_main_out, homeFragment)
                .add(R.id.ll_main_out, albumFragment)
                .add(R.id.ll_main_out, sortFragment)
                .add(R.id.ll_main_out, shoppingFragment)
                .add(R.id.ll_main_out, myFragment)
                .show(homeFragment)
                .hide(albumFragment)
                .hide(sortFragment)
                .hide(shoppingFragment)
                .hide(myFragment)
                .commit();

    }

    @Override
    public int getIcount() {
        return R.layout.activity_main;
    }

    @Override
    public HomePresenter getInterface() {
        return new HomePresenter();
    }
    @Override
    public void initView() {
        mLlMainOut = (LinearLayout) findViewById(R.id.ll_main_out);
        mButtonOne = (RadioButton) findViewById(R.id.button_one);
        mButtonTwo = (RadioButton) findViewById(R.id.button_two);
        mButtonThree = (RadioButton) findViewById(R.id.button_three);
        mButtonFour = (RadioButton) findViewById(R.id.button_four);
        mButtonFive = (RadioButton) findViewById(R.id.button_five);
        mRadio = (RadioGroup) findViewById(R.id.radio);
        mButtonOne.setOnClickListener(this);
        mButtonTwo.setOnClickListener(this);
        mButtonThree.setOnClickListener(this);
        mButtonFour.setOnClickListener(this);
        mButtonFive.setOnClickListener(this);
        mRadio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button_one:
                manager.beginTransaction()
                        .show(homeFragment)
                        .hide(albumFragment)
                        .hide(sortFragment)
                        .hide(shoppingFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.button_two:
                manager.beginTransaction()
                        .show(sortFragment)
                        .hide(homeFragment)
                        .hide(albumFragment)
                        .hide(shoppingFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.button_three:
                manager.beginTransaction()
                        .show(albumFragment)
                        .hide(sortFragment)
                        .hide(homeFragment)
                        .hide(shoppingFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.button_four:
                manager.beginTransaction()
                        .show(shoppingFragment)
                        .hide(albumFragment)
                        .hide(sortFragment)
                        .hide(homeFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.button_five:
                manager.beginTransaction()
                        .show(myFragment)
                        .hide(albumFragment)
                        .hide(sortFragment)
                        .hide(shoppingFragment)
                        .hide(homeFragment)
                        .commit();
                break;
        }
    }

    @Override
    public void onInit(HomeBannerBean bean) {

    }
    @Override
    public void onError(String error) {

    }
}