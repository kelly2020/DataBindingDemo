package databind.wondersgroup.com.databindingdemo.model;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import databind.wondersgroup.com.databindingdemo.R;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class NamesViewModel {
    public Context context;
    public final ObservableArrayList<String> names = new ObservableArrayList<>();

    public NamesViewModel(Context context) {
        names.add("linus chen");
        names.add("lin xueyan");
        names.add("zhang xiaona");
        names.add("chen lei");
        names.add("liu yuhong");

        this.context = context;
    }

    @BindingAdapter({"bind:names", "bind:context"})
    public static void setNames(ViewGroup linearLayout, ArrayList<String> names, Context context) {

        linearLayout.removeAllViews();

        for (String s : names) {
            TextView t = new TextView(context);
            t.setText(s);
            linearLayout.addView(t);
        }
    }

    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.add_btn) {
            names.add("yanyu cai");
        }
    }
}
