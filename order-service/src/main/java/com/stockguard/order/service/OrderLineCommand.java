package com.stockguard.order.service;

import java.math.BigDecimal;

public record OrderLineCommand(String sku, int quantity, BigDecimal unitPrice) {
}
