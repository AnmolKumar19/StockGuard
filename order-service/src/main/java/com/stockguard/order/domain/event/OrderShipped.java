package com.stockguard.order.domain.event;

import java.util.UUID;

/**
 * Raised by the {@link com.stockguard.order.domain.Order} aggregate the moment it completes its
 * {@code ship()} transition. Purely an internal domain event: StockGuard has no message broker
 * (see the README's "why REST, not a broker" note), so this never leaves the Order Service's
 * process. It exists to decouple the aggregate from whatever reacts to a shipment internally
 * (today: {@link com.stockguard.order.domain.event.OrderShippedMetricsListener}) &mdash; the
 * aggregate records the fact that it shipped; it has no idea who, if anyone, cares.
 *
 * <p>Published only after the transition has been durably committed (see
 * {@code OrderService#transition}), so a listener only ever sees shipments that genuinely
 * happened &mdash; never a shipment that was about to be rolled back.
 */
public record OrderShipped(String orderNumber, UUID reservationId, String customerId) {
}
