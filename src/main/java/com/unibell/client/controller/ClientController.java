package com.unibell.client.controller;

import com.unibell.client.entity.Client;
import com.unibell.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * 1. Добавление нового клиента
     */
    @PostMapping("/add")
    public ResponseEntity<Client> add(@RequestBody Client client) {
        Client newClient = clientService.add(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    /**
     * 3. Получение списка клиентов
     */
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.getAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    /**
     * 4. Получение информации по заданному клиенту (по id)
     */
    @GetMapping("/{clientId}/get")
    public ResponseEntity<Client> getById(@PathVariable Long clientId) {
        Client client = clientService.getById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
