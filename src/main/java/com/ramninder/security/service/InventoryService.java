package com.ramninder.security.service;

import com.ramninder.security.model.Inventory;

import java.util.Optional;

public interface InventoryService {

    public Inventory saveProductInfo(Inventory inventory);
    public Optional<Inventory> findProductInfoById(Long id);
    public Optional<Inventory> updateProductInfo(Inventory inventory, Long id);
    public void removeProductInfo(Long id);
}
