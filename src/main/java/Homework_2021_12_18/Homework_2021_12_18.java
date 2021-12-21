package Homework_2021_12_18;

public class Homework_2021_12_18 {
   public static void main(String[] args) {
      System.out.println("Схема графа:");
      System.out.println("     A---B--J--I");
      System.out.println("     |\\   \\   / \\");
      System.out.println("     | \\   \\ /   \\");
      System.out.println("     |  D   C--E-H");
      System.out.println("     |   \\      /");
      System.out.println("     F----G----/");
      Graph graph = new Graph('A','B','C','D','E','F','G','H','I','J');
      graph.setDirectLink('A','B','D','F');
      graph.setDirectLink('B','C','J');
      graph.setDirectLink('J','I');
      graph.setDirectLink('C','I','E');
      graph.setDirectLink('D','G');
      graph.setDirectLink('F','G');
      graph.setDirectLink('G','H');
      graph.setDirectLink('E','H');
      graph.setDirectLink('I','H');
      
      graph.displayLinks();
      
      graph.findPathToPoint('H');
   }
}
