package com.meditrace.application.views.dashboard;

import com.meditrace.application.models.PatientModel;
import com.meditrace.application.views.components.BaseLayout;
import com.meditrace.application.views.components.CVirtualList;
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

import java.util.List;

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

        CVirtualList<PatientModel> virtualList = new CVirtualList<>();

        virtualList.setItems(List.of(
                new PatientModel(59, "Eve", "Iron", "eve.iron@gmail.com"),
                new PatientModel(60, "John", "Doe", ""),
                new PatientModel(61, "Jane", "Doe", ""),
                new PatientModel(62, "John", "Doe", ""),
                new PatientModel(63, "Jane", "Doe", ""),
                new PatientModel(64, "John", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(65, "Jane", "Doe", ""),
                new PatientModel(66, "John", "Doe", "")
        ));

        addTab(VaadinIcon.HOME, "Home", new HorizontalLayout(virtualList, additionalInformation()));
        addTab(VaadinIcon.FILE_PRESENTATION, "Laboratorium", new VerticalLayout());
        addTab(VaadinIcon.MEDAL, "Beeldvorming", new VerticalLayout());
        addTab(VaadinIcon.FILE, "Documenten", new VerticalLayout());

        HorizontalLayout buttonLayout = new HorizontalLayout(newClientButton, searchClientButton);
        getTopRowLayout().addComponentAtIndex(0, buttonLayout);
    }

    private VerticalLayout additionalInformation() {
        return new VerticalLayout();
    }
}