package com.amila.ecommerce.payment;

import com.amila.ecommerce.notification.NotificationProducer;
import com.amila.ecommerce.notification.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;


    public Integer createPayment(PaymentRequest request) {
        var payment  = repository.save(mapper.toPayment(request));
        notificationProducer.sendingNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.payemntMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
