package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class LeituraRobusta {
   public LeituraRobusta() {
   }

   public static void main(String[] var0) {
      Locale.setDefault(Locale.US);
      Scanner var1 = new Scanner(System.in);

      try {
         System.out.print("Introduza um inteiro: ");
         int var2 = lerInt(var1);
         System.out.print("Introduza um número real (double): ");
         double var3 = lerDouble(var1);
         System.out.print("Introduza um texto (linha): ");
         String var5 = var1.nextLine().trim();
         System.out.printf("OK: n=%d, x=%.3f, texto=\"%s\"%n", var2, var3, var5);
      } catch (Throwable var7) {
         try {
            var1.close();
         } catch (Throwable var6) {
            var7.addSuppressed(var6);
         }

         throw var7;
      }

      var1.close();
   }

   static int lerInt(Scanner var0) {
      while(true) {
         String var1 = var0.nextLine();

         try {
            return Integer.parseInt(var1.trim());
         } catch (NumberFormatException var3) {
            System.out.print("Inteiro inválido. Tente novamente: ");
         }
      }
   }

   static double lerDouble(Scanner var0) {
      while(true) {
         String var1 = var0.nextLine();

         try {
            return Double.parseDouble(var1.trim());
         } catch (NumberFormatException var3) {
            System.out.print("Double inválido. Tente novamente (ex.: 3.14): ");
         }
      }
   }
}
