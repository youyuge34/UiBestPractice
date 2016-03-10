package com.example.yousheng.uibestpractice;

/**
 * Created by yousheng on 16/3/10.
 */
public class Msg {
    public final static int TYPE_RECEIVED = 0;
    public final static int TYPE_SENT = 1;

    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
