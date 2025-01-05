package com.meditrace.application.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.*;

import java.util.List;

public class CFilter<T> extends FormLayout {

    private final Button searchButton = new Button("Search");
    private final Button backButton = new Button("Back");
    private final Button nextButton = new Button("Next");

    public CFilter() {
        searchButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        backButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        nextButton.addThemeVariants(ButtonVariant.LUMO_SMALL);

        setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("320px", 2),
                new ResponsiveStep("500px", 3));
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public List<Component> getComponents() {
        return getChildren().toList();
    }

    public void addFilterComponent(Component component) {
        if (component != null) {
            if (component instanceof TextField textField) textField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
            else if (component instanceof IntegerField integerField)
                integerField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
            else if (component instanceof EmailField emailField)
                emailField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
            else if (component instanceof BigDecimalField bigDecimalField)
                bigDecimalField.addThemeVariants(TextFieldVariant.LUMO_SMALL);

            add(component);

            if (!getChildren().toList().isEmpty()) add(searchButton, backButton, nextButton);
        }
    }
}