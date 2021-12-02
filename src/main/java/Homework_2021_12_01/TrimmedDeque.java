package Homework_2021_12_01;

import java.util.Arrays;

public class TrimmedDeque<E> {
   private Object[] deque;
   
   public TrimmedDeque() {
      deque = new Object[0];
   }
   
   @Override
   public String toString() {
      String str = "[";
      if (!isEmpty()) {
         for (int i = 0; i < deque.length; i++) {
            str += (E) deque[i];
            if (i < deque.length - 1)
               str += ", ";
         }
      }
      str += "]";
      return str;
   }
   
   public boolean isEmpty() {
      return (deque.length == 0);
   }
   
   public void pushLeft(E obj) {
      growLeft();
      deque[0] = obj;
   }
   
   private void growLeft() {
      Object[] newDeque = new Object[deque.length + 1];
      System.arraycopy(deque, 0, newDeque, 1, deque.length);
      deque = newDeque;
   }
   
   public void pushRight(E obj) {
      growRight();
      deque[deque.length - 1] = obj;
   }
   
   private void growRight() {
      Object[] newDeque = new Object[deque.length + 1];
      System.arraycopy(deque, 0, newDeque, 0, deque.length);
      deque = newDeque;
   }
   
   public E popLeft() {
      if (isEmpty()) {
         return null;
      }
      E obj = (E) deque[0];
      trimLeft();
      return obj;
   }
   
   private void trimLeft() {
      if (isEmpty())
         return;
      Object[] newDeque = new Object[deque.length - 1];
      System.arraycopy(deque, 1, newDeque, 0, newDeque.length);
      deque = newDeque;
   }
   
   public E popRight() {
      if (isEmpty()) {
         return null;
      }
      E obj = (E) deque[deque.length - 1];
      trimRight();
      return obj;
   }
   
   private void trimRight() {
      if (isEmpty())
         return;
      deque = Arrays.copyOf(deque, deque.length - 1);
   }
   
   public E peekLeft() {
      if (isEmpty())
         return null;
      else
         return (E) deque[0];
   }
   
   public E peekRight() {
      if (isEmpty())
         return null;
      else
         return (E) deque[deque.length - 1];
   }
}
