import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Scanner scanner = new Scanner(System.in);

        int pipl = 0; //Количество человек
        String pruduct = ""; // Наименование товара
        double price = 0; // Цена товара

        do  {
            System.out.println("На скольких человек необходимо разделить счет?");
            if (scanner.hasNextInt()) {
                pipl = scanner.nextInt();
                switch ((pipl > 1) ? 0 : (pipl == 1) ? 1 : 2 ) {
                    case 0:
                        System.out.println("Счет будет разделен на " + pipl + " человек");
                        break;
                    case 1:
                        System.out.println("За все платите Вы. Значение должно быть больше единицы, попробуйте ещё раз.");
                        break;
                    case 2:
                        System.out.println("Ошибка. Это некорректное значение для подсчёта. Попробуйте ещё раз.");
                }
            }
            else {
                System.out.println("Значение некорректно, оно должно быть больше единицы. Попробуйте ещё раз.");
                scanner.next();
            }
        } while (pipl<=1);

        class Calculator {
            int pipl;
            double price;
            double sumPrice;
            double totalSum;
            String list = "Добавленные товары:";
            String product = "";

            Calculator(int pipl, String pruduct, double price) {
                this.pipl = pipl;
                this.product = pruduct;
                this.price = price;
            }
            void addInput(String product, double price) {
                sumPrice += price;
                list = list + "\n" + product;
                System.out.println(product + " в списке товаров");
                totalSum = (double) sumPrice/pipl;
            }
        }

        class Format {
            String textRub (double price) {
                double formatRub = Math.floor(price)%10;
                if (formatRub == 1) {
                    return "рубль";
                }
                else
                if (formatRub>= 2 && formatRub <= 4) {
                    return "рубля";
                }
                else {
                    return "рублей";
                }
            }
            String Rub(final double result) {
                return String.format("%.2f", result);
            }
        }

        Calculator calc = new Calculator(pipl, pruduct, price);

        while (true) {
            System.out.println("Введите название товара");
            String product = scanner.next();
            while (true) {
                System.out.println("Введите стоимость товара в формате: 'рубли.копейки' [10,45; 11,40]");
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    break;
                }
                else {
                    System.out.println("Значение некорректно. Попробуйте ещё раз.");
                    scanner.next();
                }
            }

            calc.addInput(product, price);

            System.out.println("Хотите добавить еще один товар? \nВведите 'Y'  для продолжения, либо 'N'  для завершения");
            String question = scanner.next();
            if (question.equalsIgnoreCase("N")||question.equalsIgnoreCase("Т")||question.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

        Format format = new Format();

        System.out.println(calc.list);
        System.out.println("С каждого по: " + format.Rub(calc.totalSum) + " " + format.textRub(calc.totalSum));
        //System.out.println("Привет Мир");
    }
}
