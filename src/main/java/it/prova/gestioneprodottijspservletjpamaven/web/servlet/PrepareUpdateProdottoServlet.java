package it.prova.gestioneprodottijspservletjpamaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneprodottijspservletjpamaven.service.MyServiceFactory;

@WebServlet("/PrepareUpdateProdottoServlet")
public class PrepareUpdateProdottoServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdProdottoToUpdate = request.getParameter("idProdotto"); 
		Long idProdottoToUpdate = Long.parseLong(parametroIdProdottoToUpdate); 
		
		if (!NumberUtils.isCreatable(parametroIdProdottoToUpdate)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try {
			request.setAttribute("prodotto_da_modificare", MyServiceFactory.getProdotto_Service_Instance()
					.caricaSingolo(idProdottoToUpdate)); 
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/prodotto/update.jsp").forward(request, response); 
	}

}
