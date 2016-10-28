/**
 * @author Emanuelle
 *
 * 14 de ago de 2016
 */
package graph;

import java.util.Scanner;

class GrafoM {
	int[][] mGrafo;
	int num_vertices;

	/**
	 * Construtor Padrao.
	 */
	public GrafoM() {
		num_vertices = 0;
	}

	/**
	 * Construtor Alternativo.
	 * Cria um Grafo nulo(sem arestas).
	 */
	public GrafoM(int v) {
		num_vertices = v;
		mGrafo = new int[v][v];

		for (int i = 0; i < num_vertices; i++) {
			for (int j = 0; j < num_vertices; j++) {
				mGrafo[i][j] = 0;
			}//fim for

		}//fim for
	}//fim construtor alternativo

	/* A ordem e o numero de vertices */
	int getOrdem(){
		return num_vertices;
	}
	
	/* O tamanho e o numero de arestas */
	int getTamanho(){
		int count = 0;
	
		for (int i = 0; i < num_vertices; i++) {
			for (int j = 0; j < num_vertices; j++) {
				if(mGrafo[i][j]!=0){
				count++;
				}
			}//fim for
		}
		return count;
	}//fim getArestas()
	
		
	void exibirGrafo() {
		int i = 0;
		//exibir indices da matriz(vertices)
		System.out.print("  | ");
		while (i < num_vertices) {
			System.out.print(i + "   ");
			i++;
		}//fim while
		
		i = 0;
		String w;
		for (w = "--|"; i < num_vertices; w += "-----", i++);
		System.out.println("");
		System.out.println(w);

		//exibir arestas
		for (i = 0; i < num_vertices; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < num_vertices; j++) {

				System.out.print(mGrafo[i][j] + "   ");
			} // fim for
			System.out.println("");
		} // fim for
	}//fim exibirGrafo

	
	void inserirAresta(int v1, int v2) {
		if (v1 >= num_vertices || v2 >= num_vertices) {
			System.out.println("Nao existem esses vertices nesse grafo!");
		} else {
			mGrafo[v1][v2] = 1;

		}
	}

	void retirarAresta(int v1, int v2) {
		if (v1 >= num_vertices || v2 >= num_vertices) {
			System.out.println("Nao existem esses vertices nesse grafo!");
		} else {
			mGrafo[v1][v2] = 0;

		}
	}

	boolean verificarAresta(int v1, int v2) {
		boolean resp = false;

		if (mGrafo[v1][v2] != 0) {

			resp = true;
		}

		return resp;
	}

	// obter lista de adjacente de um vertice
	int[] adjacentes(int v) {
		int[] adj = new int[num_vertices];
		System.out.print("Vertices adjacentes a " + v + " : ");

		for (int j = 0; j < num_vertices; j++) {
			if (mGrafo[v][j] != 0) {
				adj[j] = j;
				System.out.print(j + " ");
			}
		}
		System.out.println("");

		return adj;
	}
}

public class Grafo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Quantidade de vertices do grafo:");
		Scanner ler = new Scanner(System.in);

		// TODO Auto-generated method stub
		 int v = ler.nextInt();

		GrafoM g1 = new GrafoM(v);
		
		g1.adjacentes(1);
		g1.retirarAresta(0, 1);

		g1.exibirGrafo();
	}
}
