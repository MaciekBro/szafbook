package pl.namiekko.entities;

import java.net.URI;
import java.util.List;

import javax.validation.constraints.Size;

public class Wardrobe {
	private User owner;
	@Size(min = 2)
	private User name;
	private String description;
	private List<Piece> contents;
	private Size mainSize;
	private URI profilePic;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Piece> getContents() {
		return contents;
	}

	public void setContents(List<Piece> contents) {
		this.contents = contents;
	}

	public Size getMainSize() {
		return mainSize;
	}

	public void setMainSize(Size mainSize) {
		this.mainSize = mainSize;
	}

	public URI getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(URI profilePic) {
		this.profilePic = profilePic;
	}

}
