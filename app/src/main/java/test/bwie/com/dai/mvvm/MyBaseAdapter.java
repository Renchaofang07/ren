package test.bwie.com.dai.mvvm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 1 on 2017/12/11.
 */

public class MyBaseAdapter<T> extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private List<T> list;

    public MyBaseAdapter(Context context, int layoutId, int variableId, List<T> list) {
        this.context = context;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewDataBinding inflate;
        if(convertView == null){
            inflate = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        }else{
            inflate = DataBindingUtil.getBinding(convertView);
        }
        inflate.setVariable(variableId, list.get(position));
        return inflate.getRoot();
    }
}
