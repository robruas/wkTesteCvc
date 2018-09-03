package br.com.cvc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.cvc.vo.HotelVO;
import net.sf.json.JSONObject;

public class ServicoBrokerTest {
	
//	@Test
//	public void testaConexaoComServicdorJson() throws IOException, ParseException {
//        //https://cvcbackendhotel.herokuapp.com/hotels/avail/1032
//		String url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/1032";
//		URL obj = new URL(url);
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("verificar", "verificar");
//		
//		int responseCode = con.getResponseCode();
//		System.out.println("\nSendig GET  url " + url);
//		System.out.println("\nResponse Code  url " + responseCode);
//		
//		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//		
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
//		Gson gson =  new Gson();
//		List<HotelVO> hotelVO2 = new ArrayList<>();
//		Type hotelType = new TypeToken<List<HotelVO>>() {}.getType();
//		hotelVO2 = gson.fromJson(response.toString(), (Type) hotelType);
//		System.out.println(response.toString());
//		System.out.println(hotelVO2.get(0).getCityCode());
//		
//	}
	
	@Test
	public void calculaHospedga() {
		
		double valorAdult  = 1372.54;
        double valorChild = 848.61;
        long dias = 10;
        double comissao = 30;
        
        valorAdult = valorAdult * dias;
        //comissao = comissao / 100;
        double totalAdulto = ((comissao / 100) * valorAdult) / 0.7;
        
        
        DecimalFormat df = new DecimalFormat("#,###.00");
        String vl = df.format(totalAdulto);
        
        Double valorDouble = Double.parseDouble(vl.replaceAll("\\.","").replace(",","."));
       
        System.out.println(valorDouble);
        		
		
	}

}
