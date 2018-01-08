package databind.wondersgroup.com.databindingdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import databind.wondersgroup.com.databindingdemo.listener.ItemClickEvent;
import databind.wondersgroup.com.databindingdemo.R;
import databind.wondersgroup.com.databindingdemo.model.User;
import databind.wondersgroup.com.databindingdemo.databinding.ItemBindUserBinding;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    public OnItemListener mOnItemListener;

    private List<User> users;
    private Context mContext;

    public RecyclerViewAdapter(List<User> mUser) {
        users = mUser;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new BindViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bind_user, parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof BindViewHolder) {
            BindViewHolder viewHolder = (BindViewHolder) holder;
            viewHolder.binding.setUser(users.get(position));
            //设置点击事件
            viewHolder.binding.setEvent(new ItemClickEvent() {
                @Override
                public void onItemClick(View view) {
                    Toast.makeText(mContext,"position" + position ,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class BindViewHolder extends RecyclerView.ViewHolder {
        ItemBindUserBinding binding;

        public BindViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);


//            if (mOnItemListener != null){
//                itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mOnItemListener.setOnItemClick(getLayoutPosition());
//                    }
//                });
//            }
        }
    }


//    public void setOnItemListener(OnItemListener onItemListener){
//        mOnItemListener = onItemListener;
//
//    }

//    public interface OnItemListener {
//        void setOnItemClick(int position);
//    }

}
