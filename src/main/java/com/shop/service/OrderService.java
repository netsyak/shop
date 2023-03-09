package com.shop.service;

import com.shop.dto.OrderDto;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;
import com.shop.repository.MemberRepository;
import com.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
     private final ItemRepository itemRepository;
     private final MemberRepository memberRepository;
     private final OrderRepository orderRepository;

     public Long order(OrderDto orderDto, String email){
         Item item = itemRepository.findById(orderDto.getItemId())
                 .orElseThrow()
     }
}
