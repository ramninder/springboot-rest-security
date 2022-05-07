package com.ramninder.security.controller;


import com.ramninder.security.model.Inventory;
import com.ramninder.security.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public  InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @PostMapping("/addProductInfo")
    public ResponseEntity<Inventory> saveProductInformation(@Valid @RequestBody Inventory inventory){
        return new ResponseEntity<Inventory>(inventoryService.saveProductInfo(inventory), HttpStatus.CREATED);
    }

    @GetMapping("/getProductById")
    public  ResponseEntity<Optional<Inventory>> getProductInformation(@PathVariable Long id){
        return  new ResponseEntity<Optional<Inventory>>(inventoryService.findProductInfoById(id), HttpStatus.OK);
    }

    @PutMapping("/updateProductInfo")
    public  ResponseEntity<Optional<Inventory>> updateProductInformation
            (@RequestBody Inventory inventory,@PathVariable Long id){
        return new ResponseEntity<Optional<Inventory>>(inventoryService.updateProductInfo(inventory, id),HttpStatus.OK);
    }

    @DeleteMapping("/removeProductInfo")
    public ResponseEntity<?> removeProductInfo(@PathVariable long id){
        inventoryService.removeProductInfo(id);
        return  ResponseEntity.ok("product Info is deleted");
    }

}
