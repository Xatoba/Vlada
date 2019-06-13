/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import vlada_lab02.Item2d;

/**
 * ConcreteProduct (Шаблон проектирования Factory Method)<br>
 * Вычисление полных тетрад, сохранение и отображение результатов.
 *
 * @author Twistzz
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {

    /**
     * Имя файла, используемое при сериализации
     */
    private static final String FNAME = "items.bin";
    /**
     * Определяет количество значений для вычисления по умолчанию
     */
    private static final int DEFAULT_NUM = 10;
    /**
     * Коллекция аргументов и результатов вычислений
     */
    private ArrayList<Item2d> items = new ArrayList<>();

    /**
     * Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)} с
     * параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Инициализирует коллекцию {@linkplain ViewResult#items}
     *
     * @param n начальное количество элементов
     */
    public ViewResult(int n) {
        for (int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }

    /**
     * Получить значение {@linkplain ViewResult#items}
     *
     * @return текущее значение ссылки на объект {@linkplain ArrayList}
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }
    /**
     * Вычисляет количество полных тетрад
     * в двоичном представлении десятичного числа
     *    
     * @param x - Введенное десятичное число.
     * @return Результат вычисления тетрад.
    */
    public String calc(int x) {
        String h = Integer.toHexString(x);
        String o = Integer.toOctalString(x);
        int amountHex = h.length();
        int amountOctal = o.length();
        return amountHex + " " + amountOctal;
    }

    /**
     * Вычисляет количество тетрад и сохраняет результат в коллекции
     * {@linkplain ViewResult#items}
     *
     * @param stepX шаг приращения числа
     */
    public void init(int stepX) {
        int x = 0;
        for (Item2d item : items) {
            item.setXY(x, calc(x));
            x += stepX;
        }
    }

    /**
     * Вызывает <b>init(double stepX)</b> с введенным пользователем значением x<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit() {
        Scanner scan = new Scanner(System.in);
        init(scan.nextInt());
    }

    /**
     * Реализация метода {@linkplain View#viewSave()}<br> {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /**
     * Реализация метода {@linkplain View#viewRestore()}<br> {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }

    /**
     * Реализация метода {@linkplain View#viewHeader()}<br> {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }

    /**
     * Реализация метода {@linkplain View#viewBody()}<br> {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.printf("(%d; %s) ", item.getX(), item.getY());
        }
        System.out.println();
    }

    /**
     * Реализация метода {@linkplain View#viewFooter()}<br> {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }

    /**
     * Реализация метода {@linkplain View#viewShow()}<br> {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
