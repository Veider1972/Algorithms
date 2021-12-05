package Homework_2021_12_04;

import java.util.Iterator;

public class SDLinkedIterator<E> implements Iterator<E> {
   
   private SDNode<E> first;
   private SDNode<E> current;
   private SDNode<E> previous;
   
   public SDLinkedIterator(SDNode<E> first) {
      this.first =this.current = first;
   }
   
   @Override
   public boolean hasNext() {
      return (current != null);
   }
   
   @Override
   public E next() {
      E value = null;
      if (current != null) value = current.getValue();
      previous = current;
      current = current.next;
      
      return value;
   }
   
   public E current() {
      return current.value;
   }
   
   public void reset() {
      current = first;
   }
   
   public void insertAfter(E value){
      SDNode<E> node = new SDNode<E>(value,current.next);
      previous = current;
      current.next = node;
      current = node;
   }
   
   public void insertBefore(E value){
      SDNode<E> node = new SDNode<E>(value,current);
      previous.next = node;
      previous = node;
   }
   
   public void deleteCurrent(){
      current = previous.next = current.next;
   }
}
