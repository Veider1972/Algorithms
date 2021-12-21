package Homework_2021_12_15;

public class Node<T extends Number> {
   private T value;
   private int count;
   private Node<T> leftChild;
   private Node<T> rightChild;
   
   public Node(T value, Node<T> leftChild, Node<T> rightChild) {
      this.value = value;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
      count = 1;
   }
   
   public Node(T value) {
      this.value = value;
      this.leftChild = null;
      this.rightChild = null;
      count = 1;
   }
   
   public int getCount() {
      return count;
   }
   
   public void setCount(int count) {
      this.count = count;
   }
   
   public T getValue() {
      return value;
   }
   
   public void setValue(T value) {
      this.value = value;
   }
   
   public Node<T> getLeftChild() {
      return leftChild;
   }
   
   public void setLeftChild(Node<T> leftChild) {
      this.leftChild = leftChild;
   }
   
   public Node<T> getRightChild() {
      return rightChild;
   }
   
   public void setRightChild(Node<T> rightChild) {
      this.rightChild = rightChild;
   }
   
   public void display() {
      if (value instanceof Byte) System.out.printf(String.format("%7s", value.byteValue() + "x" + count));
      else if (value instanceof Short) System.out.printf(String.format("%7s", value.shortValue() + "x" + count));
      else if (value instanceof Integer) System.out.printf(String.format("%7s", value.intValue() + "x" + count));
      else if (value instanceof Long) System.out.printf(String.format("%7s", value.longValue() + "x" + count));
      else if (value instanceof Float) System.out.printf(String.format("%7s", value.floatValue() + "x" + count));
      else System.out.printf(String.format("%7s", value.doubleValue() + "x" + count));
   }
}