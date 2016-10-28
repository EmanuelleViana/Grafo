/**
 * @author Emanuelle
 *
 * 14 de ago de 2016
 */

import java.util.Scanner;
import java.util.*;
import java.io.*;



class GrafoM {
	private int[][] mGrafo;
	private int num_vertices;
	private boolean direcionado;

    private int[] tDescoberta ;
	private int[] tTermino ;
	private int[] pais ;
    private String sort ="";

    /**
	 * Construtor Padrao.
	 */
	public GrafoM() {
		num_vertices = 0;
		direcionado = false;
	}

	/**
	 * Construtor Alternativo.
	 * Cria um Grafo nulo(sem arestas).
	 */
	public GrafoM(int v) {
		num_vertices = v;
        tDescoberta = new int[num_vertices];
        tTermino = new int[num_vertices];
        pais = new int[num_vertices];

		mGrafo = new int[v][v];

		for (int i = 0; i < num_vertices; i++) {
			for (int j = 0; j < num_vertices; j++) {
				mGrafo[i][j] = 0;
			}//fim for

		}//fim for
	}//fim construtor alternativo

	//Construtor para setar se o novo grafo e orientado ou nao
	public GrafoM(int v, boolean dire){
		this(v);
        direcionado = dire;
	}
	
	/* A ordem e' o numero de vertices */
	int getOrdem(){
		return num_vertices;
	}
	
	/* O tamanho e' o numero de arestas */
	int getTamanho(){
		int count = 0;

        if(!direcionado) {
            for (int i = 0; i < num_vertices; i++) {
                for (int j = i; j < num_vertices; j++) {
                    if (mGrafo[i][j] != 0 && mGrafo[i][j] != -1) {
                        count++;
                    }
                }//fim for
            }
        }
        else {

            for (int i = 0; i < num_vertices; i++) {
                for (int j = 0; j < num_vertices; j++) {
                    count++;
                }//fim for
            }
        }
		return count;
	}//fim getArestas()

	public int[][]getGrafo(){
		return mGrafo;
	}
	

	boolean inserirAresta(int v1, int v2) {
		boolean insert = true;
		if (v1 >= num_vertices || v2 >= num_vertices) {
			insert = false;
			//System.out.println("Nao e possivel inserir a aresta : (" + v1 + "," + v2 + "). Nao existem um ou ambos os vertices no grafo!"  );
		} else {
			if(!direcionado){
			mGrafo[v1][v2] = 1;
			mGrafo[v2][v1] = 1;
			}
			else {
				mGrafo[v1][v2] = 1;
			}
			//System.out.println("Aresta inserida!  em (" + v1+","+v2);
			
		}
		return insert;
	}//fim inserirAresta()

	boolean retirarAresta(int v1, int v2) {
		boolean remove = true;
		if (v1 >= num_vertices || v2 >= num_vertices || mGrafo[v1][v2] == 0) {
			remove = false;
			System.out.println("A aresta (" + v1 +","+ v2 + ") nao existem nesse grafo!");
		}  else {
				if(!direcionado) {
					mGrafo[v1][v2] = 0;
					mGrafo[v2][v1] = 0;
					System.out.println("Aresta retirada! em (" + v1 + "," + v2);
				}
				else {
					mGrafo[v1][v2] = 0;
				}
		}//fim if
		return remove;
	}//fim retirarAresta()

	boolean verificarAresta(int v1, int v2) {
			return mGrafo[v1][v2] > 0;
	}//fim verificarAresta()

