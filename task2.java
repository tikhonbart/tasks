package com.company;

import java.util.Arrays;
import java.util.Objects;

public class task2 {
    public static void main(String[] args) {
        /*1*/System.out.println(oppositeHouse(5,46));
        /*2*/System.out.println(nameShuffle ("donald trump"));
        /*3*/System.out.println(discount(1500,50));
        /*4*/System.out.println(differenceMaxMin(new int[]{23, 6, 4, -5}));
        /*5*/System.out.println(equal(2, 3, 2));
        /*6*/System.out.println(reverse("Hello World"));
        /*7*/System.out.println(programmers(147, 33, 526));
        /*8*/System.out.println(getXO("ooxXm"));
        /*9*/System.out.println(bomb("Hey, did you think there is a BOMB?"));
        /*10*/System.out.println(sameAscii("AA", "B@"));
    }
    //1 Создайте функцию, которая принимает номер дома и длину
    // улицы n и возвращает номер дома на противоположной стороне.
    static int oppositeHouse (int a, int b){
        int spr = 0;
        int sprava = 0;
        for (int i=0; i<b; i++){
            sprava = 2 + sprava;
        }
        return (sprava + 1) - a;
    }
    //2 Создайте метод, который принимает строку (имя и фамилию человека) и
    // возвращает строку с заменой имени и фамилии.
    static String nameShuffle (String a){
        String[] reverse = a.split(" ", 0);
        return reverse[1] + " " + reverse[0];
    }
    //3 Создайте функцию, которая принимает два аргумента: исходную цену и процент
    // скидки в виде целых чисел и возвращает конечную цену после скидки.
    static int discount(int price, int percent){
        return (price * percent)/ 100;
    }
    //4 Создайте функцию, которая принимает массив и возвращает
    // разницу между наибольшим и наименьшим числами.
    static int differenceMaxMin(int[] mass){
        int max = 0;
        int min = 1000;
        for (int i = 0; i< mass.length; i++){
            if (mass[i] > max){
                max = mass[i];
            }
        }
        for (int i = 0; i< mass.length; i++){
            if (mass[i] < min){
                min = mass[i];
            }
        }
        return Math.abs(max-min);
    }
    //5 Создайте функцию, которая принимает три целочисленных аргумента (a, b, c) и
    // возвращает количество целых чисел, имеющих одинаковое значение.
    static int equal(int a1, int a2, int a3){
        if(a1 == a2 || a2 == a3 || a1 == a3){
                if (a1 == a2 && a2 == a3){
                    return 3;
                }
                return 2;
        }
        return 0;
    }
    //6 Создайте метод, который принимает строку в качестве
    // аргумента и возвращает ее в обратном порядке.
    static String reverse(String strk){
        String res = "";
        for (int i = strk.length()-1; i>=0; i--){
            res += strk.charAt(i);
        }
        return res;
    }
    //7 Создайте функцию, которая принимает три числа (почасовая заработная плата каждого программиста) и
    // возвращает разницу между самым высокооплачиваемым программистом и самым низкооплачиваемым.
    static int programmers(int prog1, int prog2, int prog3){
        int min = 1000;
        int max = 0;
        int[] minmax = {prog1,prog2,prog3};
        for (int i = 0; i< minmax.length; i++){
            if (minmax[i] > max){
                max = minmax[i];
            }
        }
        for (int i = 0; i< minmax.length; i++){
            if (minmax[i] < min){
                min = minmax[i];
            }
        }
        return max-min;
    }
    //8 Создайте функцию, которая принимает строку, проверяет, имеет ли она
    // одинаковое количество x и o и возвращает либо true, либо false.
    static boolean getXO(String xo){
        String[] mass = xo.split("",0);
        int colX = 0;
        int colO = 0;
        for(int i = 0; i< mass.length; i++){
            if(mass[i].equalsIgnoreCase("x")){
                colX += 1;
            }
            else if(mass[i].equalsIgnoreCase("o")){
                colO += 1;
            }
        }
        return colO == colX;
    }
    //9 Напишите функцию, которая находит слово "бомба" в данной строке.
    // Ответьте "ПРИГНИСЬ!", если найдешь, в противном случае:"Расслабься, бомбы нет".
    static String bomb(String text){
        String[] slova = text.split("",0);
        for (int i = 0; i<slova.length; i++){
            if (slova[i].equalsIgnoreCase("b") && slova[i+1].equalsIgnoreCase("o") &&
                    slova[i+2].equalsIgnoreCase("m") && slova[i+3].equalsIgnoreCase("b")){
                return "DUCK!";
            }
        }
        return "Relax, there's no bomb.";
    }
    //10 Возвращает true, если сумма значений ASCII первой строки совпадает с суммой значений ASCII
    // второй строки, в противном случае возвращает false
    static boolean sameAscii(String one, String two){
        int sumascii1 = 0;
        int sumascii2 = 0;
        for (int i = 0; i<one.length(); i++){
            sumascii1 += (int) one.charAt(i);
        }
        for (int i = 0; i<two.length(); i++){
            sumascii2 += (int) two.charAt(i);
        }
        return sumascii1 == sumascii2;
    }
}
