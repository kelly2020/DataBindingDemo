package databind.wondersgroup.com.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import databind.wondersgroup.com.databindingdemo.adapter.CompoundAdapter;
import databind.wondersgroup.com.databindingdemo.databinding.ActivityCompoundBinding;
import databind.wondersgroup.com.databindingdemo.listener.EventListener;
import databind.wondersgroup.com.databindingdemo.model.CompoundModel;
import databind.wondersgroup.com.databindingdemo.model.Contact;
import databind.wondersgroup.com.databindingdemo.model.User;

public class CompoundActivity extends AppCompatActivity {
    ActivityCompoundBinding binding;
    private CompoundAdapter adapter;

    private List<CompoundModel> compoundModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_compound);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();

        //事件的实现
        binding.setEvent(new EventListener() {
            @Override
            public void click1(View view) {
                //修改recyclerview 上面的数据
                compoundModels.clear();
                for (int i = 0; i < 10; i++) {
                    CompoundModel compoundModel = new CompoundModel();
                    User user = new User();

                    user.userAge.set("change  22=" + i);
                    user.userName.set("change model=" + i + "   ");

                    Contact contact1 = new Contact();
                    contact1.setMail("change 81914343@qq.com");
                    compoundModel.contacts.add(contact1);

                    Contact contact = new Contact();
                    contact.setMail("change ruby@sina.com");

                    compoundModel.user.set(user);
                    compoundModel.contacts.add(contact);

                    compoundModels.add(compoundModel);

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void click2(View view) {

            }

            @Override
            public void click3(View data) {

            }

        });
    }

    private void initData() {
        if (compoundModels == null) {
            compoundModels = new ArrayList<>();
        }

        for (int i = 0; i < 10; i++) {
            CompoundModel compoundModel = new CompoundModel();
            User user = new User();

            user.userAge.set("22=" + i);
            user.userName.set("多个model=" + i + "   ");

            Contact contact1 = new Contact();
            contact1.setMail("81914343@qq.com");
            compoundModel.contacts.add(contact1);

            Contact contact = new Contact();
            contact.setMail("ruby@sina.com");

            compoundModel.user.set(user);
            compoundModel.contacts.add(contact);

            compoundModels.add(compoundModel);

        }

        adapter = new CompoundAdapter(compoundModels);
        binding.recyclerView.setAdapter(adapter);
    }
}
