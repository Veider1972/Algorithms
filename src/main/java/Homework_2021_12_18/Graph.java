package Homework_2021_12_18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
   ArrayList<Vertex> vertexList = new ArrayList<>();
   int[][] links;
   
   private final Stack<Integer> stack = new Stack<>();
   private final LinkedList<Integer> queue = new LinkedList<>();
   private final LinkedList<Vertex> normalizedList = new LinkedList<>();
   
   public Graph(char... names) {
      for (int i = 0; i < names.length; i++) {
         vertexList.add(new Vertex(names[i], i));
      }
      links = new int[names.length][names.length];
      for (int i = 0; i < vertexList.size(); i++) {
         for (int j = 0; j < vertexList.size(); j++) {
            links[i][j] = 0;
         }
      }
   }
   
   public void setDirectLink(char fromVertex, char... toVertex) {
      for (char vertex : toVertex) {
         setLink(fromVertex, vertex);
      }
   }
   
   public void setLink(char fromVertex, char toVertex) {
      int row = getVertexIndex(fromVertex);
      int col = getVertexIndex(toVertex);
      if (row < 0) throw new IndexOutOfBoundsException("Исходная точка не найдена");
      if (col < 0) throw new IndexOutOfBoundsException("Конечная точка не найдена");
      links[row][col] = 1;
   }
   
   private int getVertexIndex(char name) {
      for (int i = 0; i < vertexList.size(); i++) {
         if (vertexList.get(i).name == name) return i;
      }
      return -1;
   }
   
   
   public void findPath() {
      normalizedList.get(0).visited = true;
      //displayVertex(0);
      stack.push(0);
      while (!stack.isEmpty()){
         int v = getLinksUnvisitedVertex(stack.peek());
         if (v==-1)
            stack.pop();
         else{
            vertexList.get(v).visited = true;
            stack.push(v);
            if (v == normalizedList.getLast().order) break;
         }
      }
      displayPath();
   }
   
   public void displayPath() {
      System.out.printf("Найденный маршрут из пункта %c в пункт %c: ",
            vertexList.get(stack.get(0)).name,
            vertexList.get(stack.peek()).name);
      for (int i = 0; i < stack.size(); i++) {
         System.out.print(vertexList.get(stack.get(i)).name);
         if (i< stack.size()-1)
            System.out.print(" -> ");
      }
      System.out.println();
   }
   
   public void findPathToPoint(char toPoint){
      vertexList.get(0).visited = true;
      System.out.print("Нормализованный порядок:");
      displayVertex(0);
      queue.add(0);
      normalizedList.add(vertexList.get(0));
      boolean stopAdding = false;
      int v2;
      while (!queue.isEmpty()){
         int v1 = queue.remove();
         while ((v2=getLinksUnvisitedVertex(v1)) != -1){
            if (!stopAdding){
               normalizedList.add(vertexList.get(v2));
            }
            if (vertexList.get(v2).name==toPoint) stopAdding=true;
            vertexList.get(v2).visited = true;
            displayVertex(v2);
            queue.add(v2);
         }
      }
      System.out.println();
      System.out.print("Усечённый массив точек: ");
      for (Vertex vertex : normalizedList) {
         vertex.visited = false;
         System.out.print(vertex.name + " ");
      }
      System.out.println();
      findPath();
   }
   
   public void displayVertex(int vertex) {
      System.out.print(vertexList.get(vertex).name + " ");
   }
   
   private int getLinksUnvisitedVertex(int ver) {
      for (int i = 0; i < vertexList.size(); i++) {
         if (links[ver][i] == 1 && !vertexList.get(i).visited) {
            return i;
         }
      }
      return -1;
   }
   
   public void displayLinks(){
      System.out.println("Матрица связей:");
      System.out.print("        ");
      for (Vertex vertex : vertexList) {
         System.out.print(vertex.name + " ");
      }
      System.out.println();
      for (int i = 0; i < vertexList.size(); i++) {
         System.out.print("     "+vertexList.get(i).name+"[ ");
         for (int j = 0; j < vertexList.size(); j++) {
            System.out.print(links[i][j]);
            if (j<vertexList.size()-1) System.out.print(" ");
         }
         System.out.println(" ]");
      }
   }
}
