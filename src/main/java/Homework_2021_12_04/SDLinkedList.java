package Homework_2021_12_04;

import java.util.Iterator;

public class SDLinkedList<E> implements Iterable<E> {
   
   private SDNode<E> first = null;
   
   public SDNode<E> getFirst() {
      return first;
   }
   
   public boolean isEmpty() {
      return first==null;
   }
   
   public boolean setFirst(SDNode<E> first) {
      try {
         this.first = first;
         return true;
      } catch (Exception e) {
         return false;
      }
   }
   
   
   public boolean insertFirst(E value) {
      try {
         SDNode<E> newNode = new SDNode<E>(value, first);
         setFirst(newNode);
         return true;
      } catch (Exception e) {
         return false;
      }
   }
   
   public boolean removeFirst() {
      if (isEmpty())
         return false;
      try {
         first = first.next;
         return true;
      } catch (Exception e) {
         return false;
      }
   }
   
   public Iterator<E> iterator() {
      return new LinkedIterator<E>(first);
   }
   
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder("[");
      SDNode<E> node = first;
      while (node != null) {
         sb.append(node.value);
         if (node.next != null)
            sb.append(" -> ");
         node = node.next;
      }
      sb.append("]");
      return sb.toString();
   }
}
