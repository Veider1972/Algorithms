package Homework_2021_12_08;

public class Homework_2021_12_08 {
   
   
   public static void main(String[] args) {
      System.out.println("\nПроверка п.1 ДЗ:");
      long recursiveLongPow = RecursivePow.pow(2L, 10);
      System.out.println("Степень числа 2^10 = " + recursiveLongPow);
      double recursiveDoublePow = RecursivePow.pow(2.3D, 10);
      System.out.println("Степень числа 2.3^10 = " + recursiveDoublePow);
      
      System.out.println("\nПроверка п.2 ДЗ:");
      double purseCapacity = 15.1;                                           // вместимость кошелька в граммах
      ItemsLinkedList itemsForGarbage = new ItemsLinkedList();
      itemsForGarbage.add(new Item("Кольцо с рубином", 2.1, 12000));
      itemsForGarbage.add(new Item("Кольцо с топазом", 2.0, 14000));
      itemsForGarbage.add(new Item("Серёжки с жемчугом", 5.4, 5300));
      itemsForGarbage.add(new Item("Серёжки золотые", 4.4, 2300));
      itemsForGarbage.add(new Item("Запонки серебрянные", 6.4, 4600));
      itemsForGarbage.add(new Item("Заколка для галстука", 3.4, 1200));
      itemsForGarbage.add(new Item("Подвеска", 10.2, 8000));
      itemsForGarbage.add(new Item("Ожерелье", 13.5, 14300));
      System.out.println("Исходный набор украшений:\n" + itemsForGarbage);
      
      System.out.println("Итого в кошелёк вместимостью " + purseCapacity + " гр. лучше всего положить: \n" + (new BackpackFinder(purseCapacity, itemsForGarbage)).getOptimalItemsAmount());
      
   }
}
