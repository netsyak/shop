package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //지연 로딩 방식
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY) //지연 로딩 방식
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; //주문가격
    private int count; //수량

//    private LocalDateTime regTime;
//    private LocalDateTime updateTime;
    //BaseEntity를 상속받도록 소스코드를 수정함

}
