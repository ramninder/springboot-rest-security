package com.ramninder.security.service;

import com.ramninder.security.model.Inventory;
import com.ramninder.security.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImplementation implements  InventoryService{

    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImplementation(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }



    @Override
    public Inventory saveProductInfo(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> findProductInfoById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public Optional<Inventory> updateProductInfo(Inventory inventory, Long id) {
        return inventoryRepository.findById(id).map(product -> {
            product.setProductName(inventory.getProductName());
                    product.setProductPrice(inventory.getProductPrice());
                    product.setProductQuantity(inventory.getProductQuantity());
                    return  inventoryRepository.save(product);

        });
    }

    @Override
    public void removeProductInfo(Long id) {
            inventoryRepository.deleteById(id);
    }
}
