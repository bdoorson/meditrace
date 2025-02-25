package com.meditrace.application.views.dashboard;

import com.meditrace.application.views.components.BaseLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Dashboard")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.DASHCUBE)
public class DashboardView extends BaseLayout {

    private final Button newClientButton = new Button(VaadinIcon.PLUS.create());
    private final Button searchClientButton = new Button(VaadinIcon.SEARCH.create());

    public DashboardView() {
        newClientButton.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

        searchClientButton.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

        setTabsVisible(true);
        getTab().addThemeVariants(TabSheetVariant.LUMO_TABS_SMALL);

        addTab(VaadinIcon.HOME, "Home", new HomeComponent());
        addTab(VaadinIcon.FILE_PRESENTATION, "Laboratorium", new VerticalLayout());
        addTab(VaadinIcon.MEDAL, "Beeldvorming", new VerticalLayout());
        addTab(VaadinIcon.FILE, "Documenten", new VerticalLayout());

        HorizontalLayout buttonLayout = new HorizontalLayout(newClientButton, searchClientButton);
        getTopRowLayout().addComponentAtIndex(0, buttonLayout);
    }
}