package br.com.cvc.constantes;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.cvc.exception.CvcAppSystemException;

public class Constantes {
	public static String URL_CIDADE = "https://cvcbackendhotel.herokuapp.com/hotels/avail/";
	public static String URL_HOTEL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	public static long ZERO = 0l;
	public static double COMISSAO = 30;

	
	/**
	 * Converte String Para Data
	 * @param StringData
	 * @return Date
	 * @throws CvcAppSystemException
	 */
	public static Date converteStringeParaDate(String StringData) throws CvcAppSystemException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			return formato.parse(StringData);
		} catch (Exception e) {
			throw new CvcAppSystemException(e.getMessage(), e);
		}

	}

	/**
	 * Converte Objetro para Json
	 * @param objeto
	 * @return String
	 */
	public static String convergeObjetoParaJson(Object objeto) {
		Gson gson = new Gson();
		return gson.toJson(objeto);
	}

	/**
	 * Formada valor #,###.00
	 * @param valor
	 * @return
	 */
	public static double formataDouble(double valor) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return Double.parseDouble(df.format(valor).replaceAll("\\.", "").replace(",", "."));
	}

	/**
	 * Converte Json para uma lista de objeto
	 * @param object
	 * @param json
	 * @return
	 */
	public static <T> ArrayList<T> converteJsonListaObjeto(Class<T> object, final String json) {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<T>>() {
		}.getType();
		ArrayList<T> list = new ArrayList<>();
		list = gson.fromJson(json.toString(), (Type) type);
		return list;

	}
}
