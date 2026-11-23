package com.stockguard.order.web.dto;

import com.stockguard.order.service.OrderLineCommand;
import com.stockguard.order.service.PlaceOrderCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record PlaceOrderRequest(
        @NotBlank String customerId,
        @NotEmpty @Valid List<OrderLineRequest> lines) {

    public PlaceOrderCommand toCommand() {
        return new PlaceOrderCommand(
                customerId,
                lines.stream()
                        .map(l -> new OrderLineCommand(l.sku(), l.quantity(), l.unitPrice()))
                        .toList());
    }
}
