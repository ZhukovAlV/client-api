package com.unibell.client.service;

import com.unibell.client.entity.Contact;

import java.util.List;

public interface ContactService {

    /**
     * Добавление нового контакта клиента (телефон или email)
     * @param clientId ID клиента
     * @param type тип контакта
     * @param value значение
     * @return контакт
     */
    Contact add(Long clientId, String type, String value);

    /**
     * Получение списка контактов клиента по ID
     * @param clientId ID клиента
     * @return список контактов
     */
    List<Contact> getContactsByClientId(Long clientId);

    /**
     * Получение списка контактов клиента по ID и типу контакта
     * @param clientId ID клиента
     * @return список контактов
     */
    List<Contact> getClientContactsByType(Long clientId, String contactType);

}
