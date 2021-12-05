package Homework_2021_12_04;

public class LinkedStack<E> extends SDLinkedList<E> {
   public boolean push(E value) {
      return insertFirst(value);
   }
   
   public E pop() {
      if (isEmpty())
         return null;
      E value = getFirst().value;
      removeFirst();
      return value;
   }
   
   public E peek() {
      if (isEmpty())
         return null;
      return getFirst().value;
   }
}
