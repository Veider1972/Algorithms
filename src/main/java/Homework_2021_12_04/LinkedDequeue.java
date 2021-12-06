package Homework_2021_12_04;

public class LinkedDequeue<E> extends BDLinkedList<E> {
   
   public boolean pushLeft(E value) {
      return insertFirst(value);
   }
   
   public E popLeft() {
      if (isEmpty())
         return null;
      E value = getFirst().value;
      removeFirst();
      return value;
   }
   
   public E peekLeft() {
      if (isEmpty())
         return null;
      return getFirst().value;
   }
   
   public boolean pushRight(E value) {
      return insertLast(value);
   }
   
   public E popRight() {
      if (isEmpty())
         return null;
      E value = getLast().value;
      removeLast();
      return value;
   }
   
   public E peekRight() {
      if (isEmpty())
         return null;
      return getLast().value;
   }
}
