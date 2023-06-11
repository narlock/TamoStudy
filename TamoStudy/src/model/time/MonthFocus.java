package model.time;

import java.util.List;

public class MonthFocus {
	private Long profileId;
	private List<MonthFocusEntry> monthFocusEntries;
	
	public MonthFocus(Long profileId, List<MonthFocusEntry> monthFocusEntries) {
		super();
		this.profileId = profileId;
		this.monthFocusEntries = monthFocusEntries;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public List<MonthFocusEntry> getMonthFocusEntries() {
		return monthFocusEntries;
	}

	public void setMonthFocusEntries(List<MonthFocusEntry> monthFocusEntries) {
		this.monthFocusEntries = monthFocusEntries;
	}
	
	
}
