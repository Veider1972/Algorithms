package Homework_2021_12_18;

public class Vertex {
   
   public final char name;
   public boolean visited;
   public int order;
   
   public Vertex(char name, int order) {
      this.name = name;
      this.order = order;
      visited = false;
   }
}