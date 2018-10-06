package com.lolpick.lolcounter_rest.utility;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.lolpick.lolcounter_rest.utility.HibernateUtil;

import static org.junit.Assert.*;

public class HibernateUtilTest {

	@Test
	public void testGetSessionFactory() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		assertNotNull(sessionFactory);	
	}
}