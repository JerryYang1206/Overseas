package com.overseas.overseas.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.overseas.overseas.R;
import com.overseas.overseas.model.LinkmanBean;
import com.overseas.overseas.view.CircleImageView;

import java.util.List;

/**
 * admin  2018/6/13
 */
public class LinkmanAdapter extends RecyclerView.Adapter {
    private final int LINKMAN = 1;
    private final int VIEW = 2;

    private List<Object> datas;

    private Activity activity;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public LinkmanAdapter(List<Object> datas, Activity activity) {
        this.datas = datas;
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        if (datas.get(position) instanceof LinkmanBean.DatasBean.ListBean) {
            return LINKMAN;
        } else {
            return VIEW;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LINKMAN) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_lianxiren, null);
            return new LinkmanViewHolder(view);
        } else {
            View view = LayoutInflater.from(activity).inflate(R.layout.lianxiren_item, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (datas.size() > 0) {
            if (holder instanceof LinkmanViewHolder) {
                LinkmanViewHolder viewHolder = (LinkmanViewHolder) holder;
                final LinkmanBean.DatasBean.ListBean bean = (LinkmanBean.DatasBean.ListBean) datas.get(position);
                viewHolder.nickName.setText(bean.getBrokerName());
                Glide.with(activity)
                        .load(bean.getPic())
                        .into(viewHolder.icon);
                viewHolder.layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClickListener(bean);
                    }
                });

                viewHolder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemDeleteListener(position, bean.getId() + "");
                    }
                });

            } else if (holder instanceof ItemViewHolder) {
                ItemViewHolder viewHolder = (ItemViewHolder) holder;
                LinkmanBean.DatasBean string = (LinkmanBean.DatasBean) datas.get(position);
                viewHolder.title.setText(string.getKey());
            }
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class LinkmanViewHolder extends RecyclerView.ViewHolder {
        TextView nickName;
        TextView delete;
        CircleImageView icon;
        LinearLayout layout;

        public LinkmanViewHolder(View itemView) {
            super(itemView);
            nickName = (TextView) itemView.findViewById(R.id.item_linkman_nickName);
            delete = (TextView) itemView.findViewById(R.id.shachu_tv);
            icon = (CircleImageView) itemView.findViewById(R.id.item_linkman_icon);
            layout = (LinearLayout) itemView.findViewById(R.id.content_ll);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_linkman_title);
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(LinkmanBean.DatasBean.ListBean bean);
        void onItemDeleteListener(int position, String userId);
    }
}
