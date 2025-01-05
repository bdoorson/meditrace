package com.meditrace.application.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.function.ValueProvider;

import java.util.Collection;

public abstract class CGrid<T> extends VerticalLayout {

    private final Grid<T> grid = new Grid<>();
    private final CFilter<T> filter = new CFilter<>();
    private int pageNumber = 1;

    public CGrid() {
        setSizeFull();
        grid.setSizeFull();
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

        getSearcButton().addClickListener(e -> nextPage(pageNumber));
        getNextButton().addClickListener(e -> nextPage(pageNumber++));
        getBackButton().addClickListener(e -> nextPage(pageNumber--));

        add(filter, grid);
    }

    public Grid<T> getGrid() {
        return grid;
    }

    public Grid.Column<T> addColumn(ValueProvider<T, ?> valueProvider, String header, Component component) {
        Grid.Column<T> tColumn = grid.addColumn(valueProvider).setHeader(header);
        this.filter.addFilterComponent(component);
        return tColumn;
    }

    public void setItems(Iterable<T> items) {
        grid.setItems((Collection<T>) items);
    }

    public void addComponentColumn(String header, ValueProvider<T, ? extends Component> component) {
        grid.addComponentColumn(component).setHeader(header);
    }

    public abstract void nextPage(int pageNumber);

    public Button getSearcButton() {
        return filter.getSearchButton();
    }

    public Button getBackButton() {
        return filter.getBackButton();
    }

    public Button getNextButton() {
        return filter.getNextButton();
    }
}