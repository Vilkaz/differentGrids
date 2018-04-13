package de.vilkas.differentGrids.model;

import java.util.Collection;

public class Company {
    private Long id;
    private String name;
    private Collection<Contact> contacts;

    public Company(final Long id, final String name, final Collection<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }
}
