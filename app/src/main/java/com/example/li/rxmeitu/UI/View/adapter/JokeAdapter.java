package com.example.li.rxmeitu.UI.View.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.li.rxmeitu.Modle.JokeBean;
import com.example.li.rxmeitu.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by li on 2017/3/31.
 */
public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.MyViewHolder> {

    private Context c;
    private List<JokeBean.ResultEntity.DataEntity> list;

    public JokeAdapter(Context c, List<JokeBean.ResultEntity.DataEntity> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(c).inflate(R.layout.joke_list_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.content.setText(list.get(position).getContent());
            holder.title.setText("笑话"+position);
            holder.time.setText(list.get(position).getUpdatetime());
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.time)
        TextView time;
        @Bind(R.id.content)
        TextView content;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
