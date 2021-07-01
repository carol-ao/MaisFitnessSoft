package com.basic.maisFitness.requests;

import com.basic.maisFitness.enums.PaymentMethodEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class OrderPostRequestBody {

    private PaymentMethodEnum paymentMethod;
    private BigDecimal value;
    private Long clientId;
}
