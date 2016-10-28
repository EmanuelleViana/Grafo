/**
 * @author Emanuelle
 *
 * 19 de ago de 2016
 */

/**
 * @author Emanuelle
 *
 */
import java.util.*;


public class Principal {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		int opcao, newOpcao;
		GrafoM g1 = new GrafoM();
		int v1, v2;
		Scanner ler = new Scanner(System.in);
		do {
			System.out.println("\tGrafos (Escolha uma opcao)");
			System.out.println("0. Sair");
			System.out.println("1. Criar um grafo nulo");
			System.out.println("2. Ler Grafos de Arquivo");
			System.out.println("Opcao:");

			opcao = ler.nextInt();

			switch (opcao) {
			//------------------opcao para criar grafo(1)

				case 1:
				System.out.println("Quantos vertices tera o grafo?");
				int v = ler.nextInt();
				g1 = new GrafoM(v,true);
				System.out.println("Grafo criado com " + v + " vertices.\n");

				do {
					System.out.println("1.  Exibir Grafo");
					System.out.println("2.  Inserir Aresta");
					System.out.println("3.  Retirar Aresta");
					System.out.println("4.  Verificar Aresta");
					System.out.println("5.  Obter Tamanho");
					System.out.println("6.  Obter Grau");
					System.out.println("7.  Obter Ordem");
					System.out.println("8.  Obter Adjacentes de um vertice");
					System.out.println("9.  Verificar se e' completo");
					System.out.println("10. Obter Complementar");
					System.out.println("11. Busca Em Profundidade");
					System.out.println("0.  Voltar");
					System.out.println("Opcao:");

					newOpcao = ler.nextInt();
					switch (newOpcao) {
					case 1:
						g1.imprime();
						g1.pause();

						break;
					case 2:
						System.out.println("Qual aresta quer inserir? \"(v1,v2)\"");

						v1 = ler.nextInt();
						v2 = ler.nextInt();
						g1.inserirAresta(v1, v2);
						g1.pause();

						break;
					case 3:
						System.out.println("Qual aresta quer retirar? \"(v1,v2)\"");

						v1 = ler.nextInt();
						v2 = ler.nextInt();
						g1.retirarAresta(v1, v2);
						g1.pause();

						break;
					case 4:
						System.out.println("Qual aresta quer verificar? \"(v1,v2)\"");
						v1 = ler.nextInt();
						v2 = ler.nextInt();
						if (g1.verificarAresta(v1, v2)) {
							System.out.println("Aresta (" + v1 + "," + v2 + ") existente.");
						} else {
							System.out.println("Aresta (" + v1 + "," + v2 + ") nao existente.");
						}
						g1.pause();

						break;
					case 5:
						System.out.println("Tamanho: " + g1.getTamanho());
						g1.pause();

						break;
					case 6:
						System.out.println("Obter grau do vertice? ");
						v1 = ler.nextInt();
						System.out.println("Tamanho: " + g1.getGrau(v1));
						g1.pause();

						break;
					case 7:
						System.out.println("Ordem: " + g1.getOrdem());
						g1.pause();

						break;
					case 8:
						System.out.println("Obter adjacentes do vertice? ");
						v1 = ler.nextInt();
						g1.getAdjacentes(v1);
						g1.pause();

						break;
					case 9:
						if (g1.isFull()) {
							System.out.println("O grafo e completo!");

						} else {
							System.out.println("O grafo nao e completo!");

						}
						g1.pause();

						break;
					case 10:
						g1.getComplementar();
						g1.exibeComplementar();
						g1.pause();

						break;
						case 11:
							g1.buscaEmProfundidade();
							break;
					default:
						break;
					}

				} while (newOpcao != 0);
				break;
	//------------------opcao para ler de arquivo (2)
			case 2:
				//System.out.println("Qual arquivo sera lido?");
			//	String nome = ler.nextLine();
				//Scanner arquivo = new Scanner(System.in);
			//	String nome = arquivo.nextLine();

				ArrayList<GrafoM> listGraphs = new ArrayList<>();
				//g1.fromArchive("grafos.txt");
				listGraphs = g1.fromArchive("grafos.txt");
				System.out.println("\t" + listGraphs.size() + " lidos do arquivo.");

				do {
					System.out.println("1. Exibir Grafos Lidos");
					System.out.println("2. Selecionar Grafo");
					System.out.println("3. Exibir Selecionado");
					System.out.println("4. Inserir Aresta");
					System.out.println("5. Retirar Aresta");
					System.out.println("6. Verificar Aresta");
					System.out.println("7. Obter Tamanho");
					System.out.println("8. Obter Grau");
					System.out.println("9. Obter Ordem");
					System.out.println("10. Obter Adjacentes de um vertice");
					System.out.println("11. Verificar se e' completo");
					System.out.println("12. Obter Complementar");
					System.out.println("13. Busca Em Profundidade");
					System.out.println("0. Voltar");
					System.out.println("Opcao:");

					newOpcao = ler.nextInt();
					switch (newOpcao) {
					case 1:
						for (int i = 0; i < listGraphs.size(); i++) {
							System.out.println("Grafo " + i);
							listGraphs.get(i).imprime();
						}
						g1.pause();
						break;
					case 2:
						System.out.println("Qual dos grafos lidos do arquivo quer selecionar? \"(v1,v2)\"");
						v1 = ler.nextInt();
						g1 = listGraphs.get(v1);
						g1.pause();

						break;
					case 3:
						g1.imprime();
						g1.pause();

						break;
					case 4:
						System.out.println("Qual aresta quer inserir? \"(v1,v2)\"");
						v1 = ler.nextInt();
						v2 = ler.nextInt();
						g1.inserirAresta(v1, v2);
						g1.pause();

						break;
					case 5:
						System.out.println("Qual aresta quer retirar? \"(v1,v2)\"");
						v1 = ler.nextInt();
						v2 = ler.nextInt();
						g1.retirarAresta(v1, v2);
						g1.pause();

						break;
					case 6:
						System.out.println("Qual aresta quer verificar? \"(v1,v2)\"");
						v1 = ler.nextInt();
						v2 = ler.nextInt();
						if (g1.verificarAresta(v1, v2)) {
							System.out.println("Aresta (" + v1 + "," + v2 + ") existente.");

						} else {
							System.out.println("Aresta (" + v1 + "," + v2 + ") nao existente.");
						}
						g1.pause();

						break;
					case 7:
						System.out.println("Tamanho: " + g1.getTamanho());
						g1.pause();

						break;
					case 8:
						System.out.println("Obter grau do vertice? ");
						v1 = ler.nextInt();
						System.out.println("Tamanho: " + g1.getGrau(v1));
						g1.pause();

						break;
					case 9:
						System.out.println("Ordem: " + g1.getOrdem());
						g1.pause();

						break;
					case 10:
						System.out.println("Obter adjacentes do vertice? ");
						v1 = ler.nextInt();
						g1.getAdjacentes(v1);
						g1.pause();

						break;
					case 11:
						if (g1.isFull()) {
							System.out.println("O grafo e completo!");

						} else {
							System.out.println("O grafo nao e completo!");

						}
						g1.pause();

						break;
					case 12:
						g1.getComplementar();
						g1.exibeComplementar();
						g1.pause();

						break;
						case 13:
							g1.buscaEmProfundidade();
							break;
					default:
						break;
					}

				} while (newOpcao != 0);
				break;

			default:
				break;

			}

		} while (opcao != 0);

	}

}
