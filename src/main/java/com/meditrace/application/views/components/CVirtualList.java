package com.meditrace.application.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.Style;

import java.util.Collection;

public class CVirtualList<T> extends VerticalLayout {

    private final VirtualList<T> virtualList = new VirtualList<>();

    public CVirtualList() {
        virtualList.getStyle()
                .setPosition(Style.Position.RELATIVE)
//                .setWidth("545px")
                .setWidth("65%")
                .setMaxWidth("-webkit-fill-available")
                .setBackgroundColor("#f2f5f6")
                .setHeight("490px")
                .setMaxHeight("650px");

        virtualList.setRenderer(cardRenderer);

        add(virtualList);
    }

    public ComponentRenderer<Component, T> getCardRenderer() {
        return cardRenderer;
    }

    public CVirtualList<T> setItems(Iterable<T> items) {
        virtualList.setItems((Collection<T>) items);
        add(virtualList);
        return this;
    }

    private final ComponentRenderer<Component, T> cardRenderer = new ComponentRenderer<>(
            person -> {
                HorizontalLayout cardLayout = new HorizontalLayout();
                cardLayout.getStyle()
//                        .setWidth("500px")
                        .setWidth("100%")
                        .setBorderRadius("5px")
                        .setBoxShadow("0 3px 5px var(--lumo-shade-10pct)")
                        .setPadding("var(--lumo-space-l) var(--lumo-space-m)")
                        .setBackgroundColor("var(--lumo-base-color)")
                        .setMaxWidth("-webkit-fill-available");

                cardLayout.setMargin(true);

                VerticalLayout infoLayout = new VerticalLayout();
                infoLayout.setSpacing(false);
                infoLayout.setPadding(false);
//                infoLayout.getElement().appendChild(
//                        ElementFactory.createStrong(person.getFirstName() + " " + person.getLastName()));
//                infoLayout.add(new Div(new Text(person.getAddress())));
//
//                VerticalLayout contactLayout = new VerticalLayout();
//                contactLayout.setSpacing(false);
//                contactLayout.setPadding(false);
//                contactLayout.add(new Div(new Text(person.getEmail())));
//                contactLayout
//                        .add(new Div(new Text(person.getPhone())));
//                infoLayout
//                        .add(new Details("Contact information", contactLayout));
//
//                cardLayout.add(infoLayout);
                return cardLayout;
            });
}

//    private ComponentRenderer<Component, PatientModel> clientCardRenderer = new ComponentRenderer<>(
//            person -> {
//                HorizontalLayout cardLayout = new HorizontalLayout();
//                cardLayout.getStyle()
//                        .setWidth("500px")
//                        .setBorderRadius("5px")
//                        .setBoxShadow("0 3px 5px var(--lumo-shade-10pct)")
//                        .setPadding("var(--lumo-space-l) var(--lumo-space-m)")
//                        .setBackgroundColor("var(--lumo-base-color)");
//
//
//                cardLayout.setMargin(true);
//
//                VerticalLayout infoLayout = new VerticalLayout();
//                infoLayout.setSpacing(false);
//                infoLayout.setPadding(false);
//                infoLayout.getElement().appendChild(
//                        ElementFactory.createStrong(person.getFirstName() + " " + person.getLastName()));
//                infoLayout.add(new Div(new Text(person.getAddress())));
//
//                VerticalLayout contactLayout = new VerticalLayout();
//                contactLayout.setSpacing(false);
//                contactLayout.setPadding(false);
//                contactLayout.add(new Div(new Text(person.getEmail())));
//                contactLayout
//                        .add(new Div(new Text(person.getPhone())));
//                infoLayout
//                        .add(new Details("Contact information", contactLayout));
//
//                cardLayout.add(infoLayout);
//                return cardLayout;
//            });
