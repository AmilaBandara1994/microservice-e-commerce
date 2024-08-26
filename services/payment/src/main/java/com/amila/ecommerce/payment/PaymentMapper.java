package com.amila.ecommerce.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .orderId(request.orderId())
                .payemntMethod(request.payemntMethod())
                .amount(request.amount())
                .build();
    }
}
