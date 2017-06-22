package com.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	private SessionFactory sessionFactory;

	public HibernateUtils() {
		buildSessionFactory();
	}
	
	private void buildHibSessionFactory()
	{
		try
		{
			if(getSessionFactory() == null )
			{

				Configuration configuration = new Configuration().configure();
				ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
				registry.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
				setSessionFactory(configuration.buildSessionFactory(serviceRegistry));

			}
		}
		catch (Exception exception)
		{
			throw new ExceptionInInitializerError(exception);
		}

	}

	private void setSessionFactory(final SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public SessionFactory buildSessionFactory()
	{
		buildHibSessionFactory();
		return sessionFactory;
	}

	public void shutdown()
	{
		getSessionFactory().close();
	}
}
