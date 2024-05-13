package it.prova.gestioneprodottijspservletjpamaven.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneprodottijspservletjpamaven.model.Prodotto;

public class ProdottoDAOImpl implements ProdottoDAO{
	
	private EntityManager entityManager; 

	@Override
	public void create(Prodotto input) throws Exception {
		if (input == null) {
			throw new Exception("Errore valore input.");
		}
		entityManager.persist(input);
	}

	@Override
	public Prodotto read(Long id) throws Exception {
		return entityManager.find(Prodotto.class, id);
	}

	@Override
	public List<Prodotto> readAll() throws Exception {
		return entityManager.createQuery("FROM Prodotto", Prodotto.class).getResultList();
	}

	@Override
	public void update(Prodotto input) throws Exception {
		if (input == null) {
			throw new Exception("Errore valore input.");
		}
		input = entityManager.merge(input); 
	}

	@Override
	public void delete(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Errore valore input.");
		}
		entityManager.remove(entityManager.merge(id));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager; 
	}
	
}
