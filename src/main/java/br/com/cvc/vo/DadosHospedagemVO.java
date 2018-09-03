package br.com.cvc.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(name = "DadosHospedagemVO")
public class DadosHospedagemVO {

	private Date checkin;
	private Date checkout;
	private long quantidadeAdulto;
	private long quantidadeCrianca;
	
	/**
	 * @return the checkin
	 */
	public Date getCheckin() {
		return checkin;
	}

	/**
	 * @param checkin the checkin to set
	 */
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	/**
	 * @return the checkout
	 */
	public Date getCheckout() {
		return checkout;
	}

	/**
	 * @param checkout the checkout to set
	 */
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	/**
	 * @return the quantidadeAdulto
	 */
	public long getQuantidadeAdulto() {
		return quantidadeAdulto;
	}

	/**
	 * @param quantidadeAdulto the quantidadeAdulto to set
	 */
	public void setQuantidadeAdulto(long quantidadeAdulto) {
		this.quantidadeAdulto = quantidadeAdulto;
	}

	/**
	 * @return the quantidadeCrianca
	 */
	public long getQuantidadeCrianca() {
		return quantidadeCrianca;
	}

	/**
	 * @param quantidadeCrianca the quantidadeCrianca to set
	 */
	public void setQuantidadeCrianca(long quantidadeCrianca) {
		this.quantidadeCrianca = quantidadeCrianca;
	}

}
