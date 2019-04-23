package hr.posteni.poduzetnik.events.ui.components;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import hr.posteni.poduzetnik.events.model.Event;
import hr.posteni.poduzetnik.events.service.CityService;
import hr.posteni.poduzetnik.events.service.EventService;
import hr.posteni.poduzetnik.events.service.OrgUnitService;

public class EditDialog extends Dialog {

	private static final long serialVersionUID = -1148821584840657438L;
	
	private OrgUnitService orgUnitService;
	private CityService cityService;
	private EventService eventService;
	
	private Grid<Event> gridEvents;
	private Event currentEvent;
	
	public EditDialog(Event event, Grid<Event> gridEvents, OrgUnitService orgUnitService, CityService cityService, EventService eventService) {
		this.currentEvent = event;
		this.gridEvents = gridEvents;
		this.orgUnitService = orgUnitService;
		this.cityService = cityService;
		this.eventService = eventService;
		
		setWidth("500px");
		setCloseOnOutsideClick(false);
				
		initDialog();		
	}

	private void initDialog() {		
		
		EditEventForm editForm = new EditEventForm(orgUnitService, cityService);
		editForm.setWidthFull();
		
		editForm.getTxtName().setValue(currentEvent.getName());
		editForm.getComboCounties().setValue(currentEvent.getCity().getOrgUnit());
		editForm.getComboCities().setValue(currentEvent.getCity());
		editForm.getDatePickerStart().setValue(currentEvent.getDateStart());
		editForm.getDatePickerEnd().setValue(currentEvent.getDateEnd());
		editForm.getChkBoxFreeEntry().setValue(currentEvent.getIsEntryFree());
		
		editForm.getBtnClear().setVisible(false);
		editForm.getBtnCancel().addClickListener(e -> close());
		editForm.getBtnSave().addClickListener(event -> updateEvent(editForm));
		
		add(editForm);	
	}

	private void updateEvent(EditEventForm editForm) {
		currentEvent.setName(editForm.getTxtName().getValue());
		currentEvent.setCity(editForm.getComboCities().getValue());
		currentEvent.setDateStart(editForm.getDatePickerStart().getValue());
		currentEvent.setDateEnd(editForm.getDatePickerEnd().getValue());
		currentEvent.setIsEntryFree(editForm.getChkBoxFreeEntry().getValue());
		
		try {
			eventService.save(currentEvent);
			close();
			gridEvents.getDataProvider().refreshAll();			
			Notification.show("Uspješno je uređen događaj: " + currentEvent.getName(), 3000, Position.MIDDLE);				
		} catch (Exception ex) {
			Notification.show("Dogodila se greška kod uređivanja događaja: " + currentEvent.getName() + "!\nPokušajte ponovno ili kontaktirajte administratora.", 
					3000, Position.MIDDLE);
			ex.printStackTrace();
		}
		
	}

}
