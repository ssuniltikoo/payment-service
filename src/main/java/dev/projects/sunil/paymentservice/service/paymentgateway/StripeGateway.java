package dev.projects.sunil.paymentservice.service.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class StripeGateway implements PaymentGateway{
    /**
     * @return
     */
    @Override
    public String generatePaymentLink() {
        return null;
    }
}
