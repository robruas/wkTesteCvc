package br.com.cvc.service;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.junit.Assert;
import org.junit.Test;

import br.com.cvc.broker.WebServiceParceiro;
import br.com.cvc.business.HospedagemBusiness;
import br.com.cvc.constantes.Constantes;
import br.com.cvc.exception.CvcAPIException;
import br.com.cvc.exception.CvcAppSystemException;
import br.com.cvc.vo.DadosHospedagemVO;
import br.com.cvc.vo.HotelVO;

public class ServicoBrokerTest {
	
	@Test
	public void testaConexaoBrokerParceiro() throws CvcAPIException {
		long codigo = 1l;
		String url = "https://cvcbackendhotel.herokuapp.com/hotels/" + 1;
        WebServiceParceiro webServiceParceiro = new WebServiceParceiro(url);
		
        try {
        	List<HotelVO> listHotel = webServiceParceiro.obterBrokerParceiro();
        	Assert.assertEquals(codigo,listHotel.get(0).getId());
		} catch (CvcAppSystemException e) {
			throw new CvcAPIException(e.getCause(), Status.NOT_FOUND);
		}
	}
	
	@Test
	public void calculoHospedagem() throws CvcAppSystemException {
		
		HospedagemBusiness hospedagemBusiness = new HospedagemBusiness();
		DadosHospedagemVO dadosHospedagemVO = new DadosHospedagemVO();
		double valorDiaria = 100.00;
		
		dadosHospedagemVO.setCheckin(Constantes.converteStringeParaDate("10/09/208"));
		dadosHospedagemVO.setCheckout(Constantes.converteStringeParaDate("15/09/2018"));
		dadosHospedagemVO.setQuantidadeAdulto(2);
		dadosHospedagemVO.setQuantidadeCrianca(0);
		double valorHospegagem = hospedagemBusiness.calculoHospedagem(dadosHospedagemVO, valorDiaria);
		Assert.assertEquals(171.43, valorHospegagem, 0.001);
	}

}
