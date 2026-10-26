import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CicloNaoDirigido {
    private Set<String> marked; // indica se foi vértice já foi visitado
    private Map<String, String> edgeTo; // antecessor de cada vértice no caminho
    private Boolean cicloEncontrado;

    public CicloNaoDirigido(Graph g, String start) {
        cicloEncontrado = false;

        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        for(String s: g.getVerts()) {
            if(!marked.contains(s)) {
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
        marked.add(v);
        // Para cada vizinho não visitado...
        for (String w : g.getAdj(v)) {
            if (!marked.contains(w)) {
                // System.out.println("  >> Vou visitar " + w);
                edgeTo.put(w, v); // indica que viemos de v para w
                dfs(g, w);
            }
        }
        // System.out.println("Saindo do vértice " + v);
        return false;
    }
}
