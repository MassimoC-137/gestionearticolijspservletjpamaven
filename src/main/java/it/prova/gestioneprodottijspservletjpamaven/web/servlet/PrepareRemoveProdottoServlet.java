package it.prova.gestioneprodottijspservletjpamaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneprodottijspservletjpamaven.service.MyServiceFactory;

@WebServlet("/PrepareRemoveProdottoServlet")
public class PrepareRemoveProdottoServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdProdottoToRemove = request.getParameter("idProdotto");  
		
		if (!NumberUtils.isCreatable(parametroIdProdottoToRemove)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			request.setAttribute("prodotto_da_rimuovere", MyServiceFactory.getProdotto_Service_Instance()
					.caricaSingolo(Long.parseLong(parametroIdProdottoToRemove)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
