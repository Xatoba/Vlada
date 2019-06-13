/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab03;

/**
 * ConcreteCreator (шаблон проектирования Factory Method)<br>
 * Объявляет метод, "фабрикующий" объекты
 *
 * @author Twistzz
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {

    /**
     * Создаёт отображаемый объект {@linkplain ViewResult}
     */
    @Override
    public View getView() {
        return new ViewResult();
    }
}
