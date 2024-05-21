package dev.projects.sunil.paymentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RazorPayWebHookController {

    @PostMapping("/razorPayWebhook")
    public void paymentDone(@RequestBody Object object){
        log.info("webhook request {}", object.toString());
    }
}
