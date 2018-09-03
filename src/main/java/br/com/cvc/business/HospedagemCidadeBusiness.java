package br.com.cvc.business;

import java.io.IOException;

import br.com.cvc.broker.WebServeParceiro;
import br.com.cvc.constantes.Constantes;
import br.com.cvc.vo.DadosHospedagemVO;

public class HospedagemCidadeBusiness extends HospedagemBusiness {

	private String url;

	public HospedagemCidadeBusiness(long codigo) {
		StringBuilder str = new StringBuilder();
		str.append(Constantes.URL_CIDADE);
		str.append(codigo);
		this.url = str.toString();
	}

	public String calculaHospedagemPorCidade(final DadosHospedagemVO dadosHospedagemVO) throws IOException {
		WebServeParceiro webServeParceiro = new WebServeParceiro(this.url);
		return this.calcularHospedagem(dadosHospedagemVO, webServeParceiro);
	}
}
