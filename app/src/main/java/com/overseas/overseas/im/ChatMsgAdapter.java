//package com.overseas.overseas.im;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//
//import com.overseas.overseas.R;
//
//import java.util.List;
//
///**
// * Created by   admin on 2018/5/17.
// */
//
//public class ChatMsgAdapter extends BaseAdapter {
//    private Context context;
//    private List<String> list;
//    private List<Boolean> booleanList;
//    private List<Boolean> timeList;
//    private List<String> tList;
//
//    private OnBackgroundClickListener onBackgroundClickListener;
//
//    public ChatMsgAdapter(Context context, List<String> list, OnBackgroundClickListener onBackgroundClickListener, List<Boolean> booleanList, List<Boolean> timeList, List<String> tList) {
//        this.context = context;
//        this.list = list;
//        this.onBackgroundClickListener = onBackgroundClickListener;
//        this.booleanList = booleanList;
//        this.timeList = timeList;
//        this.tList = tList;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        MsgViewHolder vh = null;
//        if (convertView == null) {
//            vh = new MsgViewHolder();
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_chat_view, null);
//            vh.layout = (LinearLayout) convertView.findViewById(R.id.item_chat_lt);
//            vh.time = (TextView) convertView.findViewById(R.id.item_chat_time);
//            vh.left = (LinearLayout) convertView.findViewById(R.id.item_chat_qipao1);
//            vh.leftPhoto = (ImageView) convertView.findViewById(R.id.item_chat_text_left);
//            vh.leftContent = (TextView) convertView.findViewById(R.id.item_chat_content_left);
//            vh.right = (LinearLayout) convertView.findViewById(R.id.item_chat_qipao2);
//            vh.rightPhoto = (ImageView) convertView.findViewById(R.id.item_chat_text_right);
//            vh.rightContent = (TextView) convertView.findViewById(R.id.item_chat_content_right);
//            convertView.setTag(vh);
//        } else {
//            vh = (MsgViewHolder) convertView.getTag();
//        }
//
//        vh.layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackgroundClickListener.onClickListener();
//            }
//        });
//
//        if (booleanList != null && list != null) {
//            if (booleanList.get(position)) {
//                vh.left.setVisibility(View.GONE);
//                vh.right.setVisibility(View.VISIBLE);
//
//                //读取缓存加载图片 rightPhoto
//
//                vh.rightContent.setText(list.get(position));
//
////                Glide.with(context)
////                        .load()
////                        .into(vh.rightPhoto);
//
//            } else {
//                vh.left.setVisibility(View.VISIBLE);
//                vh.right.setVisibility(View.GONE);
//
//                //读取缓存加载图片 leftPhoto
//
//                vh.leftContent.setText(list.get(position));
//            }
//        }
//
//        if (timeList.get(position)) {
//            vh.time.setVisibility(View.VISIBLE);
//            vh.time.setText(tList.get(position));
//        } else {
//            vh.time.setVisibility(View.GONE);
//        }
//
//        return convertView;
//    }
//
//    class MsgViewHolder {
//        LinearLayout layout;
//
//        TextView time;
//
//        LinearLayout left;
//        ImageView leftPhoto;
//        TextView leftContent;
//
//        LinearLayout right;
//        ImageView rightPhoto;
//        TextView rightContent;
//    }
//
//    public interface OnBackgroundClickListener {
//        void onClickListener();
//    }
//}
