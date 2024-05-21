package dev.projects.sunil.paymentservice.service;

import dev.projects.sunil.paymentservice.PaymentServiceApplication;
import dev.projects.sunil.paymentservice.service.paymentgateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentGatewaySelector paymentGatewaySelector;

    public PaymentService(final PaymentGatewaySelector paymentGatewaySelector){
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    public String generatePaymentLink(){
        // logic to add details in db
        return paymentGatewaySelector.
                getPaymentGateway()
                .generatePaymentLink();
    }
}
