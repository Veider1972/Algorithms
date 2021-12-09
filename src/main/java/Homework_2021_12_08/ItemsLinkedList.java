package Homework_2021_12_08;

import java.util.LinkedList;

public class ItemsLinkedList extends LinkedList<Item> {
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      double weight = 0;
      int cost = 0;
      for (int i = 0; i < this.size(); i++) {
         weight += this.get(i).weight;
         cost += this.get(i).cost;
         String str = String.format("- %s (%.1f гр., %d руб.)", this.get(i).name, this.get(i).weight, this.get(i).cost);
         if (i < this.size() - 1)
            str += ",";
         sb.append(str + "\n");
      }
      sb.append(String.format("Итого: %.1f гр., %d руб.\n", weight, cost));
      return sb.toString();
   }
}

