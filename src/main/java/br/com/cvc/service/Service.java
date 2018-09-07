package br.com.cvc.service;

import java.net.HttpURLConnection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cvc.business.HospedagemCidadeBusiness;
import br.com.cvc.business.HospedagemHotelBusiness;
import br.com.cvc.constantes.Constantes;
import br.com.cvc.exception.CvcAPIException;
import br.com.cvc.exception.CvcAppBusinessException;
import br.com.cvc.exception.CvcAppSystemException;
import br.com.cvc.vo.DadosHospedagemVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/service")
public class Service {

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cidade")
	@GET
	@ApiOperation(value = "Buscar Hotel Por Id da Cidade")
	@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Hotel não localizado")
	@ApiResponses({ @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Hotel Localizado") })
	public Response hospedagemIdCidade(@QueryParam("cityCode") final long cityCode,
			@QueryParam("quantidadeAdulto") final long quantidadeAdulto,
			@QueryParam("quantidadeCrianca") final long quantidadeCrianca, @QueryParam("checkin") String checkin,
			@QueryParam("checkout") String checkout) throws CvcAPIException {

		try {
			DadosHospedagemVO dadosHospedagemVO = new DadosHospedagemVO();
			dadosHospedagemVO.setQuantidadeAdulto(quantidadeAdulto);
			dadosHospedagemVO.setQuantidadeCrianca(quantidadeCrianca);
			dadosHospedagemVO.setCheckin(Constantes.convertStringeParaDate(checkin));
			dadosHospedagemVO.setCheckout(Constantes.convertStringeParaDate(checkout));

			final String hospedagensPorCidade = new HospedagemCidadeBusiness(cityCode)
					.calculaHospedagemPorCidade(dadosHospedagemVO);
			return Response.ok(hospedagensPorCidade).build();

		} catch (CvcAppSystemException e) {
			throw new CvcAPIException(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
		} catch (final CvcAppBusinessException e) {
			throw new CvcAPIException(e.getMessage(), e, Status.NOT_FOUND);
		}
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hotel")
	@GET
	@ApiOperation(value = "Buscar Hotel Por Id da Cidade")
	@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Hotel não localizado")
	@ApiResponses({ @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Hotel Localizado") })
	public Response hospedagemIdHotel(@QueryParam("hotelCode") final long hotelCode,
			@QueryParam("quantidadeAdulto") final long quantidadeAdulto,
			@QueryParam("quantidadeCrianca") final long quantidadeCrianca, @QueryParam("checkin") String checkin,
			@QueryParam("checkout") String checkout) throws CvcAPIException {

		try {
			DadosHospedagemVO dadosHospedagemVO = new DadosHospedagemVO();
			dadosHospedagemVO.setQuantidadeAdulto(quantidadeAdulto);
			dadosHospedagemVO.setQuantidadeCrianca(quantidadeCrianca);
			dadosHospedagemVO.setCheckin(Constantes.convertStringeParaDate(checkin));
			dadosHospedagemVO.setCheckout(Constantes.convertStringeParaDate(checkout));

			final String hospedagensPorHotel = new HospedagemHotelBusiness(hotelCode)
					.calculaHospedagemPorHotel(dadosHospedagemVO);
			return Response.ok(hospedagensPorHotel).build();

		} catch (CvcAppSystemException e) {
			throw new CvcAPIException(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
		} catch (final CvcAppBusinessException e) {
			throw new CvcAPIException(e.getMessage(), e, Status.NOT_FOUND);
		}
	}
}
