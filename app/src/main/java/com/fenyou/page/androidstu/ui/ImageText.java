package com.fenyou.page.androidstu.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fenyou.page.androidstu.R;
import com.fenyou.page.androidstu.constant.Constant;

/**
 * Created by jack on 2016/3/4.
 */
public class ImageText extends LinearLayout {
    private Context mContext = null;
    private ImageView mImageView = null;
    private TextView mTextView = null;
    private final static int DEFAULT_IMAGE_WIDTH = 64;
    private int CHECKED_COLOR = Color.rgb(29, 118, 199);
    private final static int DEFAULT_IMAGE_HEIGHT = 64;
    private int UNCHECKED_COLOR = Color.GRAY;
    public ImageText(Context context) {
        super(context);
        mContext = context;
    }
    public ImageText(Context context, AttributeSet attrs) {
        super(context,attrs);
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.image_text_layout, this, true);
        mImageView = (ImageView)findViewById(R.id.image_iamge_text);
        mTextView = (TextView)findViewById(R.id.text_iamge_text);
    }
    public void setImage(int id){
        if(mImageView != null){
            mImageView.setImageResource(id);
           setImageSize(DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
        }
    }
    private void setImageSize(int w, int h){
        if(mImageView != null){
            ViewGroup.LayoutParams params = mImageView.getLayoutParams();
            params.width = w;
            params.height = h;
            mImageView.setLayoutParams(params);
        }
    }
    public void setText(String s){
        if(mTextView != null){
            mTextView.setText(s);
            mTextView.setTextColor(UNCHECKED_COLOR);
        }
    }

    public void setChecked(int itemID) {
        if(mTextView != null){
            mTextView.setTextColor(CHECKED_COLOR);
        }
        int checkDrawableId = -1;
        switch (itemID){
            case Constant.BTN_FLAG_MESSAGE:
                checkDrawableId = R.drawable.message_selected;
                break;
            case Constant.BTN_FLAG_CONTACTS:
                checkDrawableId = R.drawable.contacts_selected;
                break;
            case Constant.BTN_FLAG_NEWS:
                checkDrawableId = R.drawable.news_selected;
                break;
            case Constant.BTN_FLAG_SETTING:
                checkDrawableId = R.drawable.setting_selected;
                break;
            default:break;
        }
        if(mImageView != null){
            mImageView.setImageResource(checkDrawableId);
        }
    }
}
