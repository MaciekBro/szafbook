package pl.namiekko.entities;

import java.math.BigInteger;
import java.net.URI;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	/** compulsory first screen attributes */

	@Id
	private BigInteger id;

	@Pattern(regexp = "\\S{2,30}")
	private String userName;
	@Email
	@NotNull	
	private String email;

	/** optional first screen attributes */

	private String displayedName;
	private String description;

	private Calendar birthday;
	private URI profilePic;

	/** lifecycle and customization attributes */

	@DBRef
	private Size defaultSize;

	/** e.g. "normal" and "pregnant" */
	@DBRef
	private List<Size> sizes;
	@DBRef
	private List<Wardrobe> wardrobes;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDisplayedName() {
		return displayedName;
	}

	public void setDisplayedName(String displayedName) {
		this.displayedName = displayedName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public Size getDefaultSize() {
		return defaultSize;
	}

	public void setDefaultSize(Size defaultSize) {
		this.defaultSize = defaultSize;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	public List<Wardrobe> getWardrobes() {
		return wardrobes;
	}

	public void setWardrobes(List<Wardrobe> wardrobes) {
		this.wardrobes = wardrobes;
	}

	public URI getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(URI profilePic) {
		this.profilePic = profilePic;
	}

}
