package ru.geekbrains.Lesson9;

import java.io.IOException;

public class App {
    // checked exception
    // unchecked exception


    public static void main(String[] args) {
        App app = new App();
        try {
            app.div(3, 1);
        } catch (ArithmeticException e) {
            System.out.println("вы пробовали поделить на ноль " + e.getMessage());
        } catch (RuntimeException e){
            e.printStackTrace();
        } catch (Exception e) {

        } catch (Throwable t) {

        } finally {
            System.out.println("finally");
        }
        //} catch (ArrayIndexOutOfBoundsException e) {
        //    System.out.println("выход за пределы массива " + e.getMessage());
        //} catch (ClassCastException e){
        //    System.out.println("ошибка преобразования типов " /*+ e.getMessage()*/);
        //    e.printStackTrace();
        //}

    }

    public void div(int a, int b) throws IOException {
        int i = a/b;
        Object i1 = new Integer(1);
        String s = (String) i1;
        int[] c = {1,2,3};
        int d = c[4];
        throw new IOException("бросили проверяемое исключение");

    }
}