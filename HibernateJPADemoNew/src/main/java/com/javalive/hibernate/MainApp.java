package com.javalive.hibernate;

import javax.persistence.EntityManager;

/**
 * @author JavaLive.com
 */
public class MainApp {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		// Check database version
		String sql = "select version()";

		String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
		System.out.println(result);

		entityManager.getTransaction().commit();
		entityManager.close();

		JPAUtil.shutdown();
	}
}
