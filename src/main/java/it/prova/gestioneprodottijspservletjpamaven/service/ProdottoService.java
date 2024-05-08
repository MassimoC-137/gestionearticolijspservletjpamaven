package it.prova.gestioneprodottijspservletjpamaven.service;

import java.util.List;

import it.prova.gestioneprodottijspservletjpamaven.dao.ProdottoDAO;
import it.prova.gestioneprodottijspservletjpamaven.model.Prodotto;

public interface ProdottoService {
	
	public void setProdottoDAO(ProdottoDAO prodottoDao); 
	
	public void inserisci(Prodotto input) throws Exception; 
	
	public Prodotto caricaSingolo(Long id) throws Exception; 
	
	public List<Prodotto> caricaLista() throws Exception; 
	
	public void aggiorna(Prodotto input) throws Exception; 
	
	public void rimuovi(Prodotto input) throws Exception; 

}
