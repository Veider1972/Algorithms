package Homework_2021_12_22;

import java.util.Random;

public class Homework_2021_12_22 {
   static final Random rnd = new Random();
   
   public static void main(String[] args) {
      HashTable hashTable = new HashTable(1);
      System.out.println("Создана таблица размера 1:      " + hashTable);
      hashTable.insert(1);
      hashTable.insert(2);
      hashTable.insert(1);
      System.out.println("Добавлены цифры 1, 2 и 1:       " + hashTable);
      hashTable.changeSize(3);
      System.out.println("Изменён размер таблицы до 3:    " + hashTable);
      hashTable.deleteNumber(1, 1);
      System.out.println("Удалена цифра 1:                " + hashTable);
      hashTable.deleteNumber(1, 1);
      System.out.println("Удалена ещё одна цифра 1:       " + hashTable);
      hashTable.changeSize(100);
      System.out.println("Изменён размер таблицы до 100:  " + hashTable);
      for (int i = 0; i < 10000; i++) {
         hashTable.insert(rnd.nextInt(1000));
      }
      System.out.println("Добавлены 10к чисел 0...1000:   " + hashTable);
      for (int i = 0; i < 10000; i++) {
         hashTable.deleteNumber(rnd.nextInt(1000), rnd.nextInt(3));
      }
      System.out.println("Удалено 10к чисел 0...1000:     " + hashTable);
      for (int i = 0; i < 10000; i++) {
         hashTable.deleteNumber(rnd.nextInt(1000), rnd.nextInt(3));
      }
      System.out.println("Удалено ещё 10к чисел 0...1000: " + hashTable);
      hashTable.changeSize(10);
      System.out.println("Изменён размер таблицы до 10:   " + hashTable);
   }
}