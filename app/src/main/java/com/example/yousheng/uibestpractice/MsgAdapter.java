package com.example.yousheng.uibestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yousheng on 16/3/10.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

    private int resourceId;
    public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
        super(context, textViewResourceId, objects );
       resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view;
        ViewHolder  viewholder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewholder = new ViewHolder();
            viewholder.leftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
            viewholder.rifhtLayout = (LinearLayout)view.findViewById(R.id.right_layout);
            viewholder.leftMsg = (TextView)view.findViewById(R.id.left_msg);
            viewholder.rifhtMsg = (TextView)view.findViewById(R.id.right_msg);
            view.setTag(viewholder);
        }else {
            view = convertView;
            viewholder = (ViewHolder)view.getTag();
        }

        if (msg.getType()==Msg.TYPE_RECEIVED){
            viewholder.leftLayout.setVisibility(View.VISIBLE);
            viewholder.rifhtLayout.setVisibility(View.GONE);
            viewholder.leftMsg.setText(msg.getContent());
        }else if (msg.getType()==Msg.TYPE_SENT){
            viewholder.leftLayout.setVisibility(View.GONE);
            viewholder.rifhtLayout.setVisibility(View.VISIBLE);
            viewholder.rifhtMsg.setText(msg.getContent());
        }
        return view;

    }

    class ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rifhtLayout;
        TextView leftMsg;
        TextView rifhtMsg;
    }
}
