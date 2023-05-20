package model.time;

/**
 * DailyFocusEntry
 * 
 * @author narlock
 *
 * Represents a singular month focus entry.
 * Like an entry inside of a database, this entry
 * has a 'primary key' so-to-say that is dependent
 * on a day (Long, 22, like 22nd),
 * on the month (Long, like 4 for April), and a
 * year (like 2023, for 2023), and stores the
 * time on the specific day.
 */
public class DailyFocusEntry {

	private Long day;
	
	private Long month;
	
	private Long year;
	
	private Long time;

	public DailyFocusEntry(Long day, Long month, Long year, Long time) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.time = time;
	}
	
	public Long getDay() {
		return day;
	}
	
	public void setDay(Long day) {
		this.day = day;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
}
