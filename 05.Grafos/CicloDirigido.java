import java.util.HashMap;
import java.util.Map;

public class CicloDirigido {

    private enum Cor {
        WHITE, BLACK, GRAY
    }
    private Map<String, Cor> cores;
    private Map<String, String> edgeTo; // antecessor de cada vértice no caminho
    private Boolean cicloEncontrado;

    public CicloDirigido(Digraph g) {
        cicloEncontrado = false;

        cores = new HashMap<>();
        for(String s: g.getVerts())
            cores.put(s, Cor.WHITE);
        edgeTo = new HashMap<>();
        for(String s: g.getVerts()) {
            if(cores.get(s) == Cor.WHITE) {
                cicloEncontrado = dfs(g, s);
                if(cicloEncontrado)
                    return; // sai do construtor ao encontrar o 1o. ciclo
            }
        }
    }

    public boolean hasCycle() {
        return cicloEncontrado;
    }

    private boolean dfs(Graph g, String v) {
        // System.out.println("Entrando no vértice " + v);
        cores.put(v, Cor.GRAY);
        // Para cada vizinho não visitado...
        for (String w : g.getAdj(v)) {
            if (cores.get(w) == Cor.WHITE) {
                // System.out.println("  >> Vou visitar " + w);
                edgeTo.put(w, v); // indica que viemos de v para w
                dfs(g, w);
            }
            else {
                // ...
            }
        }
        cores.put(v, Cor.BLACK);
        // System.out.println("Saindo do vértice " + v);
        return false;
    }
}
