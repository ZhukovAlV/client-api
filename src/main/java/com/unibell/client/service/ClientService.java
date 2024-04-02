package com.unibell.client.service;

import com.unibell.client.entity.Client;

import java.util.List;

public interface ClientService {

    /**
     * Добавление клиента
     * @return клиент
     */
    Client add(Client client);

    /**
     * Получение всех клиентов
     * @return список клиентов
     */
    List<Client> getAll();

    /**
     * Получение клиента по ID
     * @return клиент
     */
    Client getById(Long clientId);

}
