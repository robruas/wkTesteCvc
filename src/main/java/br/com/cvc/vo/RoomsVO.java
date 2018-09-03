package br.com.cvc.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RoomsVO")
public class RoomsVO {

	private long roomID;
	private String categoryName;
	private PriceVO price;

	/**
	 * @return the roomID
	 */
	@XmlElement
	public long getRoomID() {
		return roomID;
	}

	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	/**
	 * @return the categoryName
	 */
	@XmlElement
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the price
	 */
	@XmlElement
	public PriceVO getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(PriceVO price) {
		this.price = price;
	}

}
