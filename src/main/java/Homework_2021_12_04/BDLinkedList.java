package Homework_2021_12_04;

public class BDLinkedList<E> extends SDLinkedList<E> {
   
   private BDNode<E> last = null;
   
   public BDNode<E> getLast() {
      return last;
   }
   
   @Override
   public boolean insertFirst(E value) {
      try {
         BDNode<E> newNode = new BDNode<E>(value, null, (BDNode<E>) getFirst());
         boolean isNew = isEmpty();
         if (!isEmpty())
            ((BDNode<E>) getFirst()).prev = newNode;
         setFirst(newNode);
         if (isNew)
            last = (BDNode<E>) getFirst();
         return true;
      } catch (Exception e) {
         return false;
      }
   }
   
   @Override
   public boolean removeFirst() {
      if (isEmpty())
         return false;
      try {
         ((BDNode<E>) getFirst()).prev = null;
         setFirst(getFirst().next);
         if (isEmpty())
            last = null;
         else if (!isEmpty())
            ((BDNode<E>) getFirst()).prev = null;
         return true;
      } catch (Exception e) {
         return false;
      }
   }
   
   public boolean insertLast(E value) {
      try {
         BDNode<E> newNode = new BDNode<E>(value, last, null);
         last.next = newNode;
         last = newNode;
         return true;
      } catch (Exception e) {
         return false;
      }
   }
   
   public boolean removeLast() {
      if (isEmpty())
         return false;
      try {
         last = last.prev;
         if (last == null)
            setFirst(null);
         if (last != null)
            last.next = null;
         return true;
      } catch (Exception e) {
         return false;
      }
   }
}
