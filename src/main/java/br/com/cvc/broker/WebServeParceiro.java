package br.com.cvc.broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.cvc.vo.HotelVO;

public class WebServeParceiro {
	
	private String url;
	public WebServeParceiro(String url) {
		super();
		this.url = url;
	}

	public List<HotelVO> obterBrokerParceiro()
			throws MalformedURLException, IOException, ProtocolException {
		URL obj = new URL(this.url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSendig GET  url " + url);
		System.out.println("\nResponse Code  url " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		Gson gson = new Gson();
		List<HotelVO> listaHoteis = new ArrayList<>();
		Type type = new TypeToken<List<HotelVO>>() {}.getType();
		listaHoteis = gson.fromJson(response.toString(), (Type) type);
		return listaHoteis;
	}

}
