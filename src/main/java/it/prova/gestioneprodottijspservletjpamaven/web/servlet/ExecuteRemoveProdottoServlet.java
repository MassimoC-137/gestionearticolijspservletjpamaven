package it.prova.gestioneprodottijspservletjpamaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneprodottijspservletjpamaven.service.MyServiceFactory;

@WebServlet("/ExecuteRemoveProdottoServlet")
public class ExecuteRemoveProdottoServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdProdottoToRemove = request.getParameter("idProdotto"); 
		Long idProdottoToRemove = Long.parseLong(parametroIdProdottoToRemove);
		
		if (!NumberUtils.isCreatable(parametroIdProdottoToRemove)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getProdotto_Service_Instance().rimuovi(idProdottoToRemove); 
		} catch (Exception e) {
			
		}
	}
}
