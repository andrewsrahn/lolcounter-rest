package com.lolpick.lolcounter_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.lolpick.lolcounter_rest.entity.Champion;
import com.lolpick.lolcounter_rest.utility.HibernateUtil;

public class ChampionDao {
	public static List<Champion> readChampions() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Champion", Champion.class).getResultList();
			
		} catch(Exception e) {
			System.out.println("ChampionDao#readChampions " + e.toString());
			return new ArrayList<>();
		} finally {
			session.close();
		}
	}
}
