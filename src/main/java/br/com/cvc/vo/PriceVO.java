package br.com.cvc.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PriceVO")
public class PriceVO {

	private double adult;
	private double child;

	/**
	 * @return the adult
	 */
	@XmlElement
	public double getAdult() {
		return adult;
	}

	/**
	 * @param adult the adult to set
	 */
	public void setAdult(double adult) {
		this.adult = adult;
	}

	/**
	 * @return the child
	 */
	@XmlElement
	public double getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(double child) {
		this.child = child;
	}

}
