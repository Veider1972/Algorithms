// ДЗ от 01.12.2021
// 1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
//    Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное
//    число.
//    Примеры:
//       [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
//       [1, 2, 4, 5, 6] => 3
//       [] => 1
// 2. Создать класс для реализации Deque. ---> GrowingDeque
// 3. Оптимизировать очередь, чтобы после удалния не оставалось незадействованных пустых
//    ячеек. ---> TrimmedDeque

package Homework_2021_12_01;

import java.util.Arrays;

public class Homework_2021_12_01 {
   public static void main(String[] args) {
      
      // п.1 ДЗ
      System.out.println("Проверка п.1 ДЗ");
      int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
      Integer retValue = checkMissedValue(array);
      System.out.println(Arrays.toString(array) + " => " + ((retValue != null) ? retValue : "без пропусков"));
      array = new int[]{1, 2, 4, 5, 6};
      retValue = checkMissedValue(array);
      System.out.println(Arrays.toString(array) + " => " + ((retValue != null) ? retValue : "без пропусков"));
      array = new int[]{1, 2, 3, 4, 5, 6};
      retValue = checkMissedValue(array);
      System.out.println(Arrays.toString(array) + " => " + ((retValue != null) ? retValue : "без пропусков"));
      array = new int[]{};
      retValue = checkMissedValue(array);
      System.out.println(Arrays.toString(array) + " => " + ((retValue != null) ? retValue : "без пропусков"));
      
      // п.2 ДЗ
      System.out.println("\nПроверка п.2 ДЗ");
      GrowingDeque<Integer> gArr = new GrowingDeque<Integer>(5);
      System.out.println("Исходный массив:     " + gArr);
      for (int i = 1; i <= 7; i++) {
         gArr.pushRight(i);
         System.out.println("Добавим справа  " + i + " -> " + gArr); // Точки обозначают пустые элементы внутри массива
      }                                                              // в классе. Выводятся для наглядности работы deque
      for (int i = 1; i < 6; i++) {
         gArr.pushLeft(i);
         System.out.println("Добавим слева   " + i + " -> " + gArr);
      }
      for (int i = 0; i < 7; i++) {
         Integer val = gArr.popRight();
         System.out.println("Извлечём справа " + val + " -> " + gArr);
      }
      for (int i = 0; i < 6; i++) {
         Integer val = gArr.popLeft();
         System.out.println("Извлечём слева  " + val + " -> " + gArr);
      }
      
      // п.3 ДЗ
      System.out.println("\nПроверка п.3 ДЗ");
      TrimmedDeque<Integer> tArr = new TrimmedDeque<Integer>();
      System.out.println("Исходный массив:     " + tArr);
      for (int i = 1; i <= 7; i++) {
         tArr.pushRight(i);
         System.out.println("Добавим справа  " + i + " -> " + tArr);
      }
      for (int i = 1; i < 6; i++) {
         tArr.pushLeft(i);
         System.out.println("Добавим слева   " + i + " -> " + tArr);
      }
      for (int i = 0; i < 7; i++) {
         Integer val = tArr.popRight();
         System.out.println("Извлечём справа " + val + " -> " + tArr);
      }
      for (int i = 0; i < 6; i++) {
         Integer val = tArr.popLeft();
         System.out.println("Извлечём слева  " + val + " -> " + tArr);
      }
   }
   
   public static Integer checkMissedValue(int[] arr) {
      if (arr.length == 0)
         return 1;
      for (int i = 0; i < arr.length - 1; i++) {
         if (arr[i + 1] - arr[i] > 1)
            return arr[i] + 1;
      }
      return null;
   }
}
