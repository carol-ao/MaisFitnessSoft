package com.basic.maisFitness.requests;

import com.basic.maisFitness.domain.OrderItem;
import com.basic.maisFitness.enums.PaymentMethodEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class OrderPostRequestBody{

    private PaymentMethodEnum paymentMethod;
    private BigDecimal value;
    private Long clientId;
    private Set<OrderItemPostRequestBody> orderItems = new HashSet<>();
}