	/*
	 * Ler varios grafos de um arquivo e armazena los em lista
	 */
	ArrayList<GrafoM> fromArchive(String nome){
	
		String[] sv ;
		String linha;
		ArrayList<GrafoM> listaGrafos = new ArrayList<>();	

		try {
		FileReader arquivo = new FileReader(nome);
		BufferedReader ler = new BufferedReader(arquivo);
		int i,j;
		
		linha = ler.readLine();
		System.out.println(linha);
		while (linha != null) {

			//primeira linha diz se grafo ou digrafo
			if (linha.equals("1")) {
				direcionado = true;
			}
			//segunda linha fornece o numero de vertices
			linha = ler.readLine();
			System.out.println(linha);

			num_vertices = Integer.parseInt(linha);

			GrafoM g1;
			if (direcionado){
				//cria um novo grafo
				 g1 = new GrafoM(num_vertices,true);
			}
			else{
				 g1 = new GrafoM(num_vertices,false);
			}
			listaGrafos.add(g1.clone(g1));
			for (i = 0; i < this.num_vertices; i++) {
				linha = ler.readLine();
				System.out.println(linha);
				//System.out.println(linha + " Ler uma linha ");
				j = 0;
				sv = linha.split(",");
				//System.out.println(Arrays.toString(sv));
				while (j < num_vertices) {
					//System.out.println("i: " + i + " " + sv[j]);
					int bit = Integer.parseInt(sv[j]);
					if(bit > 0){
						g1.inserirAresta(i,j);
						System.out.println("("+i+","+j+")");

						//	System.out.println("Adicionarei a aresta("+i+","+j+")");
					}
					j++;
				}
			}
		linha = ler.readLine();

		}
		  } catch (java.io.FileNotFoundException e) {
			    System.out.println("ERRO.Nao foi possivel abrir o arquivo para leitura");
			    pause();

			    System.out.println("(Pressione 0 para voltar e abrir outro arquivo)");
			    pause();
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaGrafos;
	}
	void pause(){
	    System.out.println("Pressione ENTER para continuar.");
		Scanner ler = new Scanner(System.in);
		String pause = ler.nextLine();
	}

	protected GrafoM clone(GrafoM g1){
		return g1;
	}

		
	public void imprime() {
		System.out.print("  ");
		for (int i = 0; i < this.num_vertices; i++)
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < this.num_vertices; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < this.num_vertices; j++)
				System.out.print(this.mGrafo[i][j] + " ");
			System.out.println();
		}
	}

	/* Obter o grau do vertice.
	 * Caso seja direcionado o grau sera a soma dos antecessores e sucessores do vertice.
	 * @param v rotulo do vertice.
	 * @return resp grau do vertice.
	 */
	int getGrau(int v) {
		int resp = 0;
		if (!direcionado) {
			resp = getAdjacentes(v).size();
		}
		else{
		    resp = getAntecessores(v).size() + getSucessores(v).size();
        }

		return resp;
	}//fim getGrau
	

	
	// obter lista de adjacente de um vertice
	 ArrayList<Integer> getAdjacentes(int v) {
		ArrayList<Integer> adj = new ArrayList<>();
		System.out.print("Vertices adjacentes a " + v + " : ");

		for (int j = 0; j < num_vertices; j++) {
			if (mGrafo[v][j] > 0 ) {
				adj.add(j);
				System.out.print(j + " ");
			}
		}
		System.out.println("");

		return adj;
	}//fim adjacentes()

	ArrayList<Integer> getSucessores(int v){
		System.out.print("Vertices sucessores de " + v + " : ");
		return getAdjacentes(v);
	}

	ArrayList<Integer> getAntecessores(int v){
	ArrayList<Integer> ant = new ArrayList<>();
		System.out.print("Vertices antecessores de " + v + " : ");
		for (int i = 0; i < num_vertices; i++) {
			if (mGrafo[i][v] > 0 ) {
				ant.add(i);
				System.out.print(i + " ");
			}
		}
		return ant;
	}

	/* Verificar se um grafo e completo.
	 * Sera completo caso todos os vertices tenham grau igual nvertices-1.
	 */

	boolean isFull(){
			boolean resp = true;
			for(int i = 0; i< num_vertices;i++){
				if(getGrau(i)!= (num_vertices-1)){
					resp = false;
					break;
				}
			}
			System.out.println(resp);

	 return resp;
	 }

	GrafoM getComplementar() {
		GrafoM g2 = new GrafoM(num_vertices);

		for (int i = 0; i < num_vertices; i++) {
			for (int j = 0; j < num_vertices; j++) {

				if (verificarAresta(i, j) != true && i != j) {
					g2.inserirAresta(i, j);
				}//fim if
			}//fim for
		}//fim for

		return g2;
	 }//fim getComplementar
	 


	 void exibeComplementar(){
		 getComplementar().imprime();
	 }

    boolean isComplementar(GrafoM graph){
        boolean resp = true;
        for (int i = 0; i < num_vertices; i++) {
            for (int j = 0; j < num_vertices; j++) {

                if (mGrafo[i][j] == 0 && graph.getGrafo()[i][j] != 1 ||
                        mGrafo[i][j] == 1 && graph.getGrafo()[i][j] != 0) {
                    resp = false;
                    break;
                }//fim if
            }//fim for
        }//fim for
        return resp;
    }


    int[] buscaEmLargura(int o){
        //vetor de cores : branco - 0 , cinza - 1 , preto -2
        int branco = 0, cinza = 1, preto = 2;
        int cores[] = new int[num_vertices];
        //vetor de distancias
        int distancias[] = new int[num_vertices];

        int u = 0;
        int MAX_VALUE = -1;
        //inicializacoes
        for (u = 0; u < num_vertices; u++ ){
            cores[u] = branco;
            distancias[u] = MAX_VALUE;
            pais[u] = MAX_VALUE;
        }
        //origem
        cores[o] = 1;
        distancias[0] = 0;

        Queue fila = new LinkedList();

        fila.add(o);

        while(!(fila.isEmpty())){
            u = Integer.parseInt(fila.remove().toString());

            for(int i = 0; i< getAdjacentes(u).size(); i++ ) {
                int v = getAdjacentes(u).get(i);

                if(cores[v] == branco){
                    cores[v] = cinza;
                    distancias[v] = distancias[u] + 1;
                    pais[v] = u;
                    fila.add(v);
                }
                cores[u] = preto;
            }
        }
        return pais;
    }

    int visitaDFS(int u,int tempo, int[] cores){
       // ArrayList<Objects> prop = new ArrayList<>();
        int branco = 0, cinza = 1, preto = 2;
        int v;
        tempo++;
        tDescoberta[u] = tempo;
        cores[u] = cinza;

        for(int k = 0; k < getAdjacentes(u).size();k++){
            v = getAdjacentes(u).get(k);
           System.out.print(". "+u+" -"+cores[v]+"/");
            if(cores[v] == branco){
                pais[v] = u;
                tempo = visitaDFS(v,tempo,cores);
            }
            else  if(cores[v] == cinza){
                System.out.println("*Aresta de retorno: (" + u +","+v+")" );
            }

        }
      //  System.out.println("u: " + u+ "/  " );
        cores[u] = preto;
        sort = u+sort;
        tempo++;
        tTermino[u] = tempo;
        System.out.println("-------");
        System.out.println("sort: "+sort);
   return tempo;
    }

    int[] buscaEmProfundidade(){
        int branco = 0, cinza = 1, preto = 2;
        int[]cores = new int[num_vertices];
        //inicializacoes
        int tempo = 0;
        System.out.println(tDescoberta.length);
        for (int i = 0; i < num_vertices; i++){
            cores[i] = branco;
            tDescoberta[i] = -1;
            tTermino[i] = -1;
            pais[i] = -1;
        }
        //para cada vertice visita em profundidade os vizinhos nao visitados
       for(int u = 0; u < num_vertices;u++){
           System.out.println("u "+ u + "esta cor " + cores[u]);
            if(cores[u] == branco) {
                tempo = visitaDFS(u,tempo,cores);
            }
            else if(cores[u] == cinza)  {
                System.out.println("Aresta de retorno:" + u );
            }
        }

        return pais;
    }

   /* int qtdComponentesConex(){

        buscaEmProfundidade();
    }
*/
    boolean isDirecionado(){
        return direcionado;
    }


}



	
