package com.basic.maisFitness.domain;


import com.basic.maisFitness.enums.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime registrationDate;
    private PaymentMethodEnum paymentMethod;
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @PrePersist
    private void autoRegistrationDate() {
        registrationDate = LocalDateTime.now();
    }

//    @OneToMany(mappedBy = "id.sale")
//    private Set<SaleItem> saleItems = new HashSet<>();
}
