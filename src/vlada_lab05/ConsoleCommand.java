/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab05;

/**
 * Интерфейс консольной команды; шаблон Command
 *
 * @author Twistzz
 * @version 1.0
 */
public interface ConsoleCommand extends Command {

    /**
     * Горячая клавиша команды; шаблон Command
     *
     * @return символ горячей клавиши
     */
    public char getKey();
}
