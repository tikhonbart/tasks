package com.company;

public class task1 {
    public static void main(String[] args) {
        convert(9);
        points(3,4);
        footballPoints(4,5,6);
        divisibleByFive(96);
        and (true, true);
        howManyWalls (46, 5, 4);
        System.out.println(squaed(2));
        profitableGamble(0.9, 1, 2);
        frames(10, 25);
        mod(218, 5);
    }
    //1 метод перевода мунут в секунды
    static void convert(int a){
        int sec = a * 60;
        System.out.println("convert "+ a + " min = " + sec + " sec");
    }
    //2 метод расчета очков за баскетбольный матч
    static void points (int a, int b){
        int res1 = a * 2;
        int res2 = b * 3;
        int res3 = res1 + res2;
        System.out.println("points " + a + ", " + b + " = " + res3 + " total");
    }
    //3 метод расчета очков за футбольный матч
    static void footballPoints (int a, int b, int c){
        int pob = a * 3;
        int res = pob + b;
        System.out.println("footballPoints " + a + " wins, " + b + " loses, " + c + " draws = " + res + " total");
    }
    //4 метод проверки деления на 2
    static void divisibleByFive (double a){
        boolean x;
        if (a % 5 > 0){
            x = false;
        } else{
            x = true;
        }
        System.out.println("divisibleByFive " + a + " = " + x);
    }
    //5 метод умножение двух логических значений
    static void and (boolean a, boolean b){
        boolean sum = a && b;
        if (a && b){
            System.out.println("and (" + a + " , " + b + ") = " + sum);
        }
        else {
            System.out.println("and (" + a + " , " + b + ") = " + sum);
        }
    }
    //6 метод, возвращающий кол-во стен для покраски
    static void howManyWalls (int n, int w, int h){
        int plosh = w * h;
        int del = n / plosh;
        System.out.println("howManyWalls (" + n + " , " + w + " , " + h + ") = " + del);
    }
    //7 исправление ошибок в коде
    public static int squaed(int b) {
        return b * b; //a * a
    }
    //8 функция расчета аргументов
    static void profitableGamble (double prob, double prize, double pay){
        boolean i;
        double n = prob * prize;
        if (n > pay){
            i = true;
            System.out.println("profitableGamble (" + prob + " , " + prize + " , " + pay + ") = " + i);
        } else{
            i = false;
            System.out.println("profitableGamble (" + prob + " , " + prize + " , " + pay + ") = " + i);
        }
    }
    //9метод покаызвающий кол-во кадров
    static void frames(int min, int fps){
        int sec = min * 60;
        int total = sec * fps;
        System.out.println("frames (" + min + " , " + fps + ") = " + total);
    }
    //10 метод оператор модуля %
    static void mod (int i, int j){
        int oper = i / j;
        int ost = i - (j * oper);
        System.out.println("mod (" + i + " , " + j + ") = " + ost);
    }
}
