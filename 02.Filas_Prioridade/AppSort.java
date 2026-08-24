public class AppSort {
   public static void main(String[] args) {
    Integer[] vet = { 0, 5, 6, 8, 10, 20, 1, 4, 7, 100};
    MaxHeap<Integer> h;
    h = new MaxHeap<>(vet.length);
    h.sort(vet);
    h.print();
    for(int v: vet)
        System.out.println(v);
   } 
}
