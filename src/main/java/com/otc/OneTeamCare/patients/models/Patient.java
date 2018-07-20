package com.otc.OneTeamCare.patients.models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.otc.OneTeamCare.StringJsonUserType;

import java.sql.Timestamp;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@TypeDefs( {@TypeDef( name= "StringJsonObject", typeClass = StringJsonUserType.class)})

@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="logical_id")
	private String logicalId;
	@Type(type = "StringJsonObject")
	private Object content;

	private Timestamp published;

	@Column(name="resource_type")
	private String resourceType;

	private Timestamp updated;

	@Column(name="version_id")
	private String versionId;

	public Patient() {
	}

	public String getLogicalId() {
		return this.logicalId;
	}

	public void setLogicalId(String logicalId) {
		this.logicalId = logicalId;
	}

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Timestamp getPublished() {
		return this.published;
	}

	public void setPublished(Timestamp published) {
		this.published = published;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getVersionId() {
		return this.versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

}