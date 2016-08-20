package pl.namiekko.entities;

import java.math.BigInteger;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document
public class User implements UserDetails {

	/** compulsory first screen attributes */

	@Id
	private BigInteger id;

	@Size(min=2,max=30)
	private String username;
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
	
	@Transient
	@NotNull
    @Size(min=5,max=30)
	private String password1;
	
	@Transient
	@NotNull
    @Size(min=5,max=30)	
	private String password2;
	
	private String passwordEncrypted;
	private boolean confirmationStatus;
	private String confirmationId;
	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getPasswordEncrypted() {
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(String passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
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

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public boolean isConfirmationStatus() {
		return confirmationStatus;
	}

	public void setConfirmationStatus(boolean confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return passwordEncrypted;
	}

	public void setPassword(String password) {
		this.passwordEncrypted = password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isConfirmationStatus();
	}
}
