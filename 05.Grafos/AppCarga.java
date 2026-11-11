import java.util.HashMap;
import java.util.Map;

public class AppCarga {
   public static void main(String[] args) {

    // Estrutura auxiliar para armazenar a carga máxima
    // de cada aresta: dicionário v-w -> carga máxima
    Map<String,Double> cargasMaximas = new HashMap<>();

    EdgeWeightedDigraph g = new EdgeWeightedDigraph();
    In arq = new In("exemplos/dados.txt");
    while(arq.hasNextLine()) {
        String linha = arq.readLine();
        String dados[] = linha.split(" ");
        String v = dados[0];
        String w = dados[1];
        double tempo = Double.parseDouble(dados[2]);
        double cargaMaxima = Double.parseDouble(dados[3]);
        g.addEdge(v, w, tempo);
        cargasMaximas.put(v+"-"+w, cargaMaxima);
    }
    // System.out.println(g.toDot());

    String start = "11";
    String end = "4";
    double pesoCam = 15;

    // Roda versão especializada do algoritmo com tempo (peso) + cargas + peso do caminhão
    DijkstraCarga dij = new DijkstraCarga(g, start, cargasMaximas, pesoCam);

    if(dij.hasPathTo(end)) {
        for(Edge e: dij.pathTo(end)) {
            System.out.print(e+" ");
        }
        System.out.println(" - "+dij.distTo(end));
    }
    else {
        System.out.println("Não tem caminho de "+start+" para "+end+"!");
    }
   }
}
