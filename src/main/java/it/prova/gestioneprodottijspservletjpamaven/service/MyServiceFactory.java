package it.prova.gestioneprodottijspservletjpamaven.service;

import it.prova.gestioneprodottijspservletjpamaven.dao.ProdottoDAO;
import it.prova.gestioneprodottijspservletjpamaven.dao.ProdottoDAOImpl;

public class MyServiceFactory {

	private static ProdottoService Prodotto_Service_Instance = null;
	private static ProdottoDAO ProdottoDAO_Instance = null; 

	public static ProdottoService getProdotto_Service_Instance() {
		if (Prodotto_Service_Instance == null) {
			Prodotto_Service_Instance = new ProdottoServiceImpl();
		}
		if (ProdottoDAO_Instance == null) {
			ProdottoDAO_Instance = new ProdottoDAOImpl();
		}
		Prodotto_Service_Instance.setProdottoDAO(ProdottoDAO_Instance);
		return Prodotto_Service_Instance;
	}
}
