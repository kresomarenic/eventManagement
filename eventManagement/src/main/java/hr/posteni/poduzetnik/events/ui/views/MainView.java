package hr.posteni.poduzetnik.events.ui.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Theme(value=Lumo.class, variant="dark")
public class MainView extends AppLayout implements RouterLayout {
	
	private static final long serialVersionUID = -8941678727484499779L;
	
	private AppLayoutMenuItem addEvent;
	private AppLayoutMenuItem eventsView;

	public MainView() {
		
		initLayout();
    }

	private void initLayout() {
		
		AppLayoutMenu menu = createMenu();
		
		addEvent = new AppLayoutMenuItem("Unos", "addEvent");
		eventsView = new AppLayoutMenuItem("Pregled", "events");
		
		menu.addMenuItem(addEvent);
		menu.addMenuItem(eventsView);
		
		setBranding(new Span(new H2("DOGAĐANJA ONLINE")));		
		
	}
	
}
