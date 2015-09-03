package com.as.rest.agent.dao;

import java.util.List;


//import net.sf.ehcache.distribution.ConfigurableRMIClientSocketFactory;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.model.AnnotatedMethod;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.Log4JInitServlet;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Example;
import net.sf.hibernate.expression.Expression;
import antlr.Parser;



import com.as.rest.agent.service.AgentService;
import com.as.rest.agent.vo.Agent;
import com.sun.org.apache.bcel.internal.classfile.Utility;

public class AgentDAO extends Log4JInitServlet {

	private static final Logger log = Logger.getLogger(AgentService.class);
	public Agent makePersistent(Agent agent) {
		log.info("DAO layer for Create Agent");
		try{
			Session session =HibernateUtil.getSessionFactory().openSession();
			Transaction tx=session.beginTransaction();
			session.save(agent);
			tx.commit();
			session.close();
		}
		catch(HibernateException ex){
			System.out.println(ex);
		}
		
		return agent;
	}

	public Agent updateAgent(Agent agent) {
		log.info("DAO layer for Update Agent");
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(agent);
			tx.commit();
			session.close();
		}
		catch (HibernateException ex) {
			System.out.println(ex);
		}
		return agent;
	}

	public void makeTransient(Agent agent) {
		log.info("DAO layer for Delete Agent");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.delete(agent);
			tx.commit();
			session.close();
		}catch (HibernateException ex) {
			System.out.println(ex);
		}
	}

	public Agent getAgent(Agent agent) {
		return agent;
	}

	
	@SuppressWarnings("unchecked")
	public List<Agent> getAllAgent() {
		List<Agent> agentsList=null;
		log.info("DAO layer for get all Agent");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();					
			agentsList = session.createCriteria(Agent.class).list();			
			session.close();
		} catch (HibernateException ex) {
			System.out.println(ex);
		}		
		return agentsList;
	}

	public List<Agent> getAgentbyZipcode(Agent agent) {
		log.info("DAO layer for get Agent by ZipCode");
		List<Agent> lstAgent = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();						
			Criteria crit = session.createCriteria(Agent.class);			
			lstAgent=crit.add(Expression.eq("zipCode", agent.getZipCode())).list();
			session.close();
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		return lstAgent;
	}
	
	public Agent getAgentbyAgentId(Agent agent){
		log.info("DAO layer for get Agent by agentId");
		Agent agent1 = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			agent1 = (Agent) session.load(Agent.class, agent.getAgentId() );
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			System.out.println(ex);			
		}
		return agent1;
	}
}
