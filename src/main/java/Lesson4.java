import java.util.Scanner;

    public class Lesson4 {

        public static void task10and20 (int a, int b) {


            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            String b = scanner.nextLine();


            //String s = (a + b >= 10 && a + b <= 20) ? "true" : "false";
            if (a + b >= 10) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }

        }
    }
