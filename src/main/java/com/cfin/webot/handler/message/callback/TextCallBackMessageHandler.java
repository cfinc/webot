package com.cfin.webot.handler.message.callback;

import com.alibaba.fastjson2.JSON;
import com.cfin.webot.bean.message.NormalCallBackMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 文本消息处理器
 */
@Component
@Slf4j
public class TextCallBackMessageHandler extends AbstractCallbackMessageHandler<NormalCallBackMessage> {

    @Override
    public boolean support(NormalCallBackMessage callBackMessage) {
        // 检查是否支持处理当前消息
        try {
            if (Objects.isNull(callBackMessage)) {
                return false;
            }
            return callBackMessage.typeSupport(1);
        } catch (Exception e) {
            log.info("CallBackTextMessageHandle - 文本消息验证异常 - {} ", JSON.toJSONString(callBackMessage), e);
        }
        // 异常情况默认不支持处理
        return false;
    }

    @Override
    public void handleMessage(NormalCallBackMessage callBackMessage) {
        // 处理文本消息
        log.info("文本消息验证通过，开始处理文本消息 - {}", JSON.toJSONString(callBackMessage));

    }
}
