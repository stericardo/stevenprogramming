/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenprogramming.library.ocp8.ch8;

/**
 *
 * @author steven
 */
public class CheckerApart {
    
     int value = 0;
        public CheckerApart(int value){
            this.value = value;
        }
        
        private boolean isBigger(int v){
            if(v > 5)
                return true;
            return false;
        }
}
