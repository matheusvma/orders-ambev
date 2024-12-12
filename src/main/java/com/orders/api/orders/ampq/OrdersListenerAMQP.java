package com.orders.api.orders.ampq;

import com.orders.api.orders.dto.request.InputOdersRequest;
import com.orders.api.orders.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersListenerAMQP {

    @Autowired
    private OrderService service;

    @RabbitListener(queues = "product.orders")
    public void receivesMessage(InputOdersRequest request) {
        System.out.println("Mensagem: " + request.toString());
        service.calculateOrder(request);
    }

}
