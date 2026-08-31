public class AppTesteHash {
    public static void main(String[] args) {

        LinearProbingHashST<String, Integer> h = new LinearProbingHashST<>();
        // SeparateChainingHashST<String, Integer> h = new SeparateChainingHashST<>();
        h.put("abc", 12);
        h.put("cba", 23);

        if (h.containsKey("abc"))
            System.out.println("abc -> " + h.get("abc"));
    }
}
