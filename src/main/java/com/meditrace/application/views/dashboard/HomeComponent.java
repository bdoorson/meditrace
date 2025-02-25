package com.meditrace.application.views.dashboard;

import com.meditrace.application.models.ReasonForComingModel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.ElementFactory;

import java.time.LocalDate;
import java.util.List;

public class HomeComponent extends HorizontalLayout {

    public final List<ReasonForComingModel> reasonForComingList = List.of(
            new ReasonForComingModel("HIV", "Ik heb HIV"),
            new ReasonForComingModel("Kanker", "Ik heb kanker"),
            new ReasonForComingModel("Griep", "Ik heb griep"),
            new ReasonForComingModel("Koorts", "Ik heb koorts"),
            new ReasonForComingModel("Jigt", "Ik heb jigt"),

            new ReasonForComingModel("HIV", "Ik heb HIV"),
            new ReasonForComingModel("Kanker", "Ik heb kanker"),
            new ReasonForComingModel("Griep", "Ik heb griep"),
            new ReasonForComingModel("Koorts", "Ik heb koorts"),
            new ReasonForComingModel("Jigt", "Ik heb jigt"),
            new ReasonForComingModel("HIV", "Ik heb HIV"),
            new ReasonForComingModel("Kanker", "Ik heb kanker"),
            new ReasonForComingModel("Griep", "Ik heb griep"),
            new ReasonForComingModel("Koorts", "Ik heb koorts"),
            new ReasonForComingModel("Jigt", "Ik heb jigt"));

    public HomeComponent() {
        VirtualList<ReasonForComingModel> reasonForComingModelVirtualList = new VirtualList<>();
        reasonForComingModelVirtualList.setItems(reasonForComingList);
        reasonForComingModelVirtualList.setRenderer(personCardRenderer);
        reasonForComingModelVirtualList.getStyle().setHeight("640px").set("flex", "none").setWidth("50%");
        add(reasonForComingModelVirtualList, basicInformation());
    }

    private VerticalLayout basicInformation() {
        Header header = new Header(new H1("Basic Information"));
        TextField firstNameField = new TextField("First name");
        TextField lastNameField = new TextField("Last name");
        DatePicker dateOfBirthPicker = new DatePicker("Date of birth");
        Select<String> genderSelect = new Select<>();
        genderSelect.setLabel("Gender");
        genderSelect.setItems("male", "female");

        firstNameField.setValue("Rene");
        lastNameField.setValue("Sardjoe Missier");
        dateOfBirthPicker.setValue(LocalDate.now());
        genderSelect.setValue("male");

        firstNameField.setWidthFull();
        lastNameField.setWidthFull();
        dateOfBirthPicker.setWidthFull();
        genderSelect.setWidthFull();
        return new VerticalLayout(header, firstNameField, lastNameField, dateOfBirthPicker, genderSelect);
    }

    private ComponentRenderer<Component, ReasonForComingModel> personCardRenderer = new ComponentRenderer<>(
            person -> {
                HorizontalLayout cardLayout = new HorizontalLayout();
                cardLayout.getStyle()
                        .setBorder("solid 2px grey")
                        .setBorderRadius("10px")
                        .setPadding("15px");
//                        .setWidth("50%");
                cardLayout.setMargin(true);

                VerticalLayout infoLayout = new VerticalLayout();
                infoLayout.setSpacing(false);
                infoLayout.setPadding(false);
                infoLayout.getElement().appendChild(
                        ElementFactory.createStrong("R.V.K: " + person.getName()));
//                infoLayout.add(new Div(new Text(person.getDescription())));

                VerticalLayout contactLayout = new VerticalLayout();
                contactLayout.setSpacing(false);
                contactLayout.setPadding(false);
                contactLayout.add(new Div(new Text(person.getDescription())));
//                contactLayout
//                        .add(new Div(new Text(person.getAddress().getPhone())));
                infoLayout
                        .add(new Details("Description", contactLayout));

                cardLayout.add(infoLayout);
                return cardLayout;
            });
}