package hr.posteni.poduzetnik.events.ui.components;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import hr.posteni.poduzetnik.events.model.City;
import hr.posteni.poduzetnik.events.model.OrgUnit;
import hr.posteni.poduzetnik.events.model.OrgUnitType;
import hr.posteni.poduzetnik.events.service.CityService;
import hr.posteni.poduzetnik.events.service.OrgUnitService;

public class EditEventForm extends VerticalLayout {

	private static final long serialVersionUID = 9209835229761168369L;	
	
	private OrgUnitService orgUnitService;
	private CityService cityService;
	
	private TextField txtName;
	private ComboBox<OrgUnit> comboCounties;
	private ComboBox<City> comboCities;
	private DatePicker datePickerStart;
	private DatePicker datePickerEnd;
	private Checkbox chkBoxFreeEntry;
	private Button btnSave;
	private Button btnClear;
	private Button btnCancel;
	
	public EditEventForm(OrgUnitService orgUnitService, CityService cityService) {
		this.orgUnitService = orgUnitService;
		this.cityService = cityService;
		
		setWidth("25%");
		
		initLayout();		
		populateCounties(orgUnitService);
	}

	public TextField getTxtName() {
		return txtName;
	}

	public ComboBox<OrgUnit> getComboCounties() {
		return comboCounties;
	}

	public ComboBox<City> getComboCities() {
		return comboCities;
	}

	public DatePicker getDatePickerStart() {
		return datePickerStart;
	}

	public DatePicker getDatePickerEnd() {
		return datePickerEnd;
	}

	public Checkbox getChkBoxFreeEntry() {
		return chkBoxFreeEntry;
	}

	public Button getBtnSave() {
		return btnSave;
	}
	
	public Button getBtnClear() {
		return btnClear;
	}
	
	public Button getBtnCancel() {
		return btnCancel;
	}
	
	private void initLayout() {
		
		txtName = new TextField("Naziv događaja");
		txtName.setWidthFull();		
		
		comboCounties = new ComboBox<>("Županija");
		comboCounties.setItemLabelGenerator(OrgUnit::getName);
		comboCounties.addValueChangeListener(event -> populateCities(comboCounties.getValue(), cityService));
		comboCounties.setWidthFull();		
		
		comboCities = new ComboBox<>("Grad");
		comboCities.setAllowCustomValue(false);
		comboCities.setItemLabelGenerator(City::getName);
		comboCities.setWidthFull();		
		
		datePickerStart = new DatePicker("Početak");
		datePickerStart.setLocale(Locale.forLanguageTag("hr"));
		datePickerStart.setWidthFull();
		
		datePickerEnd = new DatePicker("Završetak");
		datePickerEnd.setLocale(Locale.forLanguageTag("hr"));
		datePickerEnd.setWidthFull();
		
		chkBoxFreeEntry = new Checkbox("Slobodan ulaz", false);
		
		HorizontalLayout buttons = new HorizontalLayout();
		btnSave = new Button("Spremi", VaadinIcon.CHECK.create());		
		btnClear = new Button("Poništi", VaadinIcon.CLOSE.create());
		btnClear.addClickListener(event -> clearInput());
		btnCancel = new Button("Odustani", VaadinIcon.CLOSE.create());		
		buttons.add(btnSave, btnClear, btnCancel);
		
		setHorizontalComponentAlignment(Alignment.CENTER, buttons);
		
		add(txtName, comboCounties, comboCities, datePickerStart, datePickerEnd, chkBoxFreeEntry, buttons);		
	}

	private void populateCounties(OrgUnitService orgUnitService) {
		List<OrgUnit> counties = orgUnitService.findAllByType(OrgUnitType.OU_TYPE_COUNTY);
		comboCounties.setItems(counties);
		
	}

	private void populateCities(OrgUnit county, CityService cityService) {
		Set<OrgUnit> counties = new HashSet<>();
		counties.add(county);
		List<City> cities = cityService.findAllByCounties(counties);
		comboCities.setItems(cities);		
	}
	
	public void clearInput() {			
		txtName.clear();
		comboCounties.clear();
		comboCities.clear();
		datePickerStart.clear();		
		datePickerEnd.clear();
		chkBoxFreeEntry.clear();
	}

}
