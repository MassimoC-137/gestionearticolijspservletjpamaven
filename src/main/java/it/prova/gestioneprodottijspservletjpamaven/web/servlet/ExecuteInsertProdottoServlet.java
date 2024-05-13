package it.prova.gestioneprodottijspservletjpamaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneprodottijspservletjpamaven.model.Prodotto;
import it.prova.gestioneprodottijspservletjpamaven.service.MyServiceFactory;
import it.prova.gestioneprodottijspservletjpamaven.utility.UtilityProdottoForm;

@WebServlet("/ExecuteInsertProdottoServlet")
public class ExecuteInsertProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codiceInputParam = request.getParameter("codice");
		String categoriaInputParam = request.getParameter("categoria");
		String descrizioneInputParam = request.getParameter("descrizione");
		String prezzoInputParam = request.getParameter("prezzo");
		String dataArrivoInputParam = request.getParameter("dataArrivo");
		String disponibilitaInputParam = request.getParameter("disponibilita");

		Prodotto prodottoInstance = UtilityProdottoForm.createProdottoFromParams(codiceInputParam, categoriaInputParam,
				descrizioneInputParam, prezzoInputParam, dataArrivoInputParam, disponibilitaInputParam);

		if (!UtilityProdottoForm.validateArticoloBean(prodottoInstance)) {
			request.setAttribute("insert_prodotto_attr", prodottoInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione.");
			request.getRequestDispatcher("/prodotto/insert.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getProdotto_Service_Instance().inserisci(prodottoInstance);
			request.setAttribute("listaProdottiAttribute",
					MyServiceFactory.getProdotto_Service_Instance().caricaLista());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/prodotto/results.jsp").forward(request, response); 
	}
}
