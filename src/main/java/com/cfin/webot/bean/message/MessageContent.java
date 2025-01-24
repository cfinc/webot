package com.cfin.webot.bean.message;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.XML;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageContent implements Serializable {


    private Msg msg;


    @Data
    public static class Msg{
        @JSONField(name = "fromusername")
        private String fromUsername;

        @JSONField(name = "commenturl")
        private String commentUrl;



        private String scene;

        @JSONField(name = "appmsg")
        private AppMsg appMsg;


        @Data
        public static class AppMsg {
            @JSONField(name = "dataurl")
            private String dataUrl;

            @JSONField(name = "extinfo")
            private String extInfo;

            @JSONField(name = "messageext")
            private String messageExt;

            @JSONField(name = "lowurl")
            private String lowUrl;


            @JSONField(name = "sourcedisplayname")
            private String sourceDisplayName;


            @JSONField(name = "mediatagname")
            private String mediaTagName;

            @JSONField(name = "lowdataurl")
            private String lowDataUrl;

            @JSONField(name = "showtype")
            private String showType;

            @JSONField(name = "statextstr")
            private String staTextStr;

            private String title;
            private String type;

            @JSONField(name = "appattach")
            private String appAttach;


            private String content;
            private String url;

            @JSONField(name = "soundtype")
            private String soundType;

            private String des;

            @JSONField(name = "sourceusername")
            private String sourceUsername;

            private String action;

            @JSONField(name = "mmreadershare")
            private Share mmReaderShare;

            @JSONField(name = "messageaction")
            private String  messageAction;

            @JSONField(name = "thumburl")
            private String  thumbUrl;

            @JSONField(name = "contentattr")
            private String  contentAttr;
            private String  md5;

            @Data
            public static class Share {

                @JSONField(name = "itemshowtype")
                private String itemShowType;

            }

        }


        @Data
        public static class AppInfo {
            private String appname;

            private String version;

        }

    }


    public static MessageContent toContent(String contentXmlMessage) {
        return JSON.parseObject(XML.toJSONObject(XmlUtil.cleanInvalid(contentXmlMessage)).toJSONString(0), MessageContent.class);
    }








}
