package com.cfin.webot.handler.message.callback;

import com.alibaba.fastjson2.JSON;
import com.cfin.webot.bean.message.NormalCallBackMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class VideoCallbackMessageHandler extends AbstractCallbackMessageHandler<NormalCallBackMessage>{
    @Override
    public boolean support(NormalCallBackMessage normalCallBackMessage) {
        // 检查是否支持处理当前消息
        try {
            if (Objects.isNull(normalCallBackMessage)) {
                return false;
            }
            return normalCallBackMessage.typeSupport(43);
        } catch (Exception e) {
            log.info("CallBackTextMessageHandle - 语音消息验证异常 - {} ", JSON.toJSONString(normalCallBackMessage), e);
        }
        // 异常情况默认不支持处理
        return false;
    }

    @Override
    public void handleMessage(NormalCallBackMessage callBackMessage) {
        log.info("视频消息验证通过，开始处理文本消息 - {}", JSON.toJSONString(callBackMessage));

    }
}
