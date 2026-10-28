public class AppOrdTopologica {
    public static void main(String[] args) {
        // Digraph g = new Digraph("exemplos/diamante.txt");
        Digraph g = new Digraph("exemplos/tinyG.txt");
        OrdTopologica ord = new OrdTopologica(g);
        if (ord.hasCycle())
            System.out.println("IMPOSSÍVEL FAZER! O grafo tem ciclo!");
        else {
            for (String v : ord.getOrdemTopologica())
                System.out.print(v + " ");
        }
        System.out.println();
    }
}
