package com.meditrace.application.views.admin;

import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Admin")
@Route("admin")
@RouteAlias("admins")
@Menu(order = 1, icon = LineAwesomeIconUrl.CRITICAL_ROLE)
public class AdminView {


}
