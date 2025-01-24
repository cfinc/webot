package com.cfin.webot.handler.message.callback;

import com.alibaba.fastjson2.JSON;
import com.cfin.webot.bean.message.NormalCallBackMessage;
import com.cfin.webot.handler.message.MessageHandler;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * 回调消息处理
 */
@Slf4j
public abstract class AbstractCallbackMessageHandler<T> implements MessageHandler<T> {

    private Class<T> clazz;

    public AbstractCallbackMessageHandler() {
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    /**
     * 模板，定义所有处理器执行流程
     *
     * @param msg
     * @return
     */
    public final void handleCallBackMessage(String msg) {
        T t = JSON.parseObject(msg, clazz);
        if (this.support(t)) {
            this.handleMessage(t);
        }
    }


    @PostConstruct
    public void init() {
        // 注册
        CallbackMessageActuator.register(this);
    }


}
