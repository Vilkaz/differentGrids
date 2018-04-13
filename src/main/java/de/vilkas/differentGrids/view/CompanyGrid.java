package de.vilkas.differentGrids.view;

import com.vaadin.ui.Grid;
import de.vilkas.differentGrids.model.Company;

import java.util.Collection;
import java.util.Optional;

public class CompanyGrid extends Grid<Company> {


    private Collection<Company> companies;

    public CompanyGrid() {
    }

    public CompanyGrid(final Collection<Company> companies) {
        this();
        this.companies = companies;
        // the Value is Long, the lambda declares how to present it
        addColumn(Company::getId, i -> String.valueOf(i))
                .setCaption("Id");

        addColumn(Company::getName)
                .setCaption("Name");

        setSelectionMode(SelectionMode.SINGLE);
        setItems(companies);
    }

    public Optional<Company> getSelectedItem() {
        return getSelectionModel().getFirstSelectedItem();
    }

}
