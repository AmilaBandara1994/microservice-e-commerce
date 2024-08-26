package com.amila.ecommerce.payment;

import com.amila.ecommerce.customer.CustomerResponse;
import com.amila.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod payemntMethod,
        Integer orderId,
        String  orderReference,
        CustomerResponse customer
) {
}
