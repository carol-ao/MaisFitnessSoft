package com.basic.maisFitness.domain;


import com.basic.maisFitness.domain.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;

    public OrderItem(){
    }
    public OrderItem(Order order,Product product, Integer quantity) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
