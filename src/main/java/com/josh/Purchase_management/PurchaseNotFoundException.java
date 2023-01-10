package com.josh.Purchase_management;

class PurchaseNotFoundException extends RuntimeException {

    PurchaseNotFoundException(Long id) {
        super("Could not find purchase " + id);
    }
}
