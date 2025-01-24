package com.cfin.webot.handler.message.callback;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson2.JSON;
import com.cfin.webot.bean.message.MessageContent;
import com.cfin.webot.bean.message.NormalCallBackMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class PublishAccountCallbackMessageHandler extends AbstractCallbackMessageHandler<NormalCallBackMessage> {
    @Override
    public boolean support(NormalCallBackMessage normalCallBackMessage) {
        // 检查是否支持处理当前消息
        try {
            if (Objects.isNull(normalCallBackMessage)) {
                return false;
            }
            normalCallBackMessage.getData();

            NormalCallBackMessage.CallBackMessageData.Content content = normalCallBackMessage.getData().getContent();
            if (Objects.isNull(content) || StrUtil.isBlank(content.getString())) {
                return false;
            }

            MessageContent messageContent = MessageContent.toContent(content.getString());

            return Objects.nonNull(messageContent.getMsg())
                    && Objects.nonNull(messageContent.getMsg().getAppMsg())
                    && StrUtil.isNotBlank(messageContent.getMsg().getAppMsg().getTitle())
                    && !messageContent.getMsg().getAppMsg().getTitle().contains("加入群聊");
        } catch (Exception e) {
            log.info("CallBackTextMessageHandle - 语音消息验证异常 - {} ", JSON.toJSONString(normalCallBackMessage), e);
        }
        // 异常情况默认不支持处理
        return false;
    }

    @Override
    public void handleMessage(NormalCallBackMessage callBackMessage) {
        log.info("公众号消息验证通过，开始处理文本消息 - {}", JSON.toJSONString(callBackMessage));

    }
}
