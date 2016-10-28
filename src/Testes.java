import graph.Grafo;

/**
 * Created by Emanuelle on 07/09/2016.
 */
public class Testes {
    public static void main(String[]args){
       // ----testes busca em profundidade

        GrafoM g1 = new GrafoM(6,true);

        g1.inserirAresta(0,1);
        g1.inserirAresta(0,3);
        g1.inserirAresta(1,4);
        g1.inserirAresta(2,4);
        g1.inserirAresta(2,5);
        g1.inserirAresta(3,1);
        g1.inserirAresta(4,3);
        g1.inserirAresta(5,5);


        g1.imprime();

       int[] pais = g1.buscaEmProfundidade();
       for(int i =0;i <pais.length;i++){
           System.out.print(pais[i]+" ");
        }

    }
}
