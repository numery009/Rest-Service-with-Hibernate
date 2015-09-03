package com.as.rest.agent.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import sun.management.resources.agent;
import test.Log4JInitServlet;

import com.as.rest.agent.dao.AgentDAO;
import com.as.rest.agent.vo.Agent;

@Path("/agent")
public class AgentService extends Log4JInitServlet {

/*	static {
		// Log4J configuration
		try {
			PropertyConfigurator.configure("log4j.properties");
		} catch (RuntimeException e) {

		}
	}*/

	/**
	 * Logger for Log4J
	 */
	
	public AgentService(){
		super();
	}
	private static final Logger log = Logger.getLogger(AgentService.class);

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Agent creatAgent(Agent agent) {
		log.info("Service layer for CreateAgent");
		AgentDAO agentDAO = new AgentDAO();
		agent = agentDAO.makePersistent(agent);
		return agent;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Agent updateAgent(Agent agent) {
		log.info("Service layer for Update Agent");
		AgentDAO agentDAO = new AgentDAO();
		agent = agentDAO.updateAgent(agent);
		return agent;
	}

	@DELETE
	@Path("/delete/{agentId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String deleteAgent(@PathParam("agentId") int agentId) {
		log.info("Service layer for Delete Agent");
		AgentDAO agentDAO = new AgentDAO();
		Agent agent = new Agent();
		agent.setAgentId(agentId);
		agentDAO.makeTransient(agent);
		return agentId + " is deleted successfully.";
	}

	/*
	 * @GET
	 * 
	 * @Path("/get/{agentId}")
	 * 
	 * @Consumes(MediaType.APPLICATION_XML)
	 * 
	 * @Produces(MediaType.APPLICATION_XML) public Agent
	 * getAgent(@PathParam("agentId") int agentId){ AgentDAO agentDAO=new
	 * AgentDAO(); Agent agent =new Agent(); agent.setAgentId(agentId); agent=
	 * agentDAO.getAgent(agent); return agent; }
	 */

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_XML)
	public List<Agent> getAllAgent() {
		log.info("Service layer for Get All Agent");
		AgentDAO agentDAO = new AgentDAO();
		return agentDAO.getAllAgent();
	}

	@GET
	@Path("/getbyzipcode/{zipCode}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public List<Agent> getAgentbyZipcode(@PathParam("zipCode") String zipCode) {
		List<Agent> lstAgent=null;
		if (log.isDebugEnabled()) log.debug("This is debug" + "1" + "2" + "4");
		log.info("This is info");
		log.warn("This is warning");
		log.fatal("This is fatal");
		log.error("There is generated from this program");
		AgentDAO agentDAO = new AgentDAO();
		Agent agent = new Agent();
		agent.setZipCode(zipCode);
		lstAgent = agentDAO.getAgentbyZipcode(agent);
		return lstAgent;
	}
	
	@GET
	@Path("/getbyid/{agentId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Agent getAgentbyAgentId(@PathParam("agentId") int agentId) {				
		log.info("Service layer for get Agent by agentId");
		AgentDAO agentDAO = new AgentDAO();
		Agent agent = new Agent();
		agent.setAgentId(agentId);
		agent = agentDAO.getAgentbyAgentId(agent);
		return agent;
	}	
}
