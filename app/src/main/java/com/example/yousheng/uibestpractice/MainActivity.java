package com.example.yousheng.uibestpractice;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList= new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();
        adapter = new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        inputText= (EditText) findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        msgListView = (ListView)findViewById(R.id.msg_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
    }
    private  void initMsgs(){
        msgList.add(new Msg("Hell,guy!",1));
        msgList.add(new Msg("Nice to see u 2",0));
        msgList.add(new Msg("haha!buddy~~",1));
    }
}
