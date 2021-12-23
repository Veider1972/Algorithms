package Homework_2021_12_22;

public class Entry {
   private final int number;
   private int count;
   
   public Entry(int number) {
      this.number = number;
      this.count = 1;
   }
   
   public int getNumber() {
      return number;
   }
   
   public int getCount() {
      return count;
   }
   
   public void setCount(int count) {
      this.count = count;
   }
   
   @Override
   public String toString() {
      return String.format("%d(%d)", number, count);
   }
}