/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab05;

import java.util.Scanner;
import  vlada_lab02.Item2d;
import vlada_lab02.Calc;

/**
 * Команда Change item; шаблон Command
 *
 * @author Twistzz
 * @version 1.0
 */
public class ChangeItemCommand implements Command {

    /**
     * Обрабатываемый объект; шаблон Command
     */
    private Item2d item;
    /**
     * Параметр команды; шаблон Command
     */
    private double offset;

    /**
     * Устанавливаент поле {@linkplain ChangeItemCommand#item}
     *
     * @param item значение для {@linkplain ChangeItemCommand#item}
     * @return новое значение {@linkplain ChangeItemCommand#item}
     */
    public Item2d setItem(Item2d item) {
        return this.item = item;
    }

    /**
     * Возвращает поле {@linkplain ChangeItemCommand#item}
     *
     * @return значение {@linkplain ChangeItemCommand#item}
     */
    public Item2d getItem() {
        return item;
    }

    /**
     * Устанавливаент поле {@linkplain ChangeItemCommand#offset}
     *
     * @param offset значение для {@linkplain ChangeItemCommand#offset}
     * @return новое значение {@linkplain ChangeItemCommand#offset}
     */
    public double setOffset() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter scale factor");
        offset = scan.nextDouble();
        return this.offset = offset;
    }
    
    /**
     * Перегруженный метод setOffset() для тестирования.
     * @param offset
     * @return 
     */
    public double setOffset(double offset) {
        return this.offset = offset;
    }

    /**
     * Возвращает поле {@linkplain ChangeItemCommand#offset}
     *
     * @return значение {@linkplain ChangeItemCommand#offset}
     */
    public double getOffset() {
        return offset;
    }
    
    public String calc(int x) {
        String h = Integer.toHexString(x);
        String o = Integer.toOctalString(x);
        int amountHex = h.length();
        int amountOctal = o.length();
        return amountHex + " \t " + amountOctal;
    }

    @Override
    public void execute() {
        //item.setX((int) (item.getX() * offset));
        item.setY(calc(item.setX((int) (item.getX() * offset))));
    }
}
