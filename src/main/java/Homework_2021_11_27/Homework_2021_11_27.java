package Homework_2021_11_27;

import java.util.*;

public class Homework_2021_11_27 {
   
   private static final int NOTEBOOKS_COUNT = 10000;
   
   private static final int MIN_COST = 500;
   private static final int MAX_COST = 3000;
   private static final int STEP_COST = 50;
   
   private static final int MIN_MEMORY = 4;
   private static final int MAX_MEMORY = 24;
   private static final int STEP_MEMORY = 4;
   
   private static final Random rnd = new Random();
   
   public static void main(String[] args) throws InterruptedException {
      
      System.out.println("Генерация исходного неотсортированного массива:");
      Notebook[] notebooks = new Notebook[NOTEBOOKS_COUNT];
      for (int i = 0; i < notebooks.length; i++) {
         notebooks[i] = new Notebook(getRndInt(MIN_COST, MAX_COST, STEP_COST),
                                     getRndInt(MIN_MEMORY, MAX_MEMORY, STEP_MEMORY),
                                     getRndProducer());
      }
      Thread.sleep(500);
      System.out.println("Массив сгенерирован:");
      String str = Arrays.toString(Arrays.copyOf(notebooks, 10));
      System.out.println(str.substring(0, str.length() - 1) + "...");
      //============================================================================
      System.out.println();
      System.out.println("Встроенная сортировка через переопределённый компаратор:");
      Comparator<Notebook> comparator = (n1, n2) -> {
         if (n1.getCost() < n2.getCost())
            return -1;
         else if (n1.getCost() > n2.getCost())
            return 1;
         else if (n1.getMemory() < n2.getMemory())
            return -1;
         else if (n1.getMemory() > n2.getMemory())
            return 1;
         else if (n1.getProducer().getWeight() < n2.getProducer().getWeight())
            return -1;
         else if (n1.getProducer().getWeight() > n2.getProducer().getWeight())
            return 1;
         return 0;
      };
      Notebook[] notebooksNative = Arrays.copyOf(notebooks, notebooks.length);
      long timeIn = System.currentTimeMillis();
      Arrays.sort(notebooksNative, comparator);
      long timeOut = System.currentTimeMillis();
      str = Arrays.toString(Arrays.copyOf(notebooksNative, 10));
      System.out.println(str.substring(0, str.length() - 1) + "...");
      System.out.printf("Время расчёта -  %d мсек.%n", timeOut - timeIn);
      //========================================================================
      System.out.println();
      System.out.println("Пузырьковая сортировка:");
      Notebook[] notebooksBubble = Arrays.copyOf(notebooks, notebooks.length);
      timeIn = System.currentTimeMillis();
      for (int i = notebooksBubble.length - 1; i >= 1; i--) {
         for (int j = 0; j < i; j++) {
            if (notebooksBubble[j].compareTo(notebooksBubble[j + 1]) > 0) {
               swap(notebooksBubble, j, j + 1);
            }
         }
      }
      timeOut = System.currentTimeMillis();
      str = Arrays.toString(Arrays.copyOf(notebooksBubble, 10));
      System.out.println(str.substring(0, str.length() - 1) + "...");
      System.out.printf("Время расчёта - %d мсек.%n", timeOut - timeIn);
      //=========================================================================
      System.out.println();
      System.out.println("Сортировка выбором:");
      Notebook[] notebooksSelect = Arrays.copyOf(notebooks, notebooks.length);
      timeIn = System.currentTimeMillis();
      for (int i = 0; i < notebooksSelect.length; i++) {
         int temp = i;
         for (int j = i + 1; j < notebooksSelect.length; j++) {
            if (notebooksSelect[j].compareTo(notebooksSelect[temp]) < 0) {
               temp = j;
            }
         }
         swap(notebooksSelect, i, temp);
      }
      timeOut = System.currentTimeMillis();
      str = Arrays.toString(Arrays.copyOf(notebooksSelect, 10));
      System.out.println(str.substring(0, str.length() - 1) + "...");
      System.out.printf("Время расчёта - %d мсек.%n", timeOut - timeIn);
      //======================================================================
      System.out.println();
      System.out.println("Сортировка методом вставки:");
      Notebook[] notebooksInsert = Arrays.copyOf(notebooks, notebooks.length);
      timeIn = System.currentTimeMillis();
      for (int i = 1; i < notebooksInsert.length; i++) {
         Notebook temp = notebooksInsert[i];
         int j = i;
         while (j > 0 && notebooksInsert[j - 1].compareTo(temp) >= 0) {
            notebooksInsert[j] = notebooksInsert[j - 1];
            --j;
         }
         notebooksInsert[j] = temp;
      }
      timeOut = System.currentTimeMillis();
      str = Arrays.toString(Arrays.copyOf(notebooksInsert, 10));
      System.out.println(str.substring(0, str.length() - 1) + "...");
      System.out.printf("Время расчёта - %d мсек.%n", timeOut - timeIn);
   }
   
   // Генерация целого числа из заданного диапазона с заданным шагом
   public static int getRndInt(int min, int max, int step) {
      int result;
      int steps = (max - min) / step + 1;
      result = rnd.nextInt(steps) * step + min;
      return result;
   }
   
   // Генерация произвольного производителя
   public static Producer getRndProducer() {
      return Producer.values()[rnd.nextInt(Producer.values().length)];
   }
   
   // обмен двух ячеек массива Notebook[]
   public static void swap(Notebook[] inArray, int i, int j) {
      Notebook temp = inArray[i];
      inArray[i] = inArray[j];
      inArray[j] = temp;
   }
}