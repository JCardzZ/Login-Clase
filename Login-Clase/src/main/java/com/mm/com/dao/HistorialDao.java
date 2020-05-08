package com.mm.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mm.com.model.TbHistorial;



public class HistorialDao {

	public void agregarDatosHistorial(TbHistorial his) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Login-Clase");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(his);
		em.flush();
		em.getTransaction().commit();
	}
}
