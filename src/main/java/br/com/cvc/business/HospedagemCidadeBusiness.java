package br.com.cvc.business;

import br.com.cvc.broker.WebServiceParceiro;
import br.com.cvc.constantes.Constantes;
import br.com.cvc.exception.CvcAppBusinessException;
import br.com.cvc.exception.CvcAppSystemException;
import br.com.cvc.vo.DadosHospedagemVO;

/**
 * Classe Calculo de Hospedagem Por Codigo de Cidade
 * @author Robson Ruas de Oliveira
 *
 */
public class HospedagemCidadeBusiness extends HospedagemBusiness {

	private String url;

	public HospedagemCidadeBusiness(long codigo) {
		StringBuilder str = new StringBuilder();
		str.append(Constantes.URL_CIDADE);
		str.append(codigo);
		this.url = str.toString();
	}

	/**
	 * Calculo de Hospedagem Por Cidade
	 * @param dadosHospedagemVO
	 * @return Json 
	 * @throws CvcAppBusinessException
	 * @throws CvcAppSystemException
	 */
	public String calculaHospedagemPorCidade(final DadosHospedagemVO dadosHospedagemVO)
			throws CvcAppBusinessException, CvcAppSystemException {
		WebServiceParceiro webServeParceiro = new WebServiceParceiro(this.url);
		return this.obterCalculoHospedagem(dadosHospedagemVO, webServeParceiro.obterBrokerParceiro());

	}
}
