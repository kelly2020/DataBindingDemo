package databind.wondersgroup.com.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import databind.wondersgroup.com.databindingdemo.adapter.RecyclerViewAdapter;
import databind.wondersgroup.com.databindingdemo.databinding.ActivityMainBinding;
import databind.wondersgroup.com.databindingdemo.listener.EventListener;
import databind.wondersgroup.com.databindingdemo.model.Contact;
import databind.wondersgroup.com.databindingdemo.model.NamesViewModel;
import databind.wondersgroup.com.databindingdemo.model.User;


public class MainActivity extends AppCompatActivity {
    private List<User> users;

    ActivityMainBinding binding;

    RecyclerViewAdapter adapter;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User();
        user.userAge.set("11");
        user.userName.set("kelly");
        user.grade.set(2222);
        user.isAviable.set(true);

        binding.setUser(user);

        Contact contact = new Contact();
        contact.setMail("819147422@.aa.com");
        binding.setContact(contact);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NamesViewModel namesViewModel = new NamesViewModel(this);
        binding.setViewModel(namesViewModel);

        namesViewModel.names.add("kelly");
        namesViewModel.names.add("baby");
        namesViewModel.names.add("ruby");
        namesViewModel.names.add("jenny");

        NamesViewModel.setNames(binding.layout, namesViewModel.names, this);

        initDatas();
        initListener();
    }

    private void initListener() {
        binding.buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.userAge.set("18");
                user.userName.set("hello change success");
                user.grade.set(33333);
                user.isAviable.set(false);
            }
        });
        //事件的实现
        binding.setClick(new EventListener() {
            @Override
            public void click1(View view) {
                //修改recyclerview 上面的数据
                users.clear();
                for (int i = 0; i < 10; i++) {
                    User user = new User();
                    user.userName.set("bella" + i);
                    user.userAge.set("28" + i);

                    users.add(user);
                }

                adapter.notifyDataSetChanged();


                Toast.makeText(MainActivity.this, "click1111", Toast.LENGTH_LONG).show();
            }

            @Override
            public void click2(View view) {
                Intent intent = new Intent(MainActivity.this,CompoundActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "click222222", Toast.LENGTH_LONG).show();
            }

            @Override
            public void click3(View data) {
                Toast.makeText(MainActivity.this, "click33333", Toast.LENGTH_LONG).show();

            }

        });
    }

    private void initDatas() {
        if (users == null) {
            users = new ArrayList<>();
        }

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.userName.set("kelly" + i);
            user.userAge.set("18" + i);

            users.add(user);
        }

        adapter = new RecyclerViewAdapter(users);
        binding.recyclerView.setAdapter(adapter);
//        adapter.setOnItemListener(this);

    }

//    @Override
//    public void setOnItemClick(int position) {
//        Toast.makeText(this,"position==" + position,Toast.LENGTH_SHORT).show();
//    }
}
