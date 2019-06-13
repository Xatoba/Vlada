/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab03;

import java.io.IOException;

/**
 * Product (шаблон проектирования Factory Method)<br>
 * Интерфейс "фабрикуемых" объектов<br>
 * Объявляет методы отображения объектов
 * @author Twistzz
 * @version 1.0
 */
public interface View {

    /**
     * Отображает заголовок
     */
    public void viewHeader();

    /**
     * Отображает основную часть
     */
    public void viewBody();

    /**
     * Отображает окончание
     */
    public void viewFooter();

    /**
     * Отображает объект целиком
     */
    public void viewShow();

    /**
     * Выполняет инициализацию
     */
    public void viewInit();

    /**
     * Сохраняет данные для последующего восстановления
     * @throws java.io.IOException
     */
    public void viewSave() throws IOException;

    /**
     * Восстанавливает ранее сохранённые данные
     * @throws java.lang.Exception
     */
    public void viewRestore() throws Exception;
}
