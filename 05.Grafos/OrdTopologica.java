import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OrdTopologica {

    private enum Cor {
        WHITE, BLACK, GRAY
    }
    private Map<String, Cor> cores;
    private Map<String, String> edgeTo; // antecessor de cada vértice no caminho
    private Boolean cicloEncontrado;
    private List<String> ordemTopologica;

    public OrdTopologica(Digraph g) {
        cicloEncontrado = false;

        ordemTopologica = new LinkedList<>();
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

    public List<String> getOrdemTopologica() {
        return ordemTopologica;
    }

    private boolean dfs(Graph g, String v) {
        // System.out.println("Entrando no vértice " + v);
        cores.put(v, Cor.GRAY);
        // Para cada vizinho não visitado...
        for (String w : g.getAdj(v)) {
            // Se for cinza, é ciclo!
            if (cores.get(w) == Cor.GRAY) {
                // System.out.println("Ciclo detectado ao verificar o vértice "+w);
                return true;
            }
            if (cores.get(w) == Cor.WHITE) {
                // System.out.println("  >> Vou visitar " + w);
                edgeTo.put(w, v); // indica que viemos de v para w
                if(dfs(g, w))
                    return true;
            }
        }
        cores.put(v, Cor.BLACK);
        // System.out.println("Saindo do vértice " + v);
        // O processamento do vértice v terminou:
        // inclui o vértice no início do resultado!
        ordemTopologica.addFirst(v);
        return false;
    }
}
