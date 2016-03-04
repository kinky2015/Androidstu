package com.fenyou.page.androidstu.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fenyou.page.androidstu.MainActivity;
import com.fenyou.page.androidstu.R;
import com.fenyou.page.androidstu.constant.Constant;

/**
 * Created by jack on 2016/3/4.
 */
public class NewsFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View newsLayout = inflater.inflate(R.layout.news_layout, container,
                false);
        return newsLayout;
    }


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_NEWS;
    }
}
