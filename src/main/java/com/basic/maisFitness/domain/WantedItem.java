package com.basic.maisFitness.domain;

import com.basic.maisFitness.enums.ProductBrandEnum;
import com.basic.maisFitness.enums.ProductColorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WantedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private String type;
    private ProductBrandEnum brand;
    private ProductColorEnum color;
    private LocalDate date;

    @PrePersist
    public void autoDate() {
        this.date = LocalDate.now();
    }
}
