package com.ramninder.security.repository;

import com.ramninder.security.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long > {

    boolean existsById(Long id);
}
