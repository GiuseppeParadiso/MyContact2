package it.paradisogiuseppe.services;

import it.paradisogiuseppe.dao.HibernateDao;

public class HibernateService {
	
	public static void createSession(){
		HibernateDao.createSession();
	}
	
	public static void closeSession(){
		HibernateDao.closeSession();
	}
}
