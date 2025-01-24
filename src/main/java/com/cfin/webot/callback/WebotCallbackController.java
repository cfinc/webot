package com.cfin.webot.callback;

import com.cfin.webot.handler.message.callback.CallbackMessageActuator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cfin/webot/callback")
@Controller
public class WebotCallbackController {

    /**
     * 处理回调消息
     * @param message
     */
    @PostMapping("/message")
    public void messageCallback(@RequestBody String message) {
         CallbackMessageActuator.execute(message);
    }

}
