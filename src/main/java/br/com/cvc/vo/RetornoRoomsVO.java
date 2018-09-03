package br.com.cvc.vo;

public class RetornoRoomsVO {

	private long roomID;
	private String categoryName;
	private double totalPrice;
	private PriceDetailVO priceDetail;

	/**
	 * @return the roomID
	 */
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
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the priceDetail
	 */
	public PriceDetailVO getPriceDetail() {
		return priceDetail;
	}

	/**
	 * @param priceDetail the priceDetail to set
	 */
	public void setPriceDetail(PriceDetailVO priceDetail) {
		this.priceDetail = priceDetail;
	}

}
