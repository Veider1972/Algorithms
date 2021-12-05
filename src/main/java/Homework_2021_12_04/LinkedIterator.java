package Homework_2021_12_04;

import java.util.Iterator;

public class LinkedIterator<E> implements Iterator<E> {
   
   private SDNode<E> current;
   
   public LinkedIterator(SDNode<E> first) {
      current = first;
   }
   
   @Override
   public boolean hasNext() {
      return (current != null);
   }
   
   @Override
   public E next() {
      E value = current.getValue();
      current = current.next;
      return value;
   }
}
