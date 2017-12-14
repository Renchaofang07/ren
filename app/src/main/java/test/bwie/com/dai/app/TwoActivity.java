package test.bwie.com.dai.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import test.bwie.com.dai.R;

public class TwoActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tv = findViewById(R.id.tvvvvv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);//订阅


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().post(new EventUtil("小芳"));

    }


    @Subscribe
    public void onEvent(EventUtil event){
        String msg = event.getName();
        Log.i("sss",msg);
        //this.showMsgTv = (TextView) findViewById(R.id.tv_printer);
        //this.showMsgTv.setText(msg);
        tv.setText(event.getName());
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
