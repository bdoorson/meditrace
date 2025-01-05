package com.meditrace.application.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;

public class BaseLayout extends VerticalLayout {

    private final VerticalLayout topRowLayout = new VerticalLayout();
    private final TabSheet tabSheet = new TabSheet();

    public BaseLayout() {
        getStyle().setPadding("0 10px").setBackgroundColor("#f2f5f6");
        setSizeFull();

        topRowLayout.setSizeFull();
        topRowLayout.add(tabSheet);

        tabSheet.setVisible(false);
        tabSheet.setSizeFull();
        tabSheet.getStyle().setBackgroundColor("white");
        tabSheet.addThemeVariants(TabSheetVariant.LUMO_TABS_SMALL/*, TabSheetVariant.LUMO_BORDERED*/);

        add(topRowLayout);
    }

    protected VerticalLayout getTopRowLayout() {
        return topRowLayout;
    }

    protected TabSheet getTab() {
        return tabSheet;
    }

    protected void setTabsVisible(boolean visible) {
        tabSheet.setVisible(visible);
    }

    protected void addTab(VaadinIcon icon, String name, Component component) {
        tabSheet.add(new Span(icon.create(), new Text(" " + name)), component);
    }

    protected void addTab(VaadinIcon icon, Component component) {
        tabSheet.add(icon.create(), component);
    }

    protected void addTab(String label, Component component) {
        tabSheet.add(label, component);
    }
}