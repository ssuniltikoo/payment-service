package dev.projects.sunil.paymentservice.controller;

import dev.projects.sunil.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(final PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public String initiatePayment(){
        log.info("payment initiation ..");
       return paymentService.generatePaymentLink();
    }
}
