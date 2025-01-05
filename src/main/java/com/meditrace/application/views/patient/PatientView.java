package com.meditrace.application.views.patient;

import com.meditrace.application.ContextProvider;
import com.meditrace.application.models.PatientModel;
import com.meditrace.application.service.PatientService;
import com.meditrace.application.utils.StringUtils;
import com.meditrace.application.views.components.BaseLayout;
import com.meditrace.application.views.components.CGrid;
import com.meditrace.application.vo.PatientVO;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Patients")
@Route("patient")
@RouteAlias("patients")
@Menu(order = 1, icon = LineAwesomeIconUrl.USER_INJURED_SOLID)
public class PatientView extends BaseLayout {

    private final PatientService patientService = ContextProvider.getBean(PatientService.class);

    private final IntegerField idIntegerField = new IntegerField("ID");
    private final TextField firstNameTextField = new TextField("First Name");
    private final TextField lastNameTextField = new TextField("Last Name");
    private final TextField emailTextField = new TextField("Email");

    private final CGrid<PatientModel> grid = new CGrid<>() {
        @Override
        public void nextPage(int pageNumber) {
            PatientVO patientVO = new PatientVO();
            patientVO.setId(idIntegerField.getValue());
            patientVO.setFirstName(StringUtils.getLowerCaseValue(firstNameTextField.getValue()));
            patientVO.setLastName(StringUtils.getLowerCaseValue(lastNameTextField.getValue()));
            patientVO.setEmail(StringUtils.getLowerCaseValue(emailTextField.getValue()));

            int pageSize = 15;
            grid.setItems(patientService.filter(pageNumber, pageSize, patientVO).getPatients());
        }
    };

    public PatientView() {
        setTabsVisible(false);

        grid.addColumn(PatientModel::getId, "ID", idIntegerField).setAutoWidth(true);
        grid.addColumn(PatientModel::getFirstName, "First Name", firstNameTextField);
        grid.addColumn(PatientModel::getLastName, "Last Name", lastNameTextField);
        grid.addColumn(PatientModel::getEmail, "Email", emailTextField).setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
        grid.setItems(patientService.getPatients());

        getTopRowLayout().add(grid);
    }
}