package rs.ftn.reviewer.rest.ejb;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rs.ftn.reviewer.rest.dao.AbstractEntity;


@Entity
@Table (name = "Tag")
public class Tag extends AbstractEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column (name = "name")
	private String name;
	
	@Column (name = "date_modified")
	private Date dateModified;
	

	public Tag() {}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name 
				+ "]";
	}
	
}
