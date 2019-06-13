/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlada_lab04;

import vlada_lab03.ViewableResult;
import vlada_lab03.View;

public class ViewableTable extends ViewableResult {

    public View getView() {
        return new ViewTable();
    }
}
