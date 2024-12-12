package com.orders.api.orders.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "ORDER")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "ORDER_SEQ", allocationSize = 1, initialValue=900)
    @Column(name = "COD_ORDER")
    private Integer id;

    @Column(name = "NOME_PRODUTO", nullable = false)
    private String name;

    @Column(name = "STATUS", length = 1, nullable = false)
    private Integer status;

    @Column(name = "TOTAL_PRICE", length = 1, nullable = false)
    private Double totalPrice;

}
