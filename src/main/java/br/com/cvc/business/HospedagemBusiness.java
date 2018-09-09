package br.com.cvc.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.cvc.constantes.Constantes;
import br.com.cvc.vo.DadosHospedagemVO;
import br.com.cvc.vo.HotelVO;
import br.com.cvc.vo.PriceDetailVO;
import br.com.cvc.vo.RetornoDadosHospedagemVO;
import br.com.cvc.vo.RetornoRoomsVO;
import br.com.cvc.vo.RoomsVO;

/**
 * Classe de Calculo de Hospedagem
 * 
 * @author Robson Ruas de Oliveira
 *
 */
public class HospedagemBusiness {

	/**
	 * Obeter Calculo de Hospedagem
	 * 
	 * @param dadosHospedagemVO
	 * @param listaHotelVO
	 * @return String
	 */
	public String obterCalculoHospedagem(final DadosHospedagemVO dadosHospedagemVO, List<HotelVO> listaHotelVO) {
		List<RetornoDadosHospedagemVO> listaRetornoDadosHospedagemVO = new ArrayList<RetornoDadosHospedagemVO>();
		for (HotelVO hotelVO : listaHotelVO) {
			for (RoomsVO roomsVO : hotelVO.getRooms()) {
				RetornoDadosHospedagemVO retornoDadosHospedagemVO = new RetornoDadosHospedagemVO();
				RetornoRoomsVO retornoRoomsVO = new RetornoRoomsVO();
				List<RetornoRoomsVO> listaRetornoRoomsVO = new ArrayList<RetornoRoomsVO>();
				PriceDetailVO priceDetail = new PriceDetailVO();

				retornoDadosHospedagemVO.setId(hotelVO.getId());
				retornoDadosHospedagemVO.setCityName(hotelVO.getCityName());

				this.calculaHospedagemAdulto(dadosHospedagemVO, roomsVO, priceDetail);
				this.calculaHospedagemCrianca(dadosHospedagemVO, roomsVO, priceDetail);

				retornoRoomsVO.setCategoryName(roomsVO.getCategoryName());
				retornoRoomsVO.setRoomID(roomsVO.getRoomID());
				retornoRoomsVO.setPriceDetail(priceDetail);
				retornoRoomsVO.setTotalPrice(Constantes
						.formataDouble(priceDetail.getPricePerDayAdult() + priceDetail.getPricePerDayChild()));

				listaRetornoRoomsVO.add(retornoRoomsVO);
				retornoDadosHospedagemVO.setRetornoRoomsVO(listaRetornoRoomsVO);
				listaRetornoDadosHospedagemVO.add(retornoDadosHospedagemVO);
			}
		}
		return Constantes.convergeObjetoParaJson(listaRetornoDadosHospedagemVO);
	}

	/**
	 * Calcular Hospedagem Adulto
	 * 
	 * @param dadosHospedagemVO
	 * @param roomsVO
	 * @param priceDetail
	 */
	private void calculaHospedagemAdulto(final DadosHospedagemVO dadosHospedagemVO, final RoomsVO roomsVO,
			PriceDetailVO priceDetail) {
		if (dadosHospedagemVO.getQuantidadeAdulto() > Constantes.ZERO) {
			priceDetail.setPricePerDayAdult(this.calculoHospedagem(dadosHospedagemVO, roomsVO.getPrice().getAdult()));
		} else {
			priceDetail.setPricePerDayAdult(Constantes.ZERO);
		}
	}

	/**
	 * Calcular Hospedagem Criança
	 * 
	 * @param dadosHospedagemVO
	 * @param roomsVO
	 * @param priceDetail
	 */
	private void calculaHospedagemCrianca(final DadosHospedagemVO dadosHospedagemVO, final RoomsVO roomsVO,
			PriceDetailVO priceDetail) {
		if (dadosHospedagemVO.getQuantidadeCrianca() > Constantes.ZERO) {
			priceDetail.setPricePerDayChild(this.calculoHospedagem(dadosHospedagemVO, roomsVO.getPrice().getChild()));

		} else {
			priceDetail.setPricePerDayChild(Constantes.ZERO);
		}
	}

	/**
	 * Obter Quantidade de Dias de Hospedagem
	 * 
	 * @param dadosHospedagemVO
	 * @return int
	 */
	private int obterQuantidadeDiasHospedagem(final DadosHospedagemVO dadosHospedagemVO) {
		Calendar dataCheckou = Calendar.getInstance();
		dataCheckou.setTime(dadosHospedagemVO.getCheckout());

		Calendar dataCheckin = Calendar.getInstance();
		dataCheckin.setTime(dadosHospedagemVO.getCheckin());

		int dias = dataCheckou.get(Calendar.DAY_OF_YEAR) - dataCheckin.get(Calendar.DAY_OF_YEAR);

		return dias;
	}

	/**
	 * Calculo de Hospedagem
	 * 
	 * @param dadosHospedagemVO
	 * @param valorHospegagem
	 * @return {@link Double}
	 */
	public double calculoHospedagem(final DadosHospedagemVO dadosHospedagemVO, final double valorHospegagem) {
		double totalHospedagem = ((Constantes.COMISSAO / 100)
				* (valorHospegagem * this.obterQuantidadeDiasHospedagem(dadosHospedagemVO)) / 0.7);
		return Constantes.formataDouble(totalHospedagem);
	}

}
