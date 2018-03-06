package com.kotlincoders.ravi.logicpractices;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.generated.callback.OnClickListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ravi on 2/26/18.
 */

public class ReceyclerViewAdapter extends RecyclerView.Adapter<ReceyclerViewAdapter.MyViewHolder> {

    List<GetSetClass> list;
    public ReceyclerViewAdapter(List<GetSetClass> list) {

        this.list = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.row_item_layout, parent, true);



        return new MyViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        GetSetClass getSetClass = list.get(position);

        holder.bind(getSetClass);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        public MyViewHolder(ViewDataBinding itemView) {

            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void bind(Object object) {

            binding.setVariable(BR.obj, object);
            binding.executePendingBindings();

        }
    }
}
