package com.cfin.webot.handler.message.callback;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.cfin.webot.bean.message.MessageContent;
import com.cfin.webot.bean.message.NormalCallBackMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class FileSentNotifyCallbackMessageHandler extends AbstractCallbackMessageHandler<NormalCallBackMessage> {
    @Override
    public boolean support(NormalCallBackMessage message) {
        // 检查是否支持处理当前消息
        try {
            if (Objects.isNull(message)) {
                return false;
            }
            NormalCallBackMessage.CallBackMessageData.Content content = message.getData().getContent();
            if (Objects.isNull(content) || StrUtil.isBlank(content.getString())) {
                return false;
            }
            MessageContent messageContent = MessageContent.toContent(content.getString());
            if (Objects.isNull(messageContent)) {
                log.info("文件消息验证失败 - 未解析到内容信息:{}", content.getString());
                return false;
            }

            return Objects.nonNull(messageContent.getMsg())
                    && Objects.nonNull(messageContent.getMsg().getAppMsg())
                    && Objects.equals(messageContent.getMsg().getAppMsg().getType(), "74");
        } catch (Exception e) {
            log.info("CallBackTextMessageHandle - 语音消息验证异常 - {} ", JSON.toJSONString(message), e);
        }
        // 异常情况默认不支持处理
        return false;
    }

    @Override
    public void handleMessage(NormalCallBackMessage normalCallBackMessage) {
        log.info("文件发送消息验证通过，开始处理文本消息 - {}", JSON.toJSONString(normalCallBackMessage));

    }
}
