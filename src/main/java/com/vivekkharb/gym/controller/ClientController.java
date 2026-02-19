package com.vivekkharb.gym.controller;

import com.vivekkharb.gym.entity.Client;
import com.vivekkharb.gym.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    // GET all clients
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = service.getAllClients();
        return ResponseEntity.ok(clients);
    }

    // POST multiple clients
    @PostMapping("/addMultipleClients")
    public ResponseEntity<String> addMultipleClients(@RequestBody List<Client> clients) {
        service.addMultipleClients(clients);
        return ResponseEntity.ok("Clients added successfully");
    }
}
