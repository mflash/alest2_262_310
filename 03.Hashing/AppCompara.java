public class AppCompara {
    public static void main(String[] args) {

        SeparateChainingHashST<String, Integer> dic;
        dic = new SeparateChainingHashST<>();

        In arq = new In("DomCasmurro_utf8.txt");
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] pals = linha.split(" ");
            for (String pal : pals)
                System.out.println(pal);
        }

        // usar dic.keySet() para obter uma lista de palavras
    }
}
