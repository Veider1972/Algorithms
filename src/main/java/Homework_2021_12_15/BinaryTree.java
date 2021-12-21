package Homework_2021_12_15;

import java.util.Objects;
import java.util.Stack;

public class BinaryTree<T extends Number> {
   private Node<T> root;
   private final int depth;
   
   public BinaryTree(int depth) {
      this.depth = depth;
   }
   
   public Node<T> getRoot() {
      return root;
   }
   
   public void insert(T value) {
      if (Objects.isNull(root)) {
         root = new Node<>(value);
         return;
      }
      Node<T> currentNode = root;
      int level = 0;
      while (Objects.nonNull(currentNode) && level < depth) {
         if (value.doubleValue() < currentNode.getValue().doubleValue()) {
            if (Objects.isNull(currentNode.getLeftChild())) {
               currentNode.setLeftChild(new Node<>(value));
               return;
            }
            else currentNode = currentNode.getLeftChild();
         }
         else if (value.doubleValue() > currentNode.getValue().doubleValue()) {
            if (Objects.isNull(currentNode.getRightChild())) {
               currentNode.setRightChild(new Node<>(value));
               return;
            }
            else currentNode = currentNode.getRightChild();
         }
         else {
            currentNode.setCount(currentNode.getCount() + 1);
            return;
         }
         level++;
      }
      
   }
   
   public boolean delete(T value) {
      Node<T> current = root;
      Node<T> parent = root;
      boolean isLeftChild = true;
      while (true) {
         if (Objects.isNull(current)) return false;
         if (value.doubleValue() == current.getValue().doubleValue()) break;
         parent = current;
         if (Objects.nonNull(current) && (current.getValue().doubleValue() == value.doubleValue()) && current.getCount() > 1) {
            current.setCount(current.getCount() - 1);
            return true;
         }
         if (value.doubleValue() < current.getValue().doubleValue()) {
            isLeftChild = true;
            current = current.getLeftChild();
         }
         else {
            isLeftChild = false;
            current = current.getRightChild();
         }
      }
      if (current.getCount() > 1) {
         current.setCount(current.getCount() - 1);
         return true;
      }
      else if (current.getLeftChild() == null && current.getRightChild() == null) {
         if (Objects.isNull(current)) {
            root = null;
         }
         else if (isLeftChild) {
            parent.setLeftChild(null);
         }
         else {
            parent.setRightChild(null);
         }
      }
      else if (current.getRightChild() == null) {
         if (Objects.isNull(current)) {
            root = current.getLeftChild();
         }
         else if (isLeftChild) {
            parent.setLeftChild(current.getLeftChild());
         }
         else {
            parent.setRightChild(current.getLeftChild());
         }
      }
      else if (current.getLeftChild() == null) {
         if (Objects.isNull(current)) {
            root = current.getRightChild();
         }
         else if (isLeftChild) {
            parent.setLeftChild(current.getRightChild());
         }
         else {
            parent.setRightChild(current.getRightChild());
         }
      }
      else {
         Node<T> successor = getSuccessor(current);
         if (current == root) {
            root = successor;
         }
         else if (isLeftChild) {
            parent.setLeftChild(successor);
         }
         else {
            parent.setRightChild(successor);
         }
         successor.setLeftChild(current.getLeftChild());
      }
      return true;
   }
   
   public Node<T> getSuccessor(Node<T> node) {
      Node<T> successorParent = node;
      Node<T> successor = node;
      Node<T> current = node.getRightChild();
      while (current != null) {
         successorParent = successor;
         successor = current;
         current = current.getLeftChild();
      }
      if (successor != node.getRightChild()) {
         successorParent.setLeftChild(successor.getRightChild());
         successor.setRightChild(node.getRightChild());
      }
      return successor;
   }
   
   public void displayTree() {
      System.out.println("======================================================================================================================================");
      Stack<Node<T>> stack = new Stack<>();
      stack.push(root);
      int nBlanks = (int) Math.round(7 * Math.pow(2, depth - 1));
      boolean isRowEmpty = false;
      while (!isRowEmpty) {
         Stack<Node<T>> localStack = new Stack<>();
         isRowEmpty = true;
         for (int i = 0; i < nBlanks; i++) {
            System.out.print(" ");
         }
         while (!stack.isEmpty()) {
            Node<T> temp = stack.pop();
            if (temp != null) {
               temp.display();
               localStack.push(temp.getLeftChild());
               localStack.push(temp.getRightChild());
               if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                  isRowEmpty = false;
               }
            }
            else {
               System.out.print("  ---  ");
               localStack.push(null);
               localStack.push(null);
            }
            for (int i = 0; i < nBlanks * 2 - 5; i++) {
               System.out.print(' ');
            }
         }
         System.out.println(" ");
         nBlanks = (int) Math.ceil(nBlanks / 2);
         while (!localStack.isEmpty()) {
            stack.push(localStack.pop());
         }
         
      }
      System.out.println("======================================================================================================================================");
   }
   
   public boolean isBalanced(Node<T> node) {
      return (node == null) || (isBalanced(node.getLeftChild()) && isBalanced(node.getRightChild()) && Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1);
   }
   
   private int height(Node<T> node) {
      return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
   }
}
