package databind.wondersgroup.com.databindingdemo.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class User  {
  public final ObservableField<String> userName = new ObservableField<>();
  public final ObservableField<String> userAge = new ObservableField<>();
  public final ObservableInt grade = new ObservableInt();
  public final ObservableBoolean isAviable = new ObservableBoolean();
}
