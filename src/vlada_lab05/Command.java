/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab05;

/**
 * Интерфейс команды или задачи; шаблоны: Command, Worker Thread
 *
 * @author Twistzz
 * @version 1.0
 */
public interface Command {

    /**
     * Выполнение команды; шаблоны: Command, Worker Thread
     */
    public void execute();
}
