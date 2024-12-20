/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package transfer.util;

/**
 *
 * @author Milena
 */
public interface Operacije {

    public static final int LOGIN = 0;

    public static final int GET_ALL_ADMINISTRATOR = 1;

    public static final int ADD_KUPAC = 2;
    public static final int DELETE_KUPAC = 3;
    public static final int UPDATE_KUPAC = 4;
    public static final int GET_ALL_KUPAC = 5;

    public static final int ADD_PORUDZBINA = 6;
    public static final int DELETE_PORUDZBINA = 7;
    public static final int UPDATE_PORUDZBINA = 8;
    public static final int GET_ALL_PORUDZBINA = 9;

    public static final int GET_ALL_STAVKA_PORUDZBINE = 10;

    public static final int GET_ALL_TIP_PROIZVODA = 11;

    public static final int GET_ALL_PROIZVOD = 12;

    public static final int GET_ALL_RECENZIJA = 13;
    public static final int ADD_RECENZIJA = 14;
    public static final int DELETE_RECENZIJA = 15;
}
