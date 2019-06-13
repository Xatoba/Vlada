/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab05;

import vlada_lab03.View;
import  vlada_lab04.ViewableTable;

/**
 * Формирует и отображает меню; реализует шаблон Singleton
 *
 * @author Twistzz
 * @version 1.0
 */
public class Application {

    /**
     * Ссылка на экземпляр класса Application; шаблон Singleton
     *
     * @see Application
     */
    private static Application instance = new Application();

    /**
     * Закрытый конструктор; шаблон Singleton
     *
     * @see Application
     */
    private Application() {
    }

    /**
     * Возвращает ссылку на экземпляр класса Application; шаблон Singleton
     *
     * @see Application
     */
    public static Application getInstance() {
        return instance;
    }
    /**
     * Объект, реализующий интерфейс {@linkplain View}; обслуживает коллекцию
     * объектов {@linkplain ex01.Item2d}; инициализируется с помощью Factory
     * Method
     */
    private View view = new ViewableTable().getView();
    /**
     * Объект класса {@linkplain Menu}; макрокоманда (шаблон Command)
     */
    private Menu menu = new Menu();

    /**
     * Обработка команд пользователя
     *
     * @see Application
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new EnterConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}
