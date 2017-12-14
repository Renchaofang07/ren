package test.bwie.com.dai;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {


    private List<String> stringList =new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tablay);
            stringList.add("身份证认证");
            stringList.add("完善资料");
            stringList.add("申请贷款");
        ShengFenFragment shengFenFragment = new ShengFenFragment();
        SuccessFragment successFragment = new SuccessFragment();
        ShengQingFragment shengQingFragment = new ShengQingFragment();
                fragmentList.add(shengFenFragment);
                fragmentList.add(successFragment);
                fragmentList.add(shengQingFragment);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(stringList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(stringList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(stringList.get(2)));
        //获得fragment的管理者
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        //进行viewpager的数据适配器
        viewPager.setAdapter(new FragmentAdapter(supportFragmentManager));
        //进行关联
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(new FragmentAdapter(supportFragmentManager));
    }
    class FragmentAdapter extends FragmentPagerAdapter {
        //进行数据的一一对应
        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}
