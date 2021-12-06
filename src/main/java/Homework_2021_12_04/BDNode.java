package Homework_2021_12_04;

public class BDNode<E> extends SDNode<E> {
   
   BDNode<E> prev;
   
   public BDNode(E value, BDNode<E> prev, BDNode<E> next) {
      super(value, next);
      this.prev = prev;
   }
   
   public E getValue() {
      return value;
   }
   
   public void setValue(E value) {
      this.value = value;
   }
   
   public void setPrev(BDNode<E> prev) {
      this.prev = prev;
   }
   
   public BDNode<E> getPrev() {
      return prev;
   }
}
