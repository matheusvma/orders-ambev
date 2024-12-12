package com.orders.api.orders.service;

import com.orders.api.orders.dto.request.InputOdersRequest;
import com.orders.api.orders.model.Order;
import com.orders.api.orders.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double TOTAL_PRICE = 0;

    @Autowired
    private OrderRepository repository;

    /**
     * Função responsável por calcular preço da order.
     * @param request
     * @return
     */
    public Order calculateOrder(InputOdersRequest request) {
        Order orderDb = this.repository.findByName(request.getName());

        if(orderDb.getName() == request.getName()){
            TOTAL_PRICE = TOTAL_PRICE + request.getPrice();
        } else {
            TOTAL_PRICE = 0;
            TOTAL_PRICE = TOTAL_PRICE + request.getPrice();
        }

        Order order = montaOrder(request);
        salvar(order);

        return order;
    }

    private Order salvar(Order order) {
        return this.repository.save(order);
    }

    private Order montaOrder(InputOdersRequest request){
        Order order = new Order();
        order.setStatus(1);
        order.setName(request.getName());
        order.setTotalPrice(TOTAL_PRICE);

        return order;
    }

}
