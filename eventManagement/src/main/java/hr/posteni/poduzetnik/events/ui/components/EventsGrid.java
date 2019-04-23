package hr.posteni.poduzetnik.events.ui.components;

import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.LocalDateRenderer;

import hr.posteni.poduzetnik.events.model.Event;
import hr.posteni.poduzetnik.events.service.CityService;
import hr.posteni.poduzetnik.events.service.EventService;
import hr.posteni.poduzetnik.events.service.OrgUnitService;
import hr.posteni.poduzetnik.events.ui.views.AddEventView;

public class EventsGrid extends VerticalLayout {

	private static final long serialVersionUID = -3703586126660296697L;
	
	private static final String BTN_EDIT = "btnEdit";
	
	private OrgUnitService orgUnitService;
	private CityService cityService;
	private EventService eventService;
	
	private Button btnAddNew;	
	private Grid<Event> gridEvents;	
	private ListDataProvider<Event> dataProvider;
	
	public EventsGrid(EventService eventService, OrgUnitService orgUnitService, CityService cityService) {
		this.orgUnitService = orgUnitService;
		this.cityService = cityService;
		this.eventService = eventService;
		
		initLayout();
		populateGridEvents();
	}
	
	public Button getBtnAddNew() {
		return btnAddNew;
	}
	
	public Grid<Event> getGridEvents() {
		return gridEvents;
	}

	public ListDataProvider<Event> getDataProvider() {
		return dataProvider;
	}

	private void initLayout() {

		btnAddNew = new Button("Dodaj novi događaj");
		btnAddNew.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnAddNew.addClickListener(event -> redirectToInputForm());
		
		gridEvents = new Grid<Event>();
		gridEvents.addThemeVariants(GridVariant.LUMO_ROW_STRIPES, GridVariant.MATERIAL_COLUMN_DIVIDERS);
		gridEvents.setSizeFull();

		gridEvents.addColumn(Event::getName).setHeader("Naziv");
		gridEvents.addColumn(event -> event.getCity().getName()).setHeader("Lokacija");
		gridEvents.addColumn(new LocalDateRenderer<>(Event::getDateStart, "dd.MM.yyyy.")).setHeader("Početak");
		gridEvents.addColumn(new LocalDateRenderer<>(Event::getDateEnd, "dd.MM.yyyy.")).setHeader("Završetak");	
		gridEvents.addComponentColumn(event -> renderEntryIcon(event.getIsEntryFree())).setHeader("Ulaz slobodan");
		gridEvents.addComponentColumn(event -> renderEditButton(event)).setKey(BTN_EDIT);
		
		add(btnAddNew, gridEvents);		
	}
	
	private Button renderEditButton(Event event) {
		Button btnEdit = new Button("Uredi");
		btnEdit.addClickListener(e -> openEditDialog(event));
		return btnEdit;		
	}	
	
	private Icon renderEntryIcon(Boolean isEntryFree) {
		Icon icon;
		if (isEntryFree) {
			icon = new Icon(VaadinIcon.CHECK);
			icon.setColor("green");				
		} else {
			icon = new Icon(VaadinIcon.CLOSE);
			icon.setColor("red");
		}
		return icon;
	}
	
	private void redirectToInputForm() {		
		UI.getCurrent().navigate(AddEventView.class);
	}
	
	private void populateGridEvents() {
		List<Event> eventList = eventService.findAll();
		gridEvents.setItems(eventList);
		dataProvider = new ListDataProvider<Event>(eventList);
		gridEvents.setDataProvider(dataProvider);		
	}
	
	private void openEditDialog(Event event) {		
		EditDialog editDialog = new EditDialog(event, gridEvents, orgUnitService, cityService, eventService);
		editDialog.open();		
	}
	
}
