package com.cfin.webot.handler.message.callback;


import java.util.ArrayList;
import java.util.List;

public class CallbackMessageActuator {

    private static final List<AbstractCallbackMessageHandler> HANDLES = new ArrayList<>();


    public static void register(AbstractCallbackMessageHandler handler) {
        HANDLES.add(handler);
    }

    public static void execute(String callbackMessage) {
        for (AbstractCallbackMessageHandler handle : HANDLES) {
            // 回调消息处理
            handle.handleCallBackMessage(callbackMessage);
        }
    }
}


