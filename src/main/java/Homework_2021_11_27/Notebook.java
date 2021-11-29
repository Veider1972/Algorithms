package Homework_2021_11_27;

public class Notebook implements Comparable<Notebook> {
   private int cost;
   private int memory;
   private Producer producer;
   
   public int getCost() {
      return cost;
   }
   
   public int getMemory() {
      return memory;
   }
   
   public Producer getProducer() {
      return producer;
   }
   
   public Notebook(int cost, int memory, Producer producer) {
      this.cost = cost;
      this.memory = memory;
      this.producer = producer;
   }
   
   @Override
   public String toString() {
      return String.format("%d-%d-%s", cost, memory, producer.toString());
   }
   
   @Override
   public int compareTo(Notebook n) {
      if (this.getCost() < n.getCost())
         return -1;
      else if (this.getCost() > n.getCost())
         return 1;
      else if (this.getMemory() < n.getMemory())
         return -1;
      else if (this.getMemory() > n.getMemory())
         return 1;
      else if (this.getProducer().getWeight() < n.getProducer().getWeight())
         return -1;
      else if (this.getProducer().getWeight() > n.getProducer().getWeight())
         return 1;
      return 0;
   }
}