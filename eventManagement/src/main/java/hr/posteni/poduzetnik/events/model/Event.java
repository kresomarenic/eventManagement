package hr.posteni.poduzetnik.events.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EVENT")
@Data
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EV_ID")
	private Long id;
	
	@Column(name="EV_NAME")
	private String name;
	
	@Column(name="EV_START")
	private LocalDate dateStart;
	
	@Column(name="EV_END")
	private LocalDate dateEnd;
	
	@Column(name="EV_FREE_ENTRY")
	private Boolean isEntryFree;
	
	@ManyToOne
    @JoinColumn(name="EV_CITY_ID")
    private City city;
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
