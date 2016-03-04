package com.fenyou.page.androidstu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.fenyou.page.androidstu.adapter.BaseFragment;
import com.fenyou.page.androidstu.constant.Constant;
import com.fenyou.page.androidstu.interfaces.BottomPanelCallback;
import com.fenyou.page.androidstu.ui.BottomControlPanel;
import com.fenyou.page.androidstu.ui.HeadControlPanel;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends ActionBarActivity implements BottomPanelCallback {

    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private BottomControlPanel bottomControlPanel = null;
    private HeadControlPanel headControlPanel=null;
    public static String currFragTag = "";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        fragmentManager = getFragmentManager();
        setDefaultFirstFragment(Constant.FRAGMENT_FLAG_MESSAGE);
    }

    private void initUI() {
        bottomControlPanel = (BottomControlPanel)findViewById(R.id.bottom_layout);
        if(bottomControlPanel==null){
            bottomControlPanel.initBottomPanel();
        }
        headControlPanel = (HeadControlPanel)findViewById(R.id.head_layout);
        if(headControlPanel == null){
            headControlPanel.initHeadPanel();
        }
    }

    @Override
    public void onBottomPanelClick(int itemId) {
        String tag = "";
        if((itemId & Constant.BTN_FLAG_MESSAGE) != 0){
            tag = Constant.FRAGMENT_FLAG_MESSAGE;
        }else if((itemId & Constant.BTN_FLAG_CONTACTS) != 0){
            tag = Constant.FRAGMENT_FLAG_CONTACTS;
        }else if((itemId & Constant.BTN_FLAG_NEWS) != 0){
            tag = Constant.FRAGMENT_FLAG_NEWS;
        }else if((itemId & Constant.BTN_FLAG_SETTING) != 0){
            tag = Constant.FRAGMENT_FLAG_SETTING;
        }
        setTabSelection(tag);
        headControlPanel.setMiddleTitle(tag);
    }
    private void setDefaultFirstFragment(String tag){
        Log.i("yan", "setDefaultFirstFragment enter... currFragTag = " + currFragTag);
        setTabSelection(tag);
        bottomControlPanel.defaultBtnChecked();
        Log.i("yan", "setDefaultFirstFragment exit...");
    }
    public  void setTabSelection(String tag) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switchFragment(tag);
    }
    private  void switchFragment(String tag){
        if(TextUtils.equals(tag, currFragTag)){
            return;
        }
        if(currFragTag != null && !currFragTag.equals("")){
            detachFragment(getFragment(currFragTag));
        }
        attachFragment(R.id.fragment_content, getFragment(tag), tag);
        commitTransactions(tag);
    }
    private void detachFragment(Fragment f){

        if(f != null && !f.isDetached()){
            ensureTransaction();
            fragmentTransaction.detach(f);
        }
    }
    private FragmentTransaction ensureTransaction( ){
        if(fragmentTransaction == null){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        }
        return fragmentTransaction;
    }
    private Fragment getFragment(String tag){

        Fragment f = fragmentManager.findFragmentByTag(tag);

        if(f == null){
            Toast.makeText(getApplicationContext(), "fragment = null tag = " + tag, Toast.LENGTH_SHORT).show();
            f = BaseFragment.newInstance(getApplicationContext(), tag);
        }
        return f;
    }
    private void attachFragment(int layout, Fragment f, String tag){
        if(f != null){
            if(f.isDetached()){
                ensureTransaction();
                fragmentTransaction.attach(f);

            }else if(!f.isAdded()){
                ensureTransaction();
                fragmentTransaction.add(layout, f, tag);
            }
        }
    }
    private void commitTransactions(String tag){
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
            currFragTag = tag;
            fragmentTransaction = null;
        }
    }
}
