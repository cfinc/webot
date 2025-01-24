package com.cfin.webot.bean.message;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Objects;

/**
 * 回调消息基础类
 */
@Data
public class NormalCallBackMessage extends BaseCallbackMessage {


    @JSONField(name = "Data")
    private CallBackMessageData data;


    @Data
    public static class CallBackData {

        private String MsgId;

    }
    @Data
    public class CallBackMessageData {

        /**
         * 消息ID
         */
        @JSONField(name = "MsgId")
        private String msgId;

        /**
         * 消息发送人
         */
        @JSONField(name = "FromUserName")
        private Content fromUserName;

        /**
         * 消息接收人
         */
        @JSONField(name = "ToUserName")
        private Content toUserName;


        @JSONField(name = "MsgType")
        private Integer msgType;



        @JSONField(name = "Content")
        private Content content;

        @JSONField(name = "Status")
        private Integer status;

        @JSONField(name = "ImgStatus")
        private Integer imgStatus;



        @JSONField(name = "ImgStatus")
        private ImgBuf imgBuf;


        /**
         * 消息发送时间
         */
        @JSONField(name = "CreateTime")
        private Long createTime;


        @JSONField(name = "MsgSource")
        private String msgSource;

        /**
         * 消息通知内容
         */
        @JSONField(name = "PushContent")
        private String pushContent;

        @JSONField(name = "NewMsgId")
        private Long newMsgId;

        @JSONField(name = "MsgSeq")
        private Long msgSeq;


        @Data
        public static class Content {
            private String string;
        }


        @Data
        public static class ImgBuf {

            private Integer iLen;

        }
    }


    public boolean typeSupport(Integer messageType) {
        return Objects.nonNull(data) && Objects.equals(messageType, data.getMsgType());
    }

}
