package com.ramninder.security.controller;


import com.ramninder.security.model.Inventory;
import com.ramninder.security.repository.InventoryRepository;
import com.ramninder.security.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryService inventoryService;
    private InventoryRepository inventoryRepository;

    @Autowired
    public  InventoryController(InventoryService inventoryService, InventoryRepository inventoryRepository){
        this.inventoryService = inventoryService;
        this.inventoryRepository = inventoryRepository;
    }

    @PostMapping("/addProductInfo")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Inventory> saveProductInformation(@Valid @RequestBody Inventory inventory){
        return new ResponseEntity<Inventory>(inventoryService.saveProductInfo(inventory), HttpStatus.CREATED);
    }

    @GetMapping("/getProductById/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('EMPLOYEE')")
    public ResponseEntity getProductInformation(@PathVariable Long id){

        if (!inventoryRepository.existsById(id)){
            return ResponseEntity
                    .badRequest()
                    .body("Error: Product with id: "+id+" does not exist");
        }else {
            return new ResponseEntity(inventoryService.findProductInfoById(id), HttpStatus.OK);
        }
    }

    @PutMapping("/updateProductInfo/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public  ResponseEntity updateProductInformation
            ( @Valid @RequestBody Inventory inventory,@PathVariable Long id){
        if (!inventoryRepository.existsById(id)){
            return ResponseEntity
                    .badRequest()
                    .body("Error: Product with id: "+id+" does not exist");
        }else {
            return new ResponseEntity<Optional<Inventory>>(inventoryService.updateProductInfo(inventory, id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/removeProductInfo/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<?> removeProductInfo(@PathVariable long id){
        inventoryService.removeProductInfo(id);
        if (!inventoryRepository.existsById(id)){
            return ResponseEntity
                    .badRequest()
                    .body("Error: Product with id: "+id+" does not exist");
        }else {
        return  ResponseEntity.ok("product Info is deleted");
    }
    }

}
