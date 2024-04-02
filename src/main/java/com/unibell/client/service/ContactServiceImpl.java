package com.unibell.client.service;

import com.unibell.client.entity.Client;
import com.unibell.client.entity.Contact;
import com.unibell.client.entity.ContactTypeEnum;
import com.unibell.client.exceptions.ClientNotFoundException;
import com.unibell.client.repository.ClientRepository;
import com.unibell.client.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ClientRepository clientRepository;

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact add(Long clientId, String type, String value) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);

        if (clientOpt.isPresent()) {
            Contact contact = new Contact();
            contact.setType(ContactTypeEnum.getEnumByValue(type));
            contact.setValue(value);
            contact.setClient(clientOpt.get());
            contactRepository.save(contact);
            return contact;
        } else {
            throw new ClientNotFoundException("Client not found with id: " + clientId);
        }
    }

    @Override
    public List<Contact> getContactsByClientId(Long clientId) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);

        if (clientOpt.isPresent()) {
            return clientOpt.get().getContacts();
        } else {
            throw new ClientNotFoundException("Client not found with id: " + clientId);
        }
    }

    @Override
    public List<Contact> getClientContactsByType(Long clientId, String contactType) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);

        if (clientOpt.isPresent()) {
            return clientOpt.get().getContacts().stream()
                    .filter(contact -> contact.getType().getValue().equalsIgnoreCase(contactType))
                    .collect(Collectors.toList());
        } else {
            throw new ClientNotFoundException("Client not found with id: " + clientId);
        }
    }

}
