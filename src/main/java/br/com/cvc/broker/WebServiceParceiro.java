package br.com.cvc.broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.cvc.exception.CvcAppBusinessException;
import br.com.cvc.exception.CvcAppSystemException;
import br.com.cvc.generic.ObejectGeneric;
import br.com.cvc.vo.HotelVO;

public class WebServiceParceiro {

	private String url;

	public WebServiceParceiro(String url) {
		super();
		this.url = url;
	}
	
	/**
	 * Obter Broker Parceiro
	 * @param
	 * @return List<HotelVO>
	 * @throws CvcAppSystemException
	 */

	public  List<HotelVO> obterBrokerParceiro() throws CvcAppSystemException {
		try {
			HttpURLConnection con = getReponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return ObejectGeneric.converteJsonListaObjeto(HotelVO.class, response.toString());
			
		} catch (Exception e) {
			throw new CvcAppSystemException(e.getMessage(), e);
		}
	}
	
    /**
     * Obter Response Parceiro 
     * @return HttpURLConnection
     * @throws MalformedURLException
     * @throws IOException
     * @throws ProtocolException
     * @throws CvcAppBusinessException
     */

	private HttpURLConnection getReponseCode()
			throws MalformedURLException, IOException, ProtocolException, CvcAppBusinessException {
		URL obj = new URL(this.url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSendig GET  url " + url);
		System.out.println("\nResponse Code  url " + responseCode);

		if (responseCode != 200) {
			throw new CvcAppBusinessException("Erro serviço broker parceiro");
		}
		return con;
	}

}
