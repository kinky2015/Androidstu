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
public class ContactsFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contactsLayout = inflater.inflate(R.layout.contacts_layout,
                container, false);
        return contactsLayout;
    }



    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        MainActivity.currFragTag = Constant.FRAGMENT_FLAG_CONTACTS;
    }
}
