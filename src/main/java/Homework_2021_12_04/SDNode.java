package Homework_2021_12_04;

public class SDNode<E>{
   
   E value;
   SDNode<E> next;
   
   public SDNode(E value, SDNode<E> next) {
      this.value = value;
      this.next = next;
   }
   
   public E getValue() {
      return value;
   }
   
   public void setValue(E value) {
      this.value = value;
   }
   
   public SDNode<E> getNext() {
      return next;
   }
   
   public void setNext(SDNode<E> next) {
      this.next = next;
   }
   
   public void display() {
      System.out.println("Value: " + this.value);
   }
}