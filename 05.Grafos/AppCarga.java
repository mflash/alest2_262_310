public class AppCarga {
   public static void main(String[] args) {
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
    }
    System.out.println(g.toDot());
   } 
}
