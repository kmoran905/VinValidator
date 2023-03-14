/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vinvalidator;

import java.util.HashMap;

/**
 *
 * @author kmoran905
 */
public class VinValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
    
    
System.out.println(checkVin("5YJ3E1EA7HF000337"));


        
    }

   public static boolean checkVin(String vin) {
    // Code here
    HashMap<Character,Integer> mapVin = new HashMap<>();

    //Letters Map
    mapVin.put('A', 1); mapVin.put('B', 2); mapVin.put('C', 3); mapVin.put('D', 4); mapVin.put('E', 5);
    mapVin.put('F', 6); mapVin.put('G', 7); mapVin.put('H', 8); mapVin.put('J', 1); mapVin.put('K', 2);
    mapVin.put('L', 3); mapVin.put('M', 4); mapVin.put('N', 5); mapVin.put('P', 7); mapVin.put('R', 9);
    mapVin.put('S', 2); mapVin.put('T', 3); mapVin.put('U', 4); mapVin.put('V', 5); mapVin.put('W', 6);
    mapVin.put('X', 7); mapVin.put('Y', 8); mapVin.put('Z', 9);
    
    //Numbers Map
    mapVin.put('1', 1); mapVin.put('2', 2); mapVin.put('3', 3); mapVin.put('4', 4); mapVin.put('5', 5); mapVin.put('6', 6);
    mapVin.put('7', 7); mapVin.put('8', 8); mapVin.put('9', 9); mapVin.put('0', 0);

    final int[] WEIGHTS = {8, 7, 6, 5, 4, 3, 2, 10, 
        0 , 9 , 8 , 7 , 6 , 5 , 4 , 3, 2 , 1};

    int product = 0;
    
    

    for (int i = 0; i < vin.length(); i++) {     
   
        if (mapVin.containsKey(vin.charAt(i))) {
            
            product += mapVin.get(vin.charAt(i)) * WEIGHTS[i];
        }  else {
            return false;
        }  
    }

    
   


  if ((product % 11) == 10 && vin.charAt(8) == 'X' && vin.length() == 17) {
       return true; 
       } else if ((product % 11) == mapVin.get(vin.charAt(8)) && vin.length() == 17 && 
       Character.toString(vin.charAt(8)).matches("[^A-Z]")) {
           return true;
       } else {
           return false;
       }
       }
  }
