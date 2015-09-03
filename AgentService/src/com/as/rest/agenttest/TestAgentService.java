package com.as.rest.agenttest;

import java.util.List;

import junit.framework.TestCase;

import com.as.rest.agent.service.AgentService;
import com.as.rest.agent.vo.Agent;

public class TestAgentService extends TestCase {
	AgentService agentService;

	protected void setUp() throws Exception {
		agentService = new AgentService();
		super.setUp();
	}	
	protected void tearUp() throws Exception{
		agentService=new AgentService();
		super.tearDown();
	}

	public void testAgentbyZipCode(){
		agentService=new AgentService();
		List<Agent> agent =agentService.getAgentbyZipcode("1854");
		//assertEquals("Numery Zaber", agent.  agentName.toString());
	}
}
