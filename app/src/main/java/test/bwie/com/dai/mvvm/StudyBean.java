package test.bwie.com.dai.mvvm;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by 1 on 2017/12/11.
 */

public class StudyBean {


    private String pick;
    private String name;
    private String pass;

    @Override
    public String toString() {
        return "StudyBean{" +
                "pick='" + pick + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public StudyBean(String pick, String name, String pass) {
        this.pick = pick;
        this.name = name;
        this.pass = pass;
    }
    public StudyBean(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public StudyBean() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    @BindingAdapter("pick")
    public static void getInternetImage(ImageView iv, String userface) {
        Picasso.with(iv.getContext()).load(userface).into(iv);
    }

    public void onItemClick(View view) {

        Toast.makeText(view.getContext(), "我点击了", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(view.getContext(), MvvmTwoActivity.class);
        view.getContext().startActivity(intent);
    }
}
