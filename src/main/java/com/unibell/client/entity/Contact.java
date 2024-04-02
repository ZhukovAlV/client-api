package com.unibell.client.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Контакт
 */
@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Тип контакта ("email", "telephone")
     */
    @Enumerated(EnumType.STRING)
    private ContactTypeEnum type;

    /**
     * Значение
     */
    @Column(name = "value_text")
    private String value;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
