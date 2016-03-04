package com.fenyou.page.androidstu.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.fenyou.page.androidstu.R;
import com.fenyou.page.androidstu.interfaces.BottomPanelCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2016/3/4.
 */
public class BottomControlPanel extends RelativeLayout implements View.OnClickListener{

    public BottomPanelCallback bottomPanelCallback;
    protected static int DEFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243);
    public ImageText messBtn = null;
    public ImageText contactsBtn = null;
    public ImageText newBtn = null;
    public ImageText setBtn = null;
    public List<ImageText> imageList = new ArrayList<ImageText>();
    public BottomControlPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void initBottomPanel(){

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        messBtn = (ImageText)findViewById(R.id.btn_message);
        contactsBtn = (ImageText)findViewById(R.id.btn_contacts);
        newBtn = (ImageText)findViewById(R.id.btn_news);
        setBtn = (ImageText)findViewById(R.id.btn_setting);
        setBackgroundColor(DEFALUT_BACKGROUND_COLOR);
        imageList.add(messBtn);
        imageList.add(contactsBtn);
        imageList.add(newBtn);
        imageList.add(setBtn);
    }

    @Override
    public void onClick(View v) {
        if(null!=messBtn){

        }

    }

    public BottomPanelCallback getBottomPanelCallback() {
        return bottomPanelCallback;
    }

    public void setBottomPanelCallback(BottomPanelCallback bottomPanelCallback) {
        this.bottomPanelCallback = bottomPanelCallback;
    }
}
