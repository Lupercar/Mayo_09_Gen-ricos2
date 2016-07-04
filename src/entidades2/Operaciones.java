package entidades2;

import java.util.ArrayList;
import java.util.List;

public class Operaciones {
	
	/**
	 * Interfaz que proporciona el criterio
	 * de transformar en tiempo de ejecucion
	 * @param <E> - Tipo de elemento que le pasamos
	 */
	@FunctionalInterface
	public interface Transformadora<E,R>{
		R transforma(E elemento); 
	}
	
	/**
	 * Método genérico que trasforma los elementos 
	 * @param transformacion - criterio de transformacion 
	 * @param elementos - array de tipo T
	 * @return Lista de elementos de tipo PR
	 */
	static public <T,PR> List<PR> transforma(
			Transformadora<T,
			PR> transformacion, T ... elementos ){
		
		List<PR> resultado = new ArrayList<>(); 
		
		for(T e: elementos){
			resultado.add(transformacion.transforma(e)); 
		}
		return resultado;
	}
	
	/**
	 * Suma genérica, restringimos que T 
	 * tiene que ser de tipo Number 
	 * extendiendo T
	 * @param elementos - un array 
	 * @return la suma en double
	 */
	static public <T extends Number>double suma(T ... elementos){
		double acumador = 0.0; 
		for(T e: elementos){
			acumador += e.doubleValue(); 
		}
		
		return acumador;
	}
}//fin class entidades2.Operaciones
