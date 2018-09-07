package br.com.cvc.constantes;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import br.com.cvc.exception.CvcAppSystemException;

public class Constantes {
	public static String URL_CIDADE = "https://cvcbackendhotel.herokuapp.com/hotels/avail/";
	public static String URL_HOTEL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	public static long ZERO = 0l;
	public static double COMISSAO = 30;

	public static Date convertStringeParaDate(String StringData) throws CvcAppSystemException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			return formato.parse(StringData);
		} catch (Exception e) {
			throw new CvcAppSystemException(e.getMessage(), e);
		}
		
	}

	public static String convergeObjetoParaJson(Object objeto) {
		Gson gson = new Gson();
		return gson.toJson(objeto);
	}

	public static double formataDouble(double valor) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return Double.parseDouble(df.format(valor).replaceAll("\\.", "").replace(",", "."));
	}
}
