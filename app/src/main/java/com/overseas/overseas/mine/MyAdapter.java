package com.overseas.overseas.mine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.view.SlidingMenu;

import java.util.List;

/**
 * created by yhao on 2017/8/18.
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<String> mData;
    private Context mContext;

    private SlidingMenu mOpenMenu;
    private SlidingMenu mScrollingMenu;

    public SlidingMenu getScrollingMenu() {
        return mScrollingMenu;
    }

    public void setScrollingMenu(SlidingMenu scrollingMenu) {
        mScrollingMenu = scrollingMenu;
    }

    public void holdOpenMenu(SlidingMenu slidingMenu) {
        mOpenMenu = slidingMenu;
    }

    public void closeOpenMenu() {
        if (mOpenMenu != null && mOpenMenu.isOpen()) {
            mOpenMenu.closeMenu();
            mOpenMenu = null;
        }
    }

    public MyAdapter(List<String> data, Context context) {
        mData = data;
        mContext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_zuijin, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.menuText.setText("删除");
        holder.menuText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeOpenMenu();
                if (mOnClickListener != null) {
                    mOnClickListener.onMenuClick(position);
                }
            }
        });
        holder.slidingMenu.setCustomOnClickListener (new SlidingMenu.CustomOnClickListener() {
            @Override
            public void onClick() {
                if (mOnClickListener != null) {
                    mOnClickListener.onContentClick(position);
                }
            }
        });

    }

    interface OnClickListener {
        void onMenuClick(int position);

        void onContentClick(int position);
    }

    private OnClickListener mOnClickListener;

    void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SlidingMenu slidingMenu;
        TextView menuText;
        MyViewHolder(View itemView) {
            super(itemView);
            menuText= (TextView) itemView.findViewById(R.id.menuText);
//            slidingMenu = (SlidingMenu) itemView.findViewById(R.id.slidingMenu);
        }
    }
}
