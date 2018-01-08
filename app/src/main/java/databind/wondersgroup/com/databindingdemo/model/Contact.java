package databind.wondersgroup.com.databindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class Contact extends BaseObservable{

    private String mail;

    @Bindable
    public String getMail(){
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
