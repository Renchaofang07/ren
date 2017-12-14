package test.bwie.com.dai.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import test.bwie.com.dai.R;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        TextView tv = findViewById(R.id.tvvv);
        App application = (App)getApplication();
        EventBus.getDefault().register(this);//订阅

        final String name = application.getName();
        Log.i("xxx",name);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventUtil(name));
                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Subscribe
    public void onEvent(EventUtil event){
        String msg = event.getName();
        Log.i("sssppkk",msg);
        //this.showMsgTv = (TextView) findViewById(R.id.tv_printer);
        //this.showMsgTv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

