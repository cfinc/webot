package com.cfin.webot.enums;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.cfin.webot.bean.message.BaseCallbackMessage;
import com.cfin.webot.bean.message.NormalCallBackMessage;
import com.cfin.webot.bean.message.MessageContent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * 回调消息类型枚举
 */
@AllArgsConstructor
@Slf4j
public enum CallbackMessageTypeEnum {


    TEXT("文本消息", message -> message.typeSupport(1)),
    IMAGE("图片消息", message -> message.typeSupport(3)),
    VOICE("语音消息", message -> message.typeSupport(34)),

    EMOJI("表情", message -> message.typeSupport(47)),

    CARD("名片消息", message -> message.typeSupport(42)),

    ADD_FRIEND_NOTIFY("好友添加请求通知", message -> message.typeSupport(37)),

    GONGZHONGHAO("公众号链接", message -> {
        if (!message.typeSupport(49)) {
            return false;
        }

        return false;
//        NormalCallBackMessage.CallBackMessageData.Content content = message.getData().getContent();
//        if (Objects.isNull(content) || StrUtil.isBlank(content.getString())) {
//            return false;
//        }
//        Map<String, Object> contentMap = XmlUtil.xmlToMap(content.getString());
//        Object o = contentMap.get("appmsg");
//        if (Objects.isNull(o)) {
//            return false;
//        }
//        return !String.valueOf(((Map<String,Object>) o).get("title")).contains("加入群聊");
    }),


    FILE_SENT_NIOTIFY("文件消息发送通知", message -> {
        if (!message.typeSupport(49)) {
            return false;
        }

//        CallBackMessage.CallBackMessageData.Content content = message.getData().getContent();
//        if (Objects.isNull(content) || StrUtil.isBlank(content.getString())) {
//            return false;
//        }
//        MessageContent messageContent = MessageContent.toContent(content.getString());
//        if (Objects.isNull(messageContent)) {
//            log.info("文件消息验证失败 - 未解析到内容信息:{}", content.getString());
//            return false;
//        }
//
//        return Objects.nonNull(messageContent.getMsg())
//                && Objects.nonNull(messageContent.getMsg().getAppMsg())
//                && Objects.equals(messageContent.getMsg().getAppMsg().getType(), "74");
        return false;
    }),


    FILE_SENT_COMPLETE("文件发送完毕通知", message -> {
//        NormalCallBackMessage.CallBackMessageData.Content content = message.getData().getContent();
//        if (Objects.isNull(content) || StrUtil.isBlank(content.getString())) {
//            return false;
//        }
//        MessageContent messageContent = MessageContent.toContent(content.getString());
//        if (Objects.isNull(messageContent)) {
//            log.info("文件消息验证失败 - 未解析到内容信息:{}", content.getString());
//            return false;
//        }
//
//        return Objects.nonNull(messageContent.getMsg())
//                && Objects.nonNull(messageContent.getMsg().getAppMsg())
//                && Objects.equals(messageContent.getMsg().getAppMsg().getType(), "6");
        return false;
    }),




    ;

    private String description;


    private Function<BaseCallbackMessage, Boolean> checker;


}
