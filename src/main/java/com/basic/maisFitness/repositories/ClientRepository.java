package com.basic.maisFitness.repositories;

import com.basic.maisFitness.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
