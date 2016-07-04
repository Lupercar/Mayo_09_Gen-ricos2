package consola;

import java.util.List;

import entidades.Repositorio;
import entidades2.Operaciones;

public class App {

	public static void main(String[] args) {

		Repositorio<Integer, Double> repo = new Repositorio<>();

		repo.add(1);
		repo.add(2);
		repo.add(3);
		repo.add(4);
		repo.add(5);

		System.out.println(repo);

		repo.remove(e -> e % 2 != 0);
		repo.remove(e -> e == 5);

		System.out.println(repo);

		List<Double> res = repo.transforma(n -> n * 2.00);

		System.out.println(res);

		res = repo.transforma(n -> n / 2.00);

		System.out.println(res);
		
		List<Double> listaResultante = 
				Operaciones.transforma (
						n -> n * 2.00, 
						new Integer[] {10,11,12,13,14,15} 
						); 
		
		System.out.println(listaResultante);
		
		System.out.println(Operaciones.suma
				(new Integer[] {10,11,12,13,14,15}));
	}
}// fin class consola.App
