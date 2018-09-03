package br.com.cvc.vo;

import java.util.List;

public class RetornoDadosHospedagemVO {

	private long id;
	private String cityName;
	private List<RetornoRoomsVO> retornoRoomsVO;
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
	 * @return the retornoRoomsVO
	 */
	public List<RetornoRoomsVO> getRetornoRoomsVO() {
		return retornoRoomsVO;
	}
	/**
	 * @param retornoRoomsVO the retornoRoomsVO to set
	 */
	public void setRetornoRoomsVO(List<RetornoRoomsVO> retornoRoomsVO) {
		this.retornoRoomsVO = retornoRoomsVO;
	}



}
