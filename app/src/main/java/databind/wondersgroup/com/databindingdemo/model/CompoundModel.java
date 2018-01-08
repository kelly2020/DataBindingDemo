package databind.wondersgroup.com.databindingdemo.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class CompoundModel {

    public final ObservableField<User> user = new ObservableField<>();

    public final ObservableArrayList<Contact> contacts = new ObservableArrayList<>();
}
