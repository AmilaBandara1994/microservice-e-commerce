package com.amila.ecommerce.kafka;

import com.amila.ecommerce.customer.CustomerResponse;
import com.amila.ecommerce.order.PaymentMethod;
import com.amila.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
