package model.time;

import java.util.List;

public class DailyFocus {
	
	private Long profileId;
	private List<DailyFocusEntry> dailyFocusEntries;

	public DailyFocus(Long profileId, List<DailyFocusEntry> dailyFocusEntry) {
		super();
		this.profileId = profileId;
		this.dailyFocusEntries = dailyFocusEntry;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public List<DailyFocusEntry> getDailyFocusEntries() {
		return dailyFocusEntries;
	}

	public void setDailyFocusEntries(List<DailyFocusEntry> dailyFocusEntry) {
		this.dailyFocusEntries = dailyFocusEntry;
	}
}
