package databind.wondersgroup.com.databindingdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import databind.wondersgroup.com.databindingdemo.R;
import databind.wondersgroup.com.databindingdemo.databinding.ItemBindCompoundBinding;
import databind.wondersgroup.com.databindingdemo.listener.ItemClickEvent;
import databind.wondersgroup.com.databindingdemo.model.CompoundModel;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class CompoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CompoundModel> mCompoundModels;
    private Context mContext;

    public CompoundAdapter(List<CompoundModel> mUser) {
        mCompoundModels = mUser;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new BindViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bind_compound, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof BindViewHolder) {
            BindViewHolder viewHolder = (BindViewHolder) holder;


            viewHolder.binding.setUser(mCompoundModels.get(position).user.get());
            viewHolder.binding.itemRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
//
            CompoundItemAdapter adapter = new CompoundItemAdapter(mCompoundModels.get(position).contacts);
            viewHolder.binding.itemRecyclerview.setAdapter(adapter);

            //设置点击事件
            viewHolder.binding.setEvent(new ItemClickEvent() {
                @Override
                public void onItemClick(View view) {
                    Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mCompoundModels.size();
    }


    class BindViewHolder extends RecyclerView.ViewHolder {
        ItemBindCompoundBinding binding;

        public BindViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }


}
