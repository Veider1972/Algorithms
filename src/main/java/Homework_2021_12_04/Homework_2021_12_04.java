package Homework_2021_12_04;

public class Homework_2021_12_04 {
   
   public static void main(String[] args) {
      System.out.println("\nПроверка работы однонаправленного LinkedList:");
      checkSingleDirectionLinkedList();
      System.out.println("\nПроверка работы двунаправленного LinkedList:");
      checkDoubleDirectionLinkedList();
      System.out.println("\nПроверка работы стека:");
      checkLinkedStack();
      System.out.println("\nПроверка работы двустороннего стека:");
      checkLinkedDequeue();
   }
   
   public static void checkSingleDirectionLinkedList() {
      SDLinkedList<Integer> sdLinkedList = new SDLinkedList<Integer>();
      for (int i = 1; i <= 4; i++) {
         System.out.printf("Вставим %d: ", i);
         sdLinkedList.insertFirst(i);
         System.out.println(sdLinkedList);
      }
      System.out.print("Проверка работы итератора: ");
      for (Integer num : sdLinkedList) {
         System.out.print(num + " ");
      }
      System.out.println("\nЗначение первого элемента списка: " + sdLinkedList.getFirst().value);
      for (int i = 1; i <= 5; i++) {
         System.out.print("Удалим первый элемент: ");
         sdLinkedList.removeFirst();
         System.out.println(sdLinkedList);
      }
   }
   
   public static void checkDoubleDirectionLinkedList() {
      BDLinkedList<Float> bdLinkedList = new BDLinkedList<Float>();
      for (int i = 1; i <= 4; i++) {
         System.out.printf("Вставим %d в начало: ", i);
         bdLinkedList.insertFirst((float) i);
         System.out.println(bdLinkedList);
      }
      for (int i = 5; i <= 9; i++) {
         System.out.printf("Вставим %d в конец:  ", i);
         bdLinkedList.insertLast((float) i);
         System.out.println(bdLinkedList);
      }
      System.out.print("Проверка работы итератора: ");
      for (Float num : bdLinkedList) {
         System.out.print(num + " ");
      }
      System.out.println("\nЗначение первого элемента списка: " + bdLinkedList.getFirst().value + ", последнего: " + bdLinkedList.getLast().value);
      for (int i = 1; i <= 5; i++) {
         System.out.print("Удалим первый элемент:    ");
         bdLinkedList.removeFirst();
         System.out.println(bdLinkedList);
         System.out.print("Удалим последний элемент: ");
         bdLinkedList.removeLast();
         System.out.println(bdLinkedList);
      }
   }
   
   public static void checkLinkedStack() {
      LinkedStack<Integer> linkedStack = new LinkedStack<Integer>();
      for (int i = 1; i <= 4; i++) {
         System.out.printf("Вставим %d в стек: ", i);
         linkedStack.push(i);
         System.out.println(linkedStack);
      }
      System.out.print("Проверка работы итератора: ");
      for (Integer num : linkedStack) {
         System.out.print(num + " ");
      }
      System.out.println();
      for (int i = 1; i <= 5; i++) {
         Integer value = linkedStack.pop();
         System.out.printf("Извлечём %d из стека: ", value);
         System.out.println(linkedStack);
      }
   }
   
   public static void checkLinkedDequeue() {
      LinkedDequeue<Float> linkedDequeue = new LinkedDequeue<Float>();
      for (int i = 1; i <= 4; i++) {
         System.out.printf("Вставим %d в начало: ", i);
         linkedDequeue.pushLeft((float) i);
         System.out.println(linkedDequeue);
      }
      for (int i = 5; i <= 9; i++) {
         System.out.printf("Вставим %d в конец:  ", i);
         linkedDequeue.pushRight((float) i);
         System.out.println(linkedDequeue);
      }
      System.out.print("Проверка работы итератора: ");
      for (Float num : linkedDequeue) {
         System.out.print(num + " ");
      }
      System.out.println();
      for (int i = 1; i <= 5; i++) {
         Float value = linkedDequeue.popLeft();
         System.out.print("Извлечём " + value + " слева:  ");
         System.out.println(linkedDequeue);
         value = linkedDequeue.popRight();
         System.out.print("Извлечём " + value + " справа: ");
         System.out.println(linkedDequeue);
      }
   }
}
