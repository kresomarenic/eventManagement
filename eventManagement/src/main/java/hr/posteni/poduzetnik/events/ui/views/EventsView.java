package hr.posteni.poduzetnik.events.ui.views;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import hr.posteni.poduzetnik.events.model.City;
import hr.posteni.poduzetnik.events.service.CityService;
import hr.posteni.poduzetnik.events.service.EventService;
import hr.posteni.poduzetnik.events.service.OrgUnitService;
import hr.posteni.poduzetnik.events.ui.components.EventsGrid;
import hr.posteni.poduzetnik.events.ui.components.FilteringForm;

@Route(value = "events", layout=MainView.class)
public class EventsView extends VerticalLayout {

	private static final long serialVersionUID = -6994313443189012722L;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private OrgUnitService orgUnitService;
	
	@Autowired
	private CityService cityService;
	
	private FilteringForm filtering;
	private EventsGrid eventsGrid;
	
	public EventsView(EventService eventService, OrgUnitService orgUnitService, CityService cityService) {
		this.eventService = eventService;
		this.orgUnitService = orgUnitService;
		this.cityService = cityService;
		
		initLayout();		
	}
	

	private void initLayout() {
		
		Label titleLabel = new Label();
		titleLabel.getElement().setProperty("innerHTML", "<h1>Pregled događanja</h1>");
		
		HorizontalLayout content = new HorizontalLayout();
		initEventsGrid();
		initFiltering();		
		content.add(filtering, eventsGrid);
		content.setSizeFull();
		
		add(titleLabel, content);
		setHorizontalComponentAlignment(Alignment.CENTER, titleLabel);
		setSizeFull();
	}


	private void initEventsGrid() {
		eventsGrid = new EventsGrid(eventService, orgUnitService, cityService);			
	}

	private void initFiltering() {
		
		filtering = new FilteringForm(orgUnitService, cityService);
		filtering.getTxtName().addValueChangeListener(e -> applyFilter());
		filtering.getComboCities().addValueChangeListener(event -> applyFilter());
		filtering.getDatePickerStart().addValueChangeListener(event -> applyFilter());
		filtering.getDatePickerEnd().addValueChangeListener(event -> applyFilter());
		filtering.getComboFreeEntry().addValueChangeListener(e -> applyFilter());		
	}
	
	private void applyFilter() {
		
		eventsGrid.getDataProvider().clearFilters();
		if (filtering.getTxtName().getValue() != null) {
			eventsGrid.getDataProvider().addFilter(event -> StringUtils.containsIgnoreCase(event.getName(), filtering.getTxtName().getValue()));
		}		
		if (filtering.getComboCities().getValue() != null) {
			for (City city : filtering.getComboCities().getValue()) {
				eventsGrid.getDataProvider().addFilterByValue(event -> event.getCity().getName(), city.getName());				
			}
		}
		if (filtering.getDatePickerStart().getValue() != null) {
			eventsGrid.getDataProvider().addFilter(event -> filtering.getDatePickerStart().getValue().compareTo(event.getDateStart()) <= 0);
		}
		if (filtering.getDatePickerEnd().getValue() != null) {
			eventsGrid.getDataProvider().addFilter(event -> filtering.getDatePickerEnd().getValue().compareTo(event.getDateEnd()) >= 0);
		}
		if (filtering.getComboFreeEntry().getValue() != null) {
			eventsGrid.getDataProvider().addFilter(event -> Objects.equals(filtering.getComboFreeEntry().getValue(), event.getIsEntryFree()));
		}		
	}
	
}
