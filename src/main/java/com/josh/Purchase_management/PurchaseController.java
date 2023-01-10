package com.josh.Purchase_management;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

class PurchaseController {

    private final PurchaseRepository repository;

    PurchaseController(PurchaseRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/purchases")
    List<Purchase> all() {
        return repository.findAll();
    }

    @PostMapping("/purchases")
    Purchase getNewPurchase(@RequestBody Purchase newPurchase) {
        return repository.save(newPurchase);
    }

    @GetMapping("/purchases/{id}")
    Purchase one(@PathVariable long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PurchaseNotFoundException(id));
    }

    @PutMapping("/purchases/{id}")
    Purchase replacePurchase(@RequestBody Purchase newPurchase, @PathVariable long id) {

        return repository.findById(id)
                .map(purchase -> {
                    purchase.setName(newPurchase.getName());
                    purchase.setType(newPurchase.getType());
                    return repository.save(purchase);
                })
                .orElseGet(() -> {
                    newPurchase.setId(id);
                    return  repository.save(newPurchase);
                });
    }

    @DeleteMapping("/orders/{id}")
    void deletePurchase(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
