package com.requestors;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.datareader.ReadExcel;
import com.datasource.EnvironmentDetails;
import com.datasource.People;
import com.datasource.Task;
import com.utilities.Constants;
import com.utilities.HibernateUtils;
public class AssignmentToolManager {

	public static void readQCDefects() 
	{
		HibernateUtils obj = new HibernateUtils();
		Session session = obj.getSessionFactory().openSession();
		session.beginTransaction();

		List<Task> listTask = ReadExcel.readQCDefects();
		for(Task objTask : listTask)
		{
			objTask.setTask_type(Constants.DEFECT);
			if(objTask!=null)
				session.saveOrUpdate(objTask);
		}
		session.getTransaction().commit();
		session.close();
	}

	public static void readPeopleData() 
	{
		HibernateUtils obj = new HibernateUtils();
		Session session = obj.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<People> listPeople = ReadExcel.readPeopleData();
		for(People objPeople : listPeople)
		{
			if(objPeople!=null)
				session.saveOrUpdate(objPeople);
		}
		obj.shutdown();
	}

	public static void readEnvData() 
	{
		HibernateUtils obj = new HibernateUtils();
		Session session = obj.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<EnvironmentDetails> listEnvironment = ReadExcel.readEnvData();
		for(EnvironmentDetails objEnv : listEnvironment)
		{
			if(objEnv!=null)
				session.saveOrUpdate(objEnv);
		}
		obj.shutdown();
	}

	public static void getAllTasks() 
	{
		HibernateUtils obj = new HibernateUtils();
		Session session = obj.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Task.class);
		@SuppressWarnings("unchecked")
		List<Task> listTasks = criteria.list();
		
		System.out.println(listTasks);
		
		obj.shutdown();
	}

}