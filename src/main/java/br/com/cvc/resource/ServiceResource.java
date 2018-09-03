package br.com.cvc.resource;

import java.io.IOException;
import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.cvc.business.HospedagemCidadeBusiness;
import br.com.cvc.business.HospedagemHotelBusiness;
import br.com.cvc.constantes.Constantes;
import br.com.cvc.vo.DadosHospedagemVO;

@Path("/service")
public class ServiceResource {

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cidade")
	@GET
	public String hospedagemIdCidade(@QueryParam("cityCode") long cityCode,
			@QueryParam("quantidadeAdulto") long quantidadeAdulto,
			@QueryParam("quantidadeCrianca") long quantidadeCrianca, @QueryParam("checkin") String checkin,
			@QueryParam("checkout") String checkout) throws ParseException, IOException {

		DadosHospedagemVO dadosHospedagemVO = new DadosHospedagemVO();
		dadosHospedagemVO.setQuantidadeAdulto(quantidadeAdulto);
		dadosHospedagemVO.setQuantidadeCrianca(quantidadeCrianca);
		dadosHospedagemVO.setCheckin(Constantes.convertStringeParaDate(checkin));
		dadosHospedagemVO.setCheckout(Constantes.convertStringeParaDate(checkout));

		String hospedagensPorCidade = new HospedagemCidadeBusiness(cityCode)
				.calculaHospedagemPorCidade(dadosHospedagemVO);
		return hospedagensPorCidade;
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hotel")
	@GET
	public String hospedagemIdHotel(@QueryParam("hotelCode") long hotelCode,
			@QueryParam("quantidadeAdulto") long quantidadeAdulto,
			@QueryParam("quantidadeCrianca") long quantidadeCrianca, @QueryParam("checkin") String checkin,
			@QueryParam("checkout") String checkout) throws ParseException, IOException {

		DadosHospedagemVO dadosHospedagemVO = new DadosHospedagemVO();
		dadosHospedagemVO.setQuantidadeAdulto(quantidadeAdulto);
		dadosHospedagemVO.setQuantidadeCrianca(quantidadeCrianca);
		dadosHospedagemVO.setCheckin(Constantes.convertStringeParaDate(checkin));
		dadosHospedagemVO.setCheckout(Constantes.convertStringeParaDate(checkout));

		String hospedagensPorHotel = new HospedagemHotelBusiness(hotelCode)
				.calculaHospedagemPorHotel(dadosHospedagemVO);
		return hospedagensPorHotel;
	}
}
