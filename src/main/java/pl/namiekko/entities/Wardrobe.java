package pl.namiekko.entities;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Wardrobe {
	@Id
	private BigInteger id;
	
	private BigInteger ownerId;
	@Size(min = 2)
	private User name;
	private String description;
	@DBRef
	private List<Piece> contents;
	@DBRef
	private Size mainSize;
	private URI profilePic;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(BigInteger ownerId) {
		this.ownerId = ownerId;
	}

	public User getName() {
		return name;
	}

	public void setName(User name) {
		this.name = name;
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
