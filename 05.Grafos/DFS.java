import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {
    private Graph g;
    private Set<String> marked; // indica se foi vértice já foi visitado
    private Map<String, String> edgeTo; // antecessor de cada vértice no caminho

    public DFS(Graph g, String start) {
        this.g = g;

        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        dfs(g, start);
    }

    // Retorna true se o DFS chegou no vértice
    public boolean hasPathTo(String v) {
        return marked.contains(v);
        // if(marked.contains(v))
        // return true;
        // return false;
    }

    public List<String> pathTo(String v) {
        List<String> path = new LinkedList<>();

        // Repete enquanto não chegar num antecessor nulo
        // (ou seja, antes do start)
        while (v != null) {
            path.add(0, v); // insere no início para inverter a ordem
            v = edgeTo.get(v); // pega o antecessor no caminho
        }
        return path;
    }

    private void dfs(Graph g, String v) {
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
    }
}
