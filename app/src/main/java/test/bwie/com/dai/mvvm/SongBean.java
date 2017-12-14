package test.bwie.com.dai.mvvm;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by 1 on 2017/12/11.
 */

public class SongBean {


    private String image;
    private String data;
    private String name;


    @Override
    public String toString() {
        return "SongBean{" +
                "image='" + image + '\'' +
                ", data='" + data + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public SongBean() {
        super();
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SongBean(String image, String data, String name) {
        this.image = image;
        this.data = data;
        this.name = name;
    }



    @BindingAdapter("img")
    public static void loadInternetImage(ImageView iv, String img) {
        Picasso.with(iv.getContext()).load(img).into(iv);
    }
}
