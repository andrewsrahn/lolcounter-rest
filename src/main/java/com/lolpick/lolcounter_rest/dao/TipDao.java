package com.lolpick.lolcounter_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.lolpick.lolcounter_rest.entity.Tip;
import com.lolpick.lolcounter_rest.utility.HibernateUtil;

public class TipDao {
	public static List<Tip> readTips(){
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Tip", Tip.class).getResultList();
			
		} catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		} finally {
			session.close();
		}
	}
}
