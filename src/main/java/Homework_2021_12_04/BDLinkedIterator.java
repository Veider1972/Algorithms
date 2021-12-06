package Homework_2021_12_04;

public class BDLinkedIterator<E> extends SDLinkedIterator<E> {
   private BDNode<E> first;
   private BDNode<E> current;
   private BDNode<E> previous;
   
   public BDLinkedIterator(BDNode<E> first) {
      super(first);
      this.first = this.current = first;
   }
   
   @Override
   public void insertAfter(E value) {
      BDNode<E> node = new BDNode<E>(value, this.current, (BDNode<E>) this.current.next);
      ((BDNode<E>) this.current.next).prev = node;
      this.current.next = node;
      this.previous = current;
      current = node;
      
   }
   
   @Override
   public void insertBefore(E value) {
      BDNode<E> node = new BDNode<E>(value, this.previous, this.current);
      if (this.previous != null)
         this.previous.next = node;
      this.previous = node;
      this.current.prev = node;
   }
   
   @Override
   public E next() {
      E value = null;
      if (this.current != null)
         value = this.current.getValue();
      this.previous = this.current;
      this.current = (BDNode<E>) this.current.next;
      
      return value;
   }
   
   @Override
   public E current() {
      return this.current.value;
   }
   
   @Override
   public void reset() {
      this.current = this.first;
   }
   
   @Override
   public void deleteCurrent() {
      ((BDNode<E>) this.current.next).prev = this.previous;
      previous.next = this.current.next;
      this.current = (BDNode<E>) this.current.next;
   }
}
