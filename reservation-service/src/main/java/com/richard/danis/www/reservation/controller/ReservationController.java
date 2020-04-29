package com.richard.danis.www.reservation.controller;

import com.richard.danis.www.reservation.business.Reservation;
import com.richard.danis.www.reservation.business.ReservationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") long id) {
        return this.reservationRepository.findById(id).get();
    }
}
