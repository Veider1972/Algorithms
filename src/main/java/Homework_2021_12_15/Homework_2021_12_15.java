package Homework_2021_12_15;

public class Homework_2021_12_15 {
   public static void main(String[] args) {
      BinaryTree<Integer> bTree;
      System.out.println("\nРавномерное заполненное дерево из 33-х элементов с двумя повторами:");
      bTree = fullArray(4);
      bTree.displayTree();
      System.out.println("\nПроверка удаления элементов:");
      bTree.delete(-12); // Удаление одинарного элемента, имеющего дочерние узлы
      bTree.delete(-17); // Удаление двойного элемента
      bTree.delete(1);   // Удаление конечного элемента
      bTree.displayTree();
      
      System.out.println("Проверка изменения сбалансированности с ростом глубины дерева:");
      for (int DEPTH = 1; DEPTH<7; DEPTH++) {
         int balancedCounter = 0;
         int notBalancedCounter = 0;
         for (int i = 1; i <= 1000; i++) {
            bTree = randomArray(DEPTH);
            boolean balanced = bTree.isBalanced(bTree.getRoot());
            if (balanced) balancedCounter++;
            else notBalancedCounter++;
         }
         System.out.println("Глубина дерева "+DEPTH+": сбалансированных деревьев - " + (float) 100 * balancedCounter / (balancedCounter + notBalancedCounter) + "%, несбалансированных - " + (float) 100 * notBalancedCounter / (balancedCounter + notBalancedCounter)+"%");
      }
   }
   
   public static BinaryTree<Integer> fullArray(int depth) {
      BinaryTree<Integer> arr = new BinaryTree<Integer>(depth);
      arr.insert(0);
      arr.insert(-12);
      arr.insert(12);
      arr.insert(-17);
      arr.insert(-17);    //повтор
      arr.insert(17);
      arr.insert(-6);
      arr.insert(6);
      arr.insert(6);      // повтор
      arr.insert(-21);
      arr.insert(21);
      arr.insert(-15);
      arr.insert(15);
      arr.insert(-9);
      arr.insert(9);
      arr.insert(-3);
      arr.insert(3);
      arr.insert(-25);
      arr.insert(25);
      arr.insert(-19);
      arr.insert(19);
      arr.insert(-16);
      arr.insert(16);
      arr.insert(-13);
      arr.insert(13);
      arr.insert(-10);
      arr.insert(10);
      arr.insert(-8);
      arr.insert(8);
      arr.insert(-4);
      arr.insert(4);
      arr.insert(-1);
      arr.insert(1);
      return arr;
   }
   
   public static BinaryTree<Integer> randomArray(int depth) {
      BinaryTree<Integer> arr = new BinaryTree<Integer>(depth);
      for (int i = 0; i < 1000; i++) {
         arr.insert((int) (Math.random() * 50 - 25));
      }
      return arr;
   }
}
