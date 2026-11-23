package com.stockguard.inventory.service;

public class InventoryItemNotFoundException extends RuntimeException {

    public InventoryItemNotFoundException(String sku) {
        super("inventory item not found: " + sku);
    }
}
