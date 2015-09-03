package com.as.rest.agent.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tblagent")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="tblagent")

public class Agent implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "agentId")
	public int agentId;
	@Column(name = "agentName")
	public String agentName;
	@Column(name = "agentAddress")
	public String agentAddress;
	@Column(name = "city")
	public String city;
	@Column(name = "state")
	public String state;
	@Column(name = "zipCode")
	public String zipCode;
	
	@XmlElement(required=true)
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	@XmlElement(required=true)
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	@XmlElement(required=true)
	public String getAgentAddress() {
		return agentAddress;
	}
	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}
	
	@XmlElement(required=true)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@XmlElement(required=true)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@XmlElement(required=true)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
