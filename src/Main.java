import java.util.List;
import java.util.Scanner;

import espacoDeEstados.*;
import estrategiasDeBusca.heuristica.*;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		//char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		//char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
		char[] cfgIni = {'2','3',' ','7','4','1',};
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

		Scanner scanner = new Scanner(System.in);

		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado( Puzzle8.TABULEIRO_ORGANIZADO );
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
						

		System.out.println("Selecione o metodo de busca desejado:");

		System.out.println("1 - Busca AStar");
		System.out.println("2 - Busca Hill-Climbing");
		System.out.println("3 - Busca Best-First Search");

		Integer selecionaBusca = scanner.nextInt();
		scanner.nextLine();

		switch(selecionaBusca) {

			case 1:
				BuscaInformada Astar = new AStar();
				Astar.setInicio(puzzleInicial);
				Astar.setObjetivo(puzzleFinal);
				Astar.buscar();
				for(Estado e : Astar.getCaminhoSolucao()) {
					System.out.println(e);
				}
			break;


			case 2: 
				BuscaInformada hC = new HillClimbing();
				hC.setInicio(puzzleInicial);
				hC.setObjetivo(puzzleFinal);

				hC.buscar();

				mostrarCaminho(hC.getCaminhoSolucao());
			break;


			case 3:
				BestFirst bF = new BestFirst();
				bF.setInicio(puzzleInicial);
				bF.setObjetivo(puzzleFinal);

				bF.buscar();

				mostrarCaminho(bF.getCaminhoSolucao());
				System.out.println("Fim da primeira execucao.");

			break;
		}


		System.exit(0);
	}

	
	public static void mostrarCaminho(List<Estado<?>> caminhoDaSolucao) {
		for(Estado e : caminhoDaSolucao) {
				System.out.println(e);
				System.out.println(" ");
		}
}

}
