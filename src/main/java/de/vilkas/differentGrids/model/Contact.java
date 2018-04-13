package de.vilkas.differentGrids.model;

public class Contact {
    private Long id;
    private String name;

    public Contact(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
