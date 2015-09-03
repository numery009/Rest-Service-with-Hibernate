package com.as.agentclient;
import com.as.agentclient.vo.Agent;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AgentServiceClient {

	public static final String baseURL = "http://localhost:7001/AgentService/rest/agent/get/01854";

	
	private static WebResource getResource(String url) {
		Client client = Client.create();
		WebResource webResource = client.resource(url);
		return webResource;

	}
	
	public static void main(String[] args) {
		WebResource webresource = getResource(baseURL);
		ClientResponse response = webresource.accept("application/xml").get(ClientResponse.class);
		System.out.println(response.getClientResponseStatus());

		Agent agent = response.getEntity(Agent.class);
		System.out.println(agent.getAgentId());
		System.out.println(agent.getAgentName());
		System.out.println(agent.getAgentAddress());
		System.out.println(agent.getCity());
		System.out.println(agent.getState());
		System.out.println(agent.getZipCode());
	}		
}
