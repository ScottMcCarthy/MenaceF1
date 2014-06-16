package menaceF1.wedding;

public class WeddingGuest {

	private boolean isFullGuest = false;
	private boolean isEveningGuest = false;
	private boolean isAdmin = false;

	public boolean isEveningGuest() {
		return isEveningGuest;
	}

	public void setEveningGuest(boolean isEveningGuest) {
		this.isEveningGuest = isEveningGuest;
		if (!this.isEveningGuest()) this.isFullGuest = false;
	}

	public boolean isFullGuest() {
		return isFullGuest;
	}

	public void setFullGuest(boolean isFullGuest) {
		this.isFullGuest = isFullGuest;
		if (this.isFullGuest) this.isEveningGuest = true;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
		if (this.isAdmin) {
			this.isEveningGuest = true;
			this.isFullGuest = true;
		}
	}
	
}
