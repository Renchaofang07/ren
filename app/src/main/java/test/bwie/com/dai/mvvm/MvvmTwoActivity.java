package test.bwie.com.dai.mvvm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.databinding.library.baseAdapters.BR;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import test.bwie.com.dai.R;
import test.bwie.com.ok.okhttp.OkHttp3Utils;

public class MvvmTwoActivity extends AppCompatActivity {

    private List<SongBean> list;
    private ListView listView;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MyBaseAdapter<SongBean> myBaseAdapter =
                    new MyBaseAdapter<>(MvvmTwoActivity.this,R.layout.listviewitem, BR.song,list);
            listView.setAdapter(myBaseAdapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm_two);
        listView = findViewById(R.id.listview);
        OkHttp3Utils.doGet("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                //Toast.makeText(MvvmTwoActivity.this,string+"",Toast.LENGTH_SHORT).show();
                Log.i("xxx",string);
                getPriString(string);
            }
        });
    }


    public void getPriString(String json){

        list = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray results = jsonObject.getJSONArray("results");
            Log.i("fff",results.length()+"");
            for(int i = 0 ; i < results.length() ; i++){
                SongBean songBean = new SongBean();
                JSONObject jsonObject1 = results.getJSONObject(i);
                String url = jsonObject1.getString("url");
                String createdAt = jsonObject1.getString("createdAt");
                String who = jsonObject1.getString("who");
                songBean.setData(createdAt);
                songBean.setImage(url);
                songBean.setName(who);
                list.add(songBean);
            }
            Log.i("qqq", list.size()+"");
            handler.sendEmptyMessage(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
