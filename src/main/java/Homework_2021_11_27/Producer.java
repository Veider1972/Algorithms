package Homework_2021_11_27;

public enum Producer {
   Lenuvo(0), Asos(1), MacNote(2), Eser(3), Xamiou(4);
   
   private int weight;
   
   public int getWeight() {
      return weight;
   }
   
   Producer(int weight) {
      this.weight = weight;
   }
}
