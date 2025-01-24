package com.cfin.webot.handler.message;


public interface MessageHandler<T> {

    /**
     * 是否支持处理当前消息
     * @param t
     * @return
     */
    public boolean support(T t);

    /**
     * 消息处理
     * @param t
     * @return
     */
    public void handleMessage(T t);
}
