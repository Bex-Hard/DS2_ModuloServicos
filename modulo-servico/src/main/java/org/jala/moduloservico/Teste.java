package org.jala.moduloservico;

import java.util.Calendar;

public class Teste {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int ano = calendar.get(Calendar.YEAR);

        System.out.println(dia);
        System.out.println(mes);
        System.out.println(ano);

    }
}
