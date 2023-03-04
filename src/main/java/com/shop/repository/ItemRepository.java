package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>,
        QuerydslPredicateExecutor<Item> {

    List<Item> findByItemNm(String itemNm); //상품 이름 찾기

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail); //상품 상세 부분 찾기
    //OR 조건 처리하기 : 상품을 상품명과 상품 상세 설명을 OR 조건을 이요하여 조회하는 쿼리 메소드 입니다.


    List<Item> findByPriceLessThan(Integer price);
    // LessThan  파리미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회하는 쿼리 메소드 입니다.

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
