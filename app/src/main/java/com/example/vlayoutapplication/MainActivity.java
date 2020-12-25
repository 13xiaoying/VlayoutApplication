package com.example.vlayoutapplication;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initDate() {
        
    }

    private void initView() {
        mLlMainOut = (LinearLayout) findViewById(R.id.ll_main_out);
        mButtonOne = (RadioButton) findViewById(R.id.button_one);
        mButtonTwo = (RadioButton) findViewById(R.id.button_two);
        mButtonThree = (RadioButton) findViewById(R.id.button_three);
        mButtonFour = (RadioButton) findViewById(R.id.button_four);
        mButtonFive = (RadioButton) findViewById(R.id.button_five);
        mRadio = (RadioGroup) findViewById(R.id.radio);
    }
}