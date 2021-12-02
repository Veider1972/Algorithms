package Homework_2021_12_01;

public class GrowingDeque<E> {
   private Object[] deque;
   private int left;
   private int right;
   
   public GrowingDeque(int size) {
      deque = new Object[(int) (size * 1.5)];
      initialize();
   }
   
   private void initialize() {
      deque = new Object[5];
      left = deque.length / 2;
      right = left - 1;
   }
   
   @Override
   public String toString() {
      String str = "[";
      if (!isEmpty()) {
         for (int i = 0; i < left; i++) {
            str += " . ";
         }
         for (int i = left; i <= right; i++) {
            str += (E) deque[i];
            if (i < right)
               str += ", ";
         }
         for (int i = right + 1; i < deque.length; i++) {
            str += " . ";
         }
      }
      str += "]";
      return str;
   }
   
   private boolean isEmpty() {
      return right < left;
   }
   
   public void pushLeft(E obj) {
      if (left == 0)
         grow();
      deque[--left] = obj;
   }
   
   private void grow() {
      Object[] newDeque;
      if (getSize() > 0.8 * deque.length)
         newDeque = new Object[(int) (1.5 * getSize())];
      else
         newDeque = new Object[deque.length];
      int newLeft = newDeque.length / 2 - (getSize()) / 2;
      System.arraycopy(deque, left, newDeque, newLeft, right - left + 1);
      int newRight = newLeft + (right - left);
      deque = newDeque;
      left = newLeft;
      right = newRight;
   }
   
   public int getSize() {
      return right - left + 1;
   }
   
   public void pushRight(E obj) {
      if (right == deque.length - 1)
         grow();
      deque[++right] = obj;
   }
   
   public E popLeft() {
      if (isEmpty()) {
         initialize();
         return null;
      } else
         return (E) deque[left++];
   }
   
   public E popRight() {
      if (isEmpty()) {
         initialize();
         return null;
      } else
         return (E) deque[right--];
   }
   
   public E peekLeft() {
      if (isEmpty())
         return null;
      else
         return (E) deque[left];
   }
   
   public E peekRight() {
      if (isEmpty())
         return null;
      else
         return (E) deque[right - 1];
   }
}
