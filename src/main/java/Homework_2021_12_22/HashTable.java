package Homework_2021_12_22;

public class HashTable {
   Entry[][] entries;
   
   public HashTable(int size) {
      this.entries = new Entry[size][];
   }
   
   public void changeSize(int newSize) {
      Entry[][] newEntries = new Entry[newSize][0];
      for (Entry[] value : entries) {
         if (value == null) continue;
         for (Entry entry : value) {
            int hash = getHash(entry.getNumber(), newEntries.length);
            if (newEntries[hash] == null) {
               newEntries[hash] = new Entry[0];
               newEntries[hash][0] = entry;
            }
            else newEntries[hash] = addEntryToCoin(newEntries[hash], entry);
         }
      }
      entries = newEntries;
   }
   
   private int getHash(int key, int size) {
      return key % size;
   }
   
   private Entry[] addEntryToCoin(Entry[] entries, Entry entry) {
      for (Entry value : entries) {
         if (value.getNumber() == entry.getNumber()) {
            value.setCount(value.getCount() + entry.getCount());
            return entries;
         }
      }
      Entry[] newEntries = new Entry[entries.length + 1];
      System.arraycopy(entries, 0, newEntries, 0, entries.length);
      newEntries[entries.length] = entry;
      return newEntries;
   }
   
   public void insert(int number) {
      insert(new Entry(number));
   }
   
   public void insert(Entry entry) {
      int hash = getCurrentHash(entry.getNumber());
      if (entries[hash] == null) {
         entries[hash] = new Entry[1];
         entries[hash][0] = entry;
      }
      else entries[hash] = addEntryToCoin(entries[hash], entry);
      
   }
   
   private int getCurrentHash(int key) {
      return getHash(key, entries.length);
   }
   
   public void deleteNumber(int key, int count) {
      int hash = getCurrentHash(key);
      if (entries[hash] == null) return;
      for (int i = 0; i < entries[hash].length; i++) {
         if (entries[hash][i].getNumber() == key) {
            int newCount = entries[hash][i].getCount() - count;
            if (newCount > 0) {
               entries[hash][i].setCount(newCount);
            }
            else {
               deleteEntry(key);
            }
            return;
         }
      }
   }
   
   private void deleteEntry(int key) {
      int hash = getCurrentHash(key);
      if (entries[hash] == null) return;
      for (int i = 0; i < entries[hash].length; i++) {
         if (entries[hash][i].getNumber() == key) {
            if (entries[hash].length == 1) {
               entries[hash] = null;
            }
            else {
               Entry[] newEntry = new Entry[entries[hash].length - 1];
               System.arraycopy(entries[hash], 0, newEntry, 0, i);
               System.arraycopy(entries[hash], i + 1, newEntry, i, entries[hash].length - i - 1);
               entries[hash] = newEntry;
            }
            return;
         }
      }
   }
   
   @Override
   public String toString() {
      int groups = entries.length;
      int elementsCount = 0;
      int totalCount = 0;
      StringBuilder sb = new StringBuilder("[");
      for (int i = 0; i < entries.length; i++) {
         sb.append("[");
         if (entries[i] != null) for (int j = 0; j < entries[i].length; j++) {
            sb.append(entries[i][j]);
            elementsCount++;
            totalCount += entries[i][j].getCount();
            if (j < entries[i].length - 1) sb.append(",");
         }
         sb.append("]");
         if (i < entries.length - 1) sb.append(" , ");
         
      }
      sb.append("]");
      return String.format("Групп: %d, элементов: %d, всего чисел: %d, ", groups, elementsCount, totalCount) + sb;
   }
}
