package entidades;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T, PR> {
	
	/**
	 * Interfaz que proporciona el criterio 
	 * de eliminación en tiempo de ejecución.
	 *
	 */
	@FunctionalInterface
	public interface Criterio<E>{
		boolean cumple(E elemento); 
	}
	
	/**
	 * Interfaz que proporciona el criterio
	 * de transformar en tiempo de ejecucion
	 * @param <E> - Tipo de elemento que le pasamos
	 */
	@FunctionalInterface
	public interface Transformadora<E,R>{
		R transforma(E elemento); 
	}
	
	private List<T> elementos = new ArrayList<>();
	
	/**
	 * Añade elementos a la lista
	 * @param elemento - elemento de tipo genérico
	 */
	public void add(T elemento){
		elementos.add(elemento); 
	}
	
	/** 
	 * Elimina elementos de la lista por un criterio
	 * @param criterio - da el criterio para eliminar
	 */
	public void remove(Criterio<T> criterio){
		for(T e: elementos){
			if(criterio.cumple(e))
				elementos.remove(e); 
				break; //rompe el for 
//						sólo elimina el primero que encuentra
		}
	}
	
	/**
	 * Trasforma los elementos 
	 * @param transformacion - criterio de transformacion 
	 * @return Lista de elementos de tipo PR
	 */
	public List<PR> transforma(Transformadora<T,PR> transformacion){
		List<PR> resultado = new ArrayList<>(); 
		
		for(T e: elementos){
			resultado.add(transformacion.transforma(e)); 
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return "Repositorio [elementos=" + elementos + "]";
	}
}//fin class entidades.Repositorio
