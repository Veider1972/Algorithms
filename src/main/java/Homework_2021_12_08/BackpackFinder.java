package Homework_2021_12_08;

import java.util.LinkedList;

public class BackpackFinder {
   int size;
   private final ItemsLinkedList items;
   private final double backPackCapacity;
   private final LinkedList<ItemsLinkedList> allCombinations = new LinkedList<>();
   
   public BackpackFinder(double backPackCapacity, ItemsLinkedList items) {
      this.items = items;
      size = items.size();
      this.backPackCapacity = backPackCapacity;
   }
   
   private void getCombinations(int newSize) {
      if (newSize == 1)
         return;
      for (int i = 0; i < newSize; i++) {
         getCombinations(newSize - 1);
         if (newSize == 2)
            allCombinations.add((ItemsLinkedList) items.clone());
         items.addLast(items.remove(size - newSize));
      }
   }
   
   private void trimCombinations() {
      for (ItemsLinkedList currentCombination : allCombinations) {
         double totalWeight = 0;
         for (int j = 0; j < currentCombination.size(); j++) {
            totalWeight += currentCombination.get(j).weight;
            if (totalWeight > backPackCapacity) {
               currentCombination.subList(j, currentCombination.size()).clear();
               break;
            }
         }
      }
   }
   
   private ItemsLinkedList getOptimalCombination() {
      int optimalItemIndex = 0;
      int optimalItemCost = 0;
      for (int i = 0; i < allCombinations.size(); i++) {
         int currentItemsCost = getItemsCost(allCombinations.get(i));
         if (optimalItemCost < currentItemsCost) {
            optimalItemCost = currentItemsCost;
            optimalItemIndex = i;
         }
      }
      return allCombinations.get(optimalItemIndex);
   }
   
   private int getItemsCost(LinkedList<Item> itemsForCost) {
      int cost = 0;
      for (Item item : itemsForCost) {
         cost += item.cost;
      }
      return cost;
   }
   
   public LinkedList<Item> getOptimalItemsAmount() {
      getCombinations(size);
      trimCombinations();
      return getOptimalCombination();
   }
}
