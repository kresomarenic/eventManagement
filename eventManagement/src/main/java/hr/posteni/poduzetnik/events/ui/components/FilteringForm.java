package hr.posteni.poduzetnik.events.ui.components;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.vaadin.gatanaso.MultiselectComboBox;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import hr.posteni.poduzetnik.events.model.City;
import hr.posteni.poduzetnik.events.model.OrgUnit;
import hr.posteni.poduzetnik.events.model.OrgUnitType;
import hr.posteni.poduzetnik.events.service.CityService;
import hr.posteni.poduzetnik.events.service.OrgUnitService;

public class FilteringForm extends VerticalLayout {
	
	private static final long serialVersionUID = 3399276247862255149L;
	
	private OrgUnitService orgUnitService;
	private CityService cityService;
	
	private TextField txtName;
	private MultiselectComboBox<OrgUnit> comboRegions;
	private MultiselectComboBox<OrgUnit> comboCounties;
	private MultiselectComboBox<City> comboCities;
	private DatePicker datePickerStart;
	private DatePicker datePickerEnd;
	private ComboBox<Boolean> comboFreeEntry;
	
	public FilteringForm(OrgUnitService orgUnitService, CityService cityService) {	
		this.orgUnitService = orgUnitService;
		this.cityService = cityService;
		initLayout();		
	}	
	
	public TextField getTxtName() {
		return txtName;
	}

	public MultiselectComboBox<City> getComboCities() {
		return comboCities;
	}

	public DatePicker getDatePickerStart() {
		return datePickerStart;
	}

	public DatePicker getDatePickerEnd() {
		return datePickerEnd;
	}

	public ComboBox<Boolean> getComboFreeEntry() {
		return comboFreeEntry;
	}
	
	private void initLayout() {
		
		setWidth("25%");
		setHeight(null);
		
		Label filteringTitle = new Label();
		filteringTitle.getElement().setProperty("innerHTML", "<h2>Pretraga</h2>");
		
		txtName = new TextField();		
		txtName.setWidthFull();
		txtName.setPlaceholder("Naziv...");
		txtName.setValueChangeMode(ValueChangeMode.EAGER);		
				
		comboRegions = new MultiselectComboBox<>();		
		comboRegions.setPlaceholder("Odabirete regiju");
		comboRegions.setItemLabelGenerator(OrgUnit::getName);
		comboRegions.setItems(orgUnitService.findAllByType(OrgUnitType.OU_TYPE_REGION));
		comboRegions.addValueChangeListener(event -> populateCounties(comboRegions.getValue()));		
		
		comboCounties = new MultiselectComboBox<>();
		comboCounties.setPlaceholder("Odabirete županiju");
		comboCounties.setItemLabelGenerator(OrgUnit::getName);
		comboCounties.addValueChangeListener(event -> populateCities(comboCounties.getValue()));
		
		comboCities = new MultiselectComboBox<>();
		comboCities.setPlaceholder("Odabirete grad");
		comboCities.setItemLabelGenerator(City::getName);
		
		VerticalLayout regionFilterLayout = new VerticalLayout(comboRegions, comboCounties, comboCities);
		regionFilterLayout.setPadding(false);
		regionFilterLayout.setSpacing(false);
		regionFilterLayout.setWidthFull();
		
		datePickerStart = new DatePicker();
		datePickerStart.setPlaceholder("Datum početka...");
		datePickerStart.setWidthFull();
		datePickerStart.setLocale(Locale.forLanguageTag("hr"));
		
		datePickerEnd = new DatePicker();
		datePickerEnd.setPlaceholder("Datum završetka...");
		datePickerEnd.setWidthFull();
		datePickerEnd.setLocale(Locale.forLanguageTag("hr"));
		
		comboFreeEntry = new ComboBox<>();	
		comboFreeEntry.setPlaceholder("Slobodan ulaz (da/ne)");
		comboFreeEntry.setWidthFull();
		comboFreeEntry.setItems(true,false);		
		comboFreeEntry.setItemLabelGenerator(e -> setItemNames(e.booleanValue()));
		
		Button btnCancelSearch = new Button("Poništi pretragu");
		btnCancelSearch.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnCancelSearch.addClickListener(event -> clearSearchForm());
		
		add(filteringTitle, txtName, regionFilterLayout, datePickerStart, datePickerEnd, comboFreeEntry, btnCancelSearch);
		
		setHorizontalComponentAlignment(Alignment.CENTER, filteringTitle);
		setHorizontalComponentAlignment(Alignment.CENTER, btnCancelSearch);		
	}

	private String setItemNames(Boolean value) {
		if (value) {
			return "DA";
		}
		return "NE";
	}
	
	private void clearSearchForm() {
		txtName.clear();
		comboRegions.clear();
		comboCounties.clear();
		comboCities.clear();
		datePickerStart.clear();
		datePickerEnd.clear();
		comboFreeEntry.clear();		
	}
	
	private void populateCounties(Set<OrgUnit> orgUnits) {
		if (!orgUnits.isEmpty()) {
			List<OrgUnit> counties = orgUnitService.findAllByRegion(orgUnits);
			comboCounties.setItems(counties);
		} else {
			comboCounties.clear();
		}
	}
	
	private void populateCities(Set<OrgUnit> counties) {
		if (!counties.isEmpty()) {
			List<City> cities = cityService.findAllByCounties(counties);
			comboCities.setItems(cities);
		} else {
			comboCities.clear();
		}		
	}

}
