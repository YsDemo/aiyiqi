package aiyiqi.bwf.com.aiyiqi_lf.gui.activity;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.R;
import aiyiqi.bwf.com.aiyiqi_lf.gui.adapter.MainFragmentAdapter;
import aiyiqi.bwf.com.aiyiqi_lf.gui.fragment.HomeFragment;
import aiyiqi.bwf.com.aiyiqi_lf.gui.fragment.MineFragment;
import aiyiqi.bwf.com.aiyiqi_lf.gui.fragment.MsgFragment;
import aiyiqi.bwf.com.aiyiqi_lf.gui.fragment.OwnerSaidFragment;

public class HomeActivity extends BaseActivity {
    private FragmentTabHost fragmentTabHost;

    private int imageArrsDefault []
            = {R.drawable.main_tab_home_normal,R.drawable.main_tab_community_normal,
            R.drawable.main_tab_msg_normal,R.drawable.main_tab_my_normal};

    private int imageArrsSelected []
            ={R.drawable.main_tab_home_selected,R.drawable.main_tab_home_selected,
            R.drawable.main_tab_community_selected,R.drawable.main_tab_my_selected};

    private String tabNameArrays[] = {"首页","业主说","消息","我的"};

    private Class fragmentArrays []
            = {HomeFragment.class,HomeFragment.class, HomeFragment.class,HomeFragment.class};

    ImageView imageView;
    TextView textView;
    private TabWidget tabWidget;

    private List<Fragment> fragments;
    private HomeFragment homeFragment ;
    private OwnerSaidFragment ownerSaidFragment;
    private MineFragment mineFragment;
    private MsgFragment msgFragment;

    private MainFragmentAdapter fragmentAdapter;
    @Override
    protected void initDatas() {

    }

    @Override
    protected void initView() {
        fragmentTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);

        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.main_frame);
        tabWidget = fragmentTabHost.getTabWidget();
        tabWidget.setDividerDrawable(null);
        for (int i = 0; i < imageArrsDefault.length; i++) {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabNameArrays[i]).setIndicator(getView(i));
            fragmentTabHost.addTab(tabSpec, fragmentArrays[i], null);
        }

        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        fragments = getFragments();
//        HomeFragment homeFragment = new HomeFragment();
//        transaction.add(R.id.main_frame,homeFragment);
//        transaction.add(fragments)
//        fragmentAdapter = new MainFragmentAdapter(getFragments(),manager);
        transaction.show(fragments.get(0));

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabName) {

                for (int i = 0; i < imageArrsDefault.length; i++) {
                    transaction.add(R.id.main_frame,fragments.get(i));

                    View view = tabWidget.getChildTabViewAt(i);
                    TextView textView = (TextView) view.findViewById(R.id.home_tabhost_textview);
                    ImageView imageView = (ImageView) view.findViewById(R.id.home_tabhost_image);
                    if (tabName.equals(textView.getText().toString())) {//点击的tab
                        textView.setTextColor(Color.GREEN);
                        imageView.setImageResource(imageArrsSelected[i]);
                        transaction.show(fragments.get(i));
                    } else {
                        textView.setTextColor(Color.BLACK);
                        imageView.setImageResource(imageArrsDefault[i]);
                        transaction.hide(fragments.get(i));
                    }
                }
            }
        });
        transaction.commit();
    }




    public View getView(int index){
        View view = getLayoutInflater().inflate(R.layout.home_tabhost,null);
        imageView = (ImageView) view.findViewById(R.id.home_tabhost_image);
        textView = (TextView) view.findViewById(R.id.home_tabhost_textview);

        if (index == 0) {
            textView.setTextColor(Color.GREEN);
            imageView.setImageResource(imageArrsSelected[0]);
        }else{
            imageView.setImageResource(imageArrsDefault[index]);
            textView.setText(tabNameArrays[index]);
            textView.setTextColor(Color.BLACK);
        }
        return view;
    }

    public List<Fragment> getFragments() {
        fragments = new ArrayList<>();
        homeFragment = new HomeFragment();
        ownerSaidFragment = new OwnerSaidFragment();
        msgFragment = new MsgFragment();
        mineFragment = new MineFragment();
        fragments.add(homeFragment);
        fragments.add(ownerSaidFragment);
        fragments.add(msgFragment);
        fragments.add(mineFragment);
        return fragments;
    }


    @Override
    public int getContentView() {
        return R.layout.main_activity;
    }
}
