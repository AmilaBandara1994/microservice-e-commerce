package com.amila.ecommerce.payment;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod payemntMethod,
        Integer orderId,
        String  orderReference,
        Customer customer
) {
}
