package com.otc.OneTeamCare.careteamcommunication.models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.otc.OneTeamCare.StringJsonUserType;

import java.sql.Timestamp;


/**
 * The persistent class for the careteamcommunication database table.
 * 
 */
@Entity
@NamedQuery(name="Careteamcommunication.findAll", query="SELECT c FROM Careteamcommunication c")
@TypeDefs( {@TypeDef( name= "StringJsonObject", typeClass = StringJsonUserType.class)})
public class Careteamcommunication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="logical_id")
	private String logicalId;
	@Type(type = "StringJsonObject")
	private Object category;
	@Type(type = "StringJsonObject")
	private Object content;

	private Timestamp published;

	@Column(name="resource_type")
	private String resourceType;

	private Timestamp updated;

	@Column(name="version_id")
	private String versionId;

	
	
	public Careteamcommunication(String logicalId, Content category, Content content, Timestamp published,
			String resourceType, Timestamp updated, String versionId) {
		super();
		this.logicalId = logicalId;
		this.category = category;
		this.content = content;
		this.published = published;
		this.resourceType = resourceType;
		this.updated = updated;
		this.versionId = versionId;
	}

	public Careteamcommunication() {
	}

	public String getLogicalId() {
		return this.logicalId;
	}

	public void setLogicalId(String logicalId) {
		this.logicalId = logicalId;
	}

	public Object getCategory() {
		return this.category;
	}

	public void setCategory(Object category) {
		this.category = category;
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