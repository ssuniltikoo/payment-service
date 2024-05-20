package dev.projects.sunil.paymentservice.controller;

import dev.projects.sunil.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(final PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public String initiatePayment(){
       return paymentService.generatePaymentLink();
    }
}
