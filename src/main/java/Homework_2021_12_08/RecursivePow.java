package Homework_2021_12_08;

public class RecursivePow {
   public static long pow(int value, int degree) {
      return pow((long) value, degree);
   }
   
   public static long pow(long value, int degree) {
      if (degree == 0)
         return 1;
      return value * pow(value, --degree);
   }
   
   public static double pow(float value, int degree) {
      return pow((double) value, degree);
   }
   
   public static double pow(double value, int degree) {
      if (degree == 0)
         return 1;
      return value * pow(value, --degree);
   }
}
