package de.vilkas.differentGrids.view;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import de.vilkas.differentGrids.model.Company;
import de.vilkas.differentGrids.model.Contact;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@SpringUI
public class MainView extends UI {

    VerticalLayout gridContainer;
    //just to avoid a nullpointer :)
    CompanyGrid companyGrid = new CompanyGrid();
    ContactsGrid contactsGrid = new ContactsGrid();
    @Override
    protected void init(final VaadinRequest request) {
        Button hideGridsBtn = new Button("hide Grids", e -> hideGrids());
        Button companysBnt = new Button("Companies", e -> handleCompaniesClick());
        Button contactsBtn = new Button("Contacts", e -> handleContactsClick());
        HorizontalLayout buttonsLayout = new HorizontalLayout(hideGridsBtn, companysBnt, contactsBtn);
        gridContainer = new VerticalLayout();
        VerticalLayout mainLayout = new VerticalLayout(buttonsLayout, gridContainer);
        setContent(mainLayout);
    }

    private void handleContactsClick() {
        final Optional<Company> selectedCompany = companyGrid.getSelectedItem();
        if (selectedCompany.isPresent()) {
            showContacts(selectedCompany.get().getContacts());
        } else {
            Notification.show("Please select a Company First");
        }
    }

    private void showContacts(final Collection<Contact> contacts) {
        gridContainer.removeAllComponents();
        contactsGrid = new ContactsGrid(contacts);
        gridContainer.addComponents(new Label("Contacts"), contactsGrid);
    }

    private void handleCompaniesClick() {
        gridContainer.removeAllComponents();
        //here you usually get the companies from backend
        companyGrid = new CompanyGrid(getCompanies());
        gridContainer.addComponents(new Label("Companies"), companyGrid);
    }


    private void hideGrids() {
        gridContainer.removeAllComponents();
    }

    private Collection<Company> getCompanies() {
        return Arrays.asList(
                new Company(1L, "Volkswagen",
                        Arrays.asList(new Contact(1L, "Bosh"), new Contact(2L, "AutoMotiv"))),

                new Company(2L, "Burgerking",
                        Arrays.asList(new Contact(3L, "FreshMeatsor"), new Contact(4L, "Breddy Bred")))
        );
    }


}
