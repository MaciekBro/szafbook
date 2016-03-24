package pl.namiekko.entities;

import java.net.URI;
import java.util.List;

public class Piece {
	// todo: RDF-backed
	String type;
	Size size;
	// todo: enum
	String sex;
	String description;
	// todo: RDF-backed
	List<String> color;
	// todo: RDF-backed
	List<String> style;
	// todo: RDF-backed
	List<String> pattern;
	// todo: RDF-backed
	List<String> material;
	List<URI> photos;

	public List<URI> getPhotos() {
		return photos;
	}

	public void setPhotos(List<URI> photos) {
		this.photos = photos;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public List<String> getStyle() {
		return style;
	}

	public void setStyle(List<String> style) {
		this.style = style;
	}

	public List<String> getPattern() {
		return pattern;
	}

	public void setPattern(List<String> pattern) {
		this.pattern = pattern;
	}

	public List<String> getMaterial() {
		return material;
	}

	public void setMaterial(List<String> material) {
		this.material = material;
	}

}
