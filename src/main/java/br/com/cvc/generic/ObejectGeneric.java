package br.com.cvc.generic;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;

import br.com.cvc.type.ListParameterizedType;

public class ObejectGeneric {

	/**
	 * Converte Json para uma lista de objeto
	 * 
	 * @param        <T>
	 * @param object
	 * @param json
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> List<T> converteJsonListaObjeto(final Class<T> objeto, final String json){
		Gson gson = new Gson();
		Type type = new ListParameterizedType(objeto);
		List<T> listaObjeto = gson.fromJson(json, type);
		return listaObjeto;

	}
}
