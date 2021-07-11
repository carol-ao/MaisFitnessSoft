package com.basic.maisFitness.repositories;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.WantedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WantedItemRepository extends JpaRepository<WantedItem,Long> {

    public List<WantedItem> findByClient(Client client);
}
