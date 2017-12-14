package test.bwie.com.dai.app;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by 1 on 2017/12/8.
 */

public class App extends Application {
    private String name;

    @Override
    public void onCreate() {
        super.onCreate();
        setName("任超芳");

        EventBus.getDefault().register(this);//订阅



    }
   /* @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventUtil evnt)
    {
        String msg = evnt.getName();
        //this.showMsgTv = (TextView) findViewById(R.id.tv_printer);
        //this.showMsgTv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }*/

      @Subscribe
    public void onEvent(EventUtil event){
        String msg = event.getName();
        Log.i("ssspp",msg);
        //this.showMsgTv = (TextView) findViewById(R.id.tv_printer);
        //this.showMsgTv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
