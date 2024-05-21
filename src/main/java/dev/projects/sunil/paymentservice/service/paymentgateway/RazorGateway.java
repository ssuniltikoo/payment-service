package dev.projects.sunil.paymentservice.service.paymentgateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import lombok.extern.slf4j.Slf4j;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RazorGateway implements PaymentGateway{
    /**
     * @return
     */
    @Override
    public String generatePaymentLink() {
        try {
            RazorpayClient razorpay = new RazorpayClient("","");
            JSONObject paymentLinkRequest = new JSONObject();

            paymentLinkRequest.put("amount",1000);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",false);
            paymentLinkRequest.put("first_min_partial_amount",0);
            paymentLinkRequest.put("expire_by",1716239405);
            paymentLinkRequest.put("reference_id","TS1989004");
            paymentLinkRequest.put("description","Payment for policy no #ST23456");

            JSONObject customer = new JSONObject();
            customer.put("name","sunil tikoo");
            customer.put("contact","+918879438085");
            customer.put("email","ssunil.tikoo@gmail.com");
            paymentLinkRequest.put("customer",customer);

            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);

            paymentLinkRequest.put("reminder_enable",false);

            JSONObject notes = new JSONObject();
            notes.put("policy_name","Jeevan Bima");
            paymentLinkRequest.put("notes",notes);

            paymentLinkRequest.put("callback_url","https://chubby-pants-join.loca.lt");
            paymentLinkRequest.put("callback_method","get");
            log.info("payment link generated for razor pay " );
            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
       // return null;
    }
}
