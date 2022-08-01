import java.util.*; // можно java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко"}; // создание массива продукты.
        String[] addBasket; // добавить в корзину
        int[] mainBasket = new int[products.length]; // количество продуктов = список продуктов
        int[] prices = {100, 200, 300}; // создание массива цен.
        int sumProducts = 0; // итоговая суммы чека

        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 1; i < products.length + 1; i++) { // Выводим список товаров и их цены.
            System.out.println(i + ". " + products[i - 1] + " " + prices[i - 1] + "руб/шт.");
        }
        while (true) {
            System.out.println("\n☐ Выберите товар и количество или введите `end` ");
            try {
                String input = scanner.nextLine();
                if ("end".equals(input)) break; // выходим в случае набора текста end
                addBasket = input.split(" "); // создаем массив, кладем туда строки раздельно до и после пробела
                int selectProduct = Integer.parseInt(addBasket[0].trim());
                int selectCount = Integer.parseInt(addBasket[1].trim());
                if (selectProduct > (products.length) || (selectProduct == 0) || (selectCount == 0)) { // если выбранный товар больше списка товаров то
                    System.out.println("⊠ ОШИБКА: Такого товара или количества не существует! Ваши вводные данные " + Arrays.toString(addBasket));
                } else if (Integer.parseInt(String.valueOf(addBasket.length)) == 2) {
                    mainBasket[selectProduct - 1] += (selectCount); // записываем в массив выбранный товар
                    System.out.println("☑ Товар '" + products[selectProduct - 1] + "' в количестве " + selectCount + " добавлен в корзину!");
                } else {
                    System.out.println(((Integer.parseInt(String.valueOf(addBasket.length)) == 1) ?
                            "⊠ ОШИБКА: Вы выбрали товар без количества, Ваши вводные данные " :
                            "⊠ ОШИБКА: Неверный формат выбора! \n Необходимо вводить номер товара и количество. Ваши вводные данные ") +
                            Arrays.toString(addBasket));
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("⊠ ОШИБКА: Вы не выбрали товар и количество!");
                continue;
            }
        }
        scanner.close();
        System.out.println("\n☑ Ваша корзина составляет: ");
        for (int i = 1; i < products.length + 1; i++) { // Выводим список выбранных товаров и их цены.
            if (mainBasket[i - 1] != 0) {
                System.out.println(i + ". " + products[i - 1] + " - " + mainBasket[i - 1] + "шт., по " +
                        prices[i - 1] + "руб/шт., на общую сумму: " + (mainBasket[i - 1] * prices[i - 1]));
            }
            sumProducts += mainBasket[i - 1] * prices[i - 1]; //общая сумма, выбранный товар умножаем на цену
        }
        System.out.println("Итого: " + sumProducts);
    } // Main
} // class Main
