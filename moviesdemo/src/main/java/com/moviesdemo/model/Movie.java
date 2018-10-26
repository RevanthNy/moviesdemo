/**
 * This is the class for creating the objects for application and creating the properties
 */
package com.moviesdemo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Revanth Reddy
 *
 */
@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@Column(name = "id")
	private  int id;
	@Column(name = "title")
    private  String title;
	@Column(name = "synopsis")
    private  String synopsis;
	@Column(name = "released_year")
    private  String releasedYear;
	@Column(name = "media_type")
    private  String mediaType;


    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }


    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
  
    
    public String getSynopsis() {
        return synopsis;
    }
    
    public void setSynopsis(String synopsis) {
    	this.synopsis = synopsis;
    }
    
    
    public String getReleasedYear() {
        return releasedYear;
    }
    
    public void setReleasedYear(String releasedYear) {
    	this.releasedYear = releasedYear;
    }

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

}
