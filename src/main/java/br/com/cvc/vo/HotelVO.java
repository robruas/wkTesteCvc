package br.com.cvc.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HotelVO")
public class HotelVO {

	private long id;
	private String name;
	private long cityCode;
	private String cityName;
	private List<RoomsVO> rooms;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the nome to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cityCode
	 */
	public long getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(long cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the rooms
	 */
	public List<RoomsVO> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<RoomsVO> rooms) {
		this.rooms = rooms;
	}

}
