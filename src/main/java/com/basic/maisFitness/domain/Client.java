package com.basic.maisFitness.domain;

import com.basic.maisFitness.enums.ProductSizeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private ProductSizeEnum bust;
    private ProductSizeEnum hips;
    private LocalDate registrationDate;

//    @OneToMany(mappedBy = "client_id")
//    List<Order> orders = new ArrayList<>();

    @PrePersist
    private void autoRegistrationDate() {
        registrationDate = LocalDate.now();
    }

}
