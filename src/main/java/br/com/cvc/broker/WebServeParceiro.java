package br.com.cvc.broker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.cvc.exception.CvcAppBusinessException;
import br.com.cvc.exception.CvcAppSystemException;
import br.com.cvc.vo.HotelVO;

public class WebServeParceiro {

	private String url;

	public WebServeParceiro(String url) {
		super();
		this.url = url;
	}

	public List<HotelVO> obterBrokerParceiro() throws CvcAppSystemException {

		try {

			URL obj = new URL(this.url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSendig GET  url " + url);
			System.out.println("\nResponse Code  url " + responseCode);
			
			if(responseCode != 200) {
				throw new CvcAppBusinessException("Erro serviço broker parceiro");
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			Gson gson = new Gson();
			List<HotelVO> listaHoteis = new ArrayList<>();
			Type type = new TypeToken<List<HotelVO>>() {
			}.getType();
			listaHoteis = gson.fromJson(response.toString(), (Type) type);
			return listaHoteis;

		} catch (Exception e) {
			throw new CvcAppSystemException(e.getMessage(), e);
		}

	}

}
