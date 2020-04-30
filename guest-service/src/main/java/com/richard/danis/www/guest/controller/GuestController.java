package com.richard.danis.www.guest.controller;

import com.richard.danis.www.guest.business.Guest;
import com.richard.danis.www.guest.business.GuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private final GuestRepository repository;
    private final Environment environment;

    public GuestController(GuestRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return this.repository.findAll();
    }

    @GetMapping("/port")
    public @ResponseBody
    String backendPort() {
        LOGGER.info("Pinged.");
        return environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") long id) {
        return this.repository.findById(id).get();
    }
}
