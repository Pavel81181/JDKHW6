package ru.bazhin;

//В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс
//         Монти Холла — Википедия ) и наглядно убедиться в верности парадокса
//        (запустить игру в цикле на 1000 и вывести итоговый счет).
//        Необходимо:
//        Создать свой Java Maven или Gradle проект;
//        Подключить зависимость lombok.
//        Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
//        Самостоятельно реализовать прикладную задачу;
//        Сохранить результат в HashMap<шаг теста, результат>
//        Вывести на экран статистику по победам и поражениям
//
//        Работы принимаются в виде ссылки на гит репозиторий со всеми ключевыми файлами проекта


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHall {

    static Random random;
    static Map<Integer,Boolean> statistics;
    static int count;

    public static void main(String[] args) {

        random = new Random();
        statistics = new HashMap<>();
        count = 3;


        for (int i = 0; i < 1000; i++) {
            game(i);
        }


        int vic = 0;
        for (Map.Entry<Integer, Boolean> entry: statistics.entrySet()){
            if (entry.getValue()){
                vic++;
            }
        }
        System.out.println("Количество побед игрока = " + vic);
    }

    private static void game(int num) {
        int winning = random.nextInt(count);
        int firstDoor = random.nextInt(count);
        int emptyDoor = -1;
        int secondDoor = -1;


        for (int i = 0; i <count; i++) {
            if (i != winning && i != firstDoor){
                emptyDoor = i;
            }
        }


        for (int i = 0; i < count; i++) {
            if (i != emptyDoor && i != firstDoor){
                secondDoor = i;
            }
        }


        statistics.put(num, winning == secondDoor);
    }
}