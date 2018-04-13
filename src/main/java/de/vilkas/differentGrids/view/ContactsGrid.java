package de.vilkas.differentGrids.view;

import com.vaadin.ui.Grid;
import de.vilkas.differentGrids.model.Contact;

import java.util.Collection;

public class ContactsGrid extends Grid<Contact> {
    private Collection<Contact> contacts;

    public ContactsGrid() {
    }

    public ContactsGrid(final Collection<Contact> contacts) {
        this();
        this.contacts = contacts;
        addColumn(Contact::getId, id -> String.valueOf(id))
                .setCaption("Id");

        addColumn(Contact::getName)
                .setCaption("Name");

        setItems(contacts);
    }
}
