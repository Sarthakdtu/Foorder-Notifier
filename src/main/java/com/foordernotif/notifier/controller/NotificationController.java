package com.foordernotif.notifier.controller;

import com.foordernotif.notifier.service.WhatsAppNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/notify")
public class NotificationController {

    @Autowired
    WhatsAppNotifier whatsAppNotifier;

    @GetMapping("")
    public Object getHealth(){
        HashMap<String, Boolean> result = new HashMap<>();
        result.put("alive", true);
        return result;
    }

    @PostMapping("/send")
    public boolean sendMessage(@RequestBody HashMap<String, Object> req) throws Exception {
        String message = (String) req.get("message");
        String number = (String) req.get("mobileNumber");
        boolean sent = false;
        try{
            whatsAppNotifier.notify(number, message);
            sent = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return sent;
    }
}
