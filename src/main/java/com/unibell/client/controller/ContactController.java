package com.unibell.client.controller;

import com.unibell.client.entity.Contact;
import com.unibell.client.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * 2. Добавление нового контакта клиента (телефон или email)
     */
    @PostMapping("/{clientId}/add")
    public ResponseEntity<Contact> add(
            @PathVariable Long clientId,
            @RequestParam String type,
            @RequestParam String value) {
        Contact newContact = contactService.add(clientId, type, value);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    /**
     * 5. Получение списка контактов заданного клиента
     */
    @GetMapping("/{clientId}/all")
    public ResponseEntity<List<Contact>> getContactsByClientId(@PathVariable Long clientId) {
        List<Contact> contacts = contactService.getContactsByClientId(clientId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    /**
     * 6. Получение списка контактов заданного типа заданного клиента
     */
    @GetMapping("/{clientId}/type/get{contactType}")
    public ResponseEntity<List<Contact>> getContactsByClientIdAndType(
            @PathVariable Long clientId,
            @RequestParam(value = "type", required = false) String contactType) {
        List<Contact> contacts = contactService.getClientContactsByType(clientId, contactType);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

}
