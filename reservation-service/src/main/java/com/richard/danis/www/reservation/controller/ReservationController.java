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

    private ReservationRepository repository;

    public ReservationController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") long id) {
        return this.repository.findById(id).get();
    }
}
