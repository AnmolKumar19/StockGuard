package com.stockguard.inventory.service;

/** A requested hold: {@code quantity} units of {@code sku}. */
public record LineCommand(String sku, int quantity) {
}
