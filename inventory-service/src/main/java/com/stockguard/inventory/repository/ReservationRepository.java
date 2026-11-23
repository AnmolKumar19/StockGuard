package com.stockguard.inventory.repository;

import com.stockguard.inventory.domain.Reservation;
import com.stockguard.inventory.domain.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByReservationId(UUID reservationId);

    boolean existsByReservationId(UUID reservationId);

    List<Reservation> findByStatusAndExpiresAtBefore(ReservationStatus status, Instant cutoff);
}
