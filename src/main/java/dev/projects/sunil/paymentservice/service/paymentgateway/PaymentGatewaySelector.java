package dev.projects.sunil.paymentservice.service.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {

    public RazorGateway razorGateway;

    public StripeGateway stripeGateway;

    public PaymentGatewaySelector(final RazorGateway razorGateway, final StripeGateway stripeGateway){
        this.razorGateway = razorGateway;
        this.stripeGateway = stripeGateway;
    }

    public PaymentGateway getPaymentGateway(){
        return razorGateway;
    }
}
