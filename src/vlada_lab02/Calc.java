/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Вычисление полных тетрад, сохранение и отображение результатов.
 *
 * @author Twistzz
 */
public class Calc {

    /**
     * Имя файла, используемое при сериализации.
     */
    private static final String FNAME = "Item2d.bin";
    /**
     * Сохраняет результат вычислений. Объект класса {@linkplain Item2d}
     */
    private Item2d result;

    /**
     * Инициализирует {@linkplain Calc#result}
     */
    public Calc() {
        result = new Item2d();
    }

    /**
     * Установить значение {@linkplain Calc#result}
     *
     * @param result - новое значение ссылки на объект {@linkplain Item2d}
     */
    public void setResult(Item2d result) {
        this.result = result;
    }

    /**
     * Получить значение {@linkplain Calc#result}
     *
     * @return текущее значение ссылки на объект {@linkplain Item2d}
     */
    public Item2d getResult() {
        return result;
    }

    /**
     * Вычисляет количество полных тетрад.
     *
     * @param x - Введенное десятичное число.
     * @return Результат вычисления тетрад.
     */
    public String calc(int x) {
        String h = Integer.toHexString(x);
        String o = Integer.toOctalString(x);
        System.out.println(o);
        int amountHex = h.length();
        int amountOctal = o.length();
        return "16-ричных: " + amountHex + "\n8-ричных: " + amountOctal;
    }

    /**
     * Вычисляет количество полных тетрад и сохраняет результат в объекте
     * {@linkplain Calc#result}
     * @return 
     */
    public String init() {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        result.setX(x);
        return result.setY(calc(x));
    }

    /**
     * Выводит результат вычислений.
     */
    public void show() {
        System.out.println(result);
    }

    /**
     * Сохраняет {@linkplain Calc#result} в файле {@linkplain Calc#FNAME}
     *
     * @throws IOException
     */
    public void save() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(result);
            os.flush();
        }
    }

    /**
     * Восстанавливает {@linkplain Calc#result} из файла {@linkplain Calc#FNAME}
     *
     * @throws Exception
     */
    public void restore() throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            result = (Item2d) is.readObject();
        }
    }

}
