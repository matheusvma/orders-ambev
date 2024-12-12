package com.orders.api.orders.controller;

import com.orders.api.orders.dto.request.InputOdersRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/oders")
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // End-point para enviar mensagem para exchenge
    @PostMapping(value = "/input")
    public void inputOders(@RequestBody InputOdersRequest request) {

        // Message message = new Message(("New order: " + request.getId()).getBytes());
        rabbitTemplate.convertAndSend("product.ex", "", request);
    }

}
