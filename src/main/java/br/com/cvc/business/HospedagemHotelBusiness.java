package br.com.cvc.business;

import br.com.cvc.broker.WebServiceParceiro;
import br.com.cvc.constantes.Constantes;
import br.com.cvc.exception.CvcAppBusinessException;
import br.com.cvc.exception.CvcAppSystemException;
import br.com.cvc.vo.DadosHospedagemVO;

/**
 * Classe Calculo de Hospedagem Por Codigo de Hotel
 * @author Robson Ruas de Oliveira
 *
 */
public class HospedagemHotelBusiness extends HospedagemBusiness {

	private String url;

	public HospedagemHotelBusiness(long codigo) {
		StringBuilder str = new StringBuilder();
		str.append(Constantes.URL_HOTEL);
		str.append(codigo);
		this.url = str.toString();
	}

	
	/**
	 * Calculo de Hospedagem Por Hotel
	 * @param dadosHospedagemVO
	 * @return Json 
	 * @throws CvcAppBusinessException
	 * @throws CvcAppSystemException
	 */
	public String calculaHospedagemPorHotel(final DadosHospedagemVO dadosHospedagemVO)
			throws CvcAppSystemException, CvcAppBusinessException {
		WebServiceParceiro webServeParceiro = new WebServiceParceiro(this.url);
		return this.obterCalculoHospedagem(dadosHospedagemVO, webServeParceiro.obterBrokerParceiro());
	}
}
