package test.bwie.com.dai.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import test.bwie.com.dai.R;
import test.bwie.com.dai.databinding.ActivityMvvMBinding;

public class MvvMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvv_m);
       ActivityMvvMBinding activityMvvMBinding =  DataBindingUtil.setContentView(this,R.layout.activity_mvv_m);
       activityMvvMBinding.setUser(new StudyBean("http://img04.sogoucdn.com/app/a/100520024/b71a1bfe0bbb176235e92cf3bf922f3a","renchaofng","10222"));
    }
}
