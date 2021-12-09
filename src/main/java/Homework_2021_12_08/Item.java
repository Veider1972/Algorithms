package Homework_2021_12_08;

public class Item {
   
   String name;
   double weight;
   int cost;
   
   public Item(String name, double weight, int cost) {
      this.name = name;
      this.weight = weight;
      this.cost = cost;
   }
   
   @Override
   public String toString() {
      return String.format("%s (%.1f гр., %d руб.)\n", name, weight, cost);
   }
}
