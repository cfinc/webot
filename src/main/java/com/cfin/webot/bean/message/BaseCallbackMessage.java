package com.cfin.webot.bean.message;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseCallbackMessage implements Serializable {

    /**
     * 消息类型
     */
    @JSONField(name = "TypeName")
    private String typeName;

    /**
     * 设备ID
     */
    @JSONField(name = "Appid")
    private String appid;

    /**
     * 所属微信的wxid
     */
    @JSONField(name = "Wxid")
    private String wxid;


    public boolean typeSupport(Integer msgType) {
        return false;
    }


}
