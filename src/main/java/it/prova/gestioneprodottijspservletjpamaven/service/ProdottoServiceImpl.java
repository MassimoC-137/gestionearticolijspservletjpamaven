package it.prova.gestioneprodottijspservletjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneprodottijspservletjpamaven.dao.ProdottoDAO;
import it.prova.gestioneprodottijspservletjpamaven.model.Prodotto;
import it.prova.gestioneprodottijspservletjpamaven.web.listener.LocalEntityManagerFactoryListener;

public class ProdottoServiceImpl implements ProdottoService{

	private ProdottoDAO prodottoDao; 
	
	@Override
	public void setProdottoDAO(ProdottoDAO prodottoDao) {
		this.prodottoDao = prodottoDao;
		
	}

	@Override
	public void inserisci(Prodotto input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			prodottoDao.setEntityManager(entityManager);
			prodottoDao.create(input);
			entityManager.getTransaction().commit();
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Prodotto caricaSingolo(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			prodottoDao.setEntityManager(entityManager);
			return prodottoDao.read(id);
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Prodotto> caricaLista() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			prodottoDao.setEntityManager(entityManager);
			return prodottoDao.readAll(); 
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Prodotto input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			prodottoDao.setEntityManager(entityManager);
			prodottoDao.update(input);
			entityManager.getTransaction().commit();
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Prodotto input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			prodottoDao.setEntityManager(entityManager);
			prodottoDao.delete(input);
			entityManager.getTransaction().commit();
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}


}
