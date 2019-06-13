/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab05;

import  vlada_lab03.View;

/**
 * Консольная команда Generate; шаблон Command
 *
 * @author Twistzz
 * @version 1.0
 */
public class EnterConsoleCommand implements ConsoleCommand {

    /**
     * Объект, реализующий интерфейс {@linkplain View}; обслуживает коллекцию
     * объектов {@linkplain ex01.Item2d}
     */
    private View view;

    /**
     * Инициализирует поле {@linkplain GenerateConsoleCommand#view}
     *
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public EnterConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'e';
    }

    @Override
    public String toString() {
        return "'e'nter";
    }

    @Override
    public void execute() {
        System.out.println("Enter decimal number");
        view.viewInit();
        view.viewShow();
    }
}
