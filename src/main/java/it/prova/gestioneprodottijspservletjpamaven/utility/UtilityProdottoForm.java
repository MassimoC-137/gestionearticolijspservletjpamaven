package it.prova.gestioneprodottijspservletjpamaven.utility;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneprodottijspservletjpamaven.model.Categoria;
import it.prova.gestioneprodottijspservletjpamaven.model.Prodotto;

public class UtilityProdottoForm {

	public static Prodotto createProdottoFromParams(String codiceInputParam, String categoriaInputParam,
			String descrizioneInputParam, String prezzoInputParam, String dataArrivoInputParam,
			String disponibilitaInputParam) {

		Prodotto result = new Prodotto(codiceInputParam, descrizioneInputParam);

		if (EnumUtils.isValidEnum(Categoria.class, categoriaInputParam)) {
			result.setCategoria(Categoria.valueOf(categoriaInputParam));
		}
		if (NumberUtils.isCreatable(prezzoInputParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputParam));
		}
		if (NumberUtils.isCreatable(disponibilitaInputParam)) {
			result.setDisponibilita(Integer.parseInt(disponibilitaInputParam));
		}
		result.setDataArrivo(parseDataArrivoFromString(dataArrivoInputParam));

		return result;
	}

	public static boolean validateArticoloBean(Prodotto prodottoToBeValidated) {
		if (StringUtils.isBlank(prodottoToBeValidated.getCodice())
				|| StringUtils.isBlank(prodottoToBeValidated.getDescrizione())
				|| prodottoToBeValidated.getCategoria() == null
				|| !EnumUtils.isValidEnum(Categoria.class, prodottoToBeValidated.getCategoria().name())
				|| prodottoToBeValidated.getPrezzo() <= 0 || prodottoToBeValidated.getDataArrivo() == null) {
			return false;
		}
		return true;
	}

	public static LocalDate parseDataArrivoFromString(String dataArrivoInputParam) {
		if (StringUtils.isBlank(dataArrivoInputParam))
			return null;

		try {
			return LocalDate.parse(dataArrivoInputParam);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
}