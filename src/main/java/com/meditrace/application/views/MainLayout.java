package com.meditrace.application.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.List;

/**
 * The main view is a top-level placeholder for other views.
 */
@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        toggle.getStyle().setColor("white");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        viewTitle.getStyle().setMargin("18px 0").setColor("white");

        Div topBar = new Div(toggle, viewTitle);
        topBar.getStyle().setBackgroundColor("#223349").setWidth("100%").setDisplay(Style.Display.FLEX).setAlignItems(Style.AlignItems.CENTER)
                .set("box-shadow", "0px 3px 5px 0px rgba(0,0,0,0.23)")
                .set("-webkit-box-shadow", "0px 3px 5px 0px rgba(0,0,0,0.23)")
        .set("-moz-box-shadow", "0px 3px 5px 0px rgba(0,0,0,0.23)");

//        box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.23);
//        -webkit-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.23);
//        -moz-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.23);

        addToNavbar(true, topBar);
    }

    private void addDrawerContent() {
//        StreamResource imageResource = new StreamResource("MEDITRACE2.png", () ->
//                getClass().getResourceAsStream("/META-INF.resources/images/MEDITRACE2.png"));
//
//        Image logo = new Image(imageResource, "MEDITRACE logo");

        Image logo = new Image("/images/MEDITRACE2.png", "MEDITRACE logo");
        logo.setWidth("130px");

        Span appName = new Span("My App");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        Div header = new Div(logo);
        header.getStyle().setTextAlign(Style.TextAlign.CENTER).setJustifyContent(Style.JustifyContent.CENTER).setDisplay(Style.Display.FLEX).setPadding("20px").setBackgroundColor("white").setBorderBottom("solid 1px #ebeef1");

        Scroller scroller = new Scroller(createNavigation());
        scroller.getStyle().set("padding", "5px 3px").setBackgroundColor("white");

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        List<MenuEntry> menuEntries = MenuConfiguration.getMenuEntries();
        menuEntries.forEach(entry -> {
            if (entry.icon() != null) {
                nav.addItem(new SideNavItem(entry.title(), entry.path(), new SvgIcon(entry.icon())));
            } else {
                nav.addItem(new SideNavItem(entry.title(), entry.path()));
            }
        });

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        return MenuConfiguration.getPageHeader(getContent()).orElse("");
    }
}
