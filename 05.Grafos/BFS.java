import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {
    private Set<String> marked; // indica se foi vértice já foi visitado
    private Map<String, String> edgeTo; // antecessor de cada vértice no caminho
    private Map<String, Integer> distTo; // distância de cada vértice até o vértice inicial

    public BFS(Graph g, String start) {
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        bfs(g, start);
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

    private void bfs(Graph g, String v) {
        LinkedList<String> fila = new LinkedList<>();
        marked.add(v);
        fila.add(v); // insere vértice inicial na fila
        distTo.put(v, 0); // distância do vértice inicial a ele mesmo é 0!
        while (!fila.isEmpty()) {
            // Para cada vizinho não visitado...
            for (String w : g.getAdj(v)) {
                if (!marked.contains(w)) {
                    // System.out.println(" >> Vou visitar " + w);
                    edgeTo.put(w, v); // indica que viemos de v para w
                }
            }
        }
    }
}
