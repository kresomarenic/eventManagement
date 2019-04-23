package hr.posteni.poduzetnik.events.ui.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import hr.posteni.poduzetnik.events.model.Event;
import hr.posteni.poduzetnik.events.service.CityService;
import hr.posteni.poduzetnik.events.service.EventService;
import hr.posteni.poduzetnik.events.service.OrgUnitService;
import hr.posteni.poduzetnik.events.ui.components.EditEventForm;

@Route(value="addEvent", layout=MainView.class)
public class AddEventView extends VerticalLayout {
	
	private static final long serialVersionUID = -7156051352569320549L;
	
	@Autowired
	private OrgUnitService orgUnitService;	
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private EventService eventService;
	
	private EditEventForm inputForm;

	public AddEventView(OrgUnitService orgUnitService, CityService cityService) {		
		this.orgUnitService = orgUnitService;
		this.cityService = cityService;	
		
		initLayout();		
    }

	private void initLayout() {
		
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		
		Label titleLabel = new Label();
		titleLabel.getElement().setProperty("innerHTML", "<h1>Unos novog događanja</h1>");
				
		initInputForm();
		
        add(titleLabel, inputForm);		
	}

	private void initInputForm() {
		inputForm = new EditEventForm(orgUnitService, cityService);
		inputForm.getBtnSave().addClickListener(event -> saveEvent());
		inputForm.getBtnCancel().addClickListener(event -> cancelInput());
	}

	private void saveEvent() {
		
		Event event = new Event();
		try {
			event.setName(inputForm.getTxtName().getValue());
			event.setCity(inputForm.getComboCities().getValue());
			event.setDateStart(inputForm.getDatePickerStart().getValue());
			event.setDateEnd(inputForm.getDatePickerEnd().getValue());
			event.setIsEntryFree(inputForm.getChkBoxFreeEntry().getValue());		
			eventService.save(event);			
			Notification.show("Uspješno je kreiran događaj: " + event.getName(), 3000, Position.MIDDLE);
			inputForm.clearInput();
		} catch (Exception e) {			
			Notification.show("Dogodila se greška kod kreiranja događaja: " + event.getName() + "!\nPokušajte ponovno ili kontaktirajte administratora.", 
					3000, Position.MIDDLE);
			e.printStackTrace();
		}
	}
	
	private void cancelInput() {
		UI.getCurrent().navigate(EventsView.class);
	}
	
}
