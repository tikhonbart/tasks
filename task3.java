package com.company;

import java.util.Arrays;
import java.util.Locale;

public class task3 {
    public static void main(String[] args){
        /*1*/System.out.println(Arrays.deepToString(millionsRounding(new String[][]{
                {"Nice", "942208"},
                {"Abu Dhabi", "1482816"},
                {"Naples", "2186853"},
                {"Vatican City", "572"}})));
        /*2*/System.out.println(Arrays.toString(otherSides(1)));
        /*3*/System.out.println(rps("rock", "scissors"));
        /*4*/System.out.println(warOfNumbers(new int[]{2, 8, 7, 5}));
        /*5*/System.out.println(reverseCase("Happy Birthday"));
        /*6*/System.out.println(inatorInator("EvilClone"));
        /*7*/System.out.println(doesBrickFit(1,1,1,1,1));
        /*8*/System.out.println(totalDistance(36.1, 8.6,3,true));
        /*9*/System.out.println(mean(new int[]{2, 3, 2, 3}));
        /*10*/System.out.println(parityAnalysis(243));

    }
    //1 Учитывая массив городов и населения, верните массив, в котором все население
    //округлено до ближайшего миллиона.
    public static String[][] millionsRounding(String[][]  s){
        double massch = 0;
        for (int i = 0; i<s.length; i++){
            massch = Integer.parseInt(s[i][1]);
            massch = Math.round(massch/1000000)*1000000;
            s[i][1] = Double.toString(massch);
        }
        return s;
    }
    //2 Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
    //найти другие 2 стороны (верните самую длинную сторону, сторону средней
    //длины).
    public static double[] otherSides(double kat1){
        double scale = Math.pow(10, 2);
        double gip = kat1 * 2;
        double kat2 = Math.sqrt(Math.pow(gip,2)-Math.pow(kat1,2));
        /*double[] sides = new double[] {gip, Math.round(kat2*scale)/scale};*/
        return new double[] {gip, Math.round(kat2*scale)/scale};
    }
    //3 Создайте функцию, имитирующую игру "камень, ножницы, бумага"
    public static String rps(String player1, String player2){
        String[] kmn = new String[]{"rock","paper","scissors"};
        if (player1 == player2){
            return "tie";
        }
        if (player1.equals(kmn[0]) && player2.equals(kmn[2]) ||
                player1.equals(kmn[1]) && player2.equals(kmn[0]) ||
                player1.equals(kmn[2]) && player2.equals(kmn[1]))   {
            return "Player 1 wins";
        }
        else {
            return "Player 2 wins";
        }
    }
    //4 определить, какая
    //группа суммируется больше: четная или нечетная. Выигрывает большая группа.
    public static int warOfNumbers (int[] num){
        int chetn = 0;
        int nechetn = 0;
        for (int i = 0; i<num.length; i++){
            if (num[i]%2==0){
                chetn += num[i];
            }
            if (num[i]%2>0){
                nechetn+=num[i];
            }
        }
        return Math.abs(chetn - nechetn);
    }
    //5 Учитывая строку, создайте функцию для обратного обращения. Все буквы в
    //нижнем регистре должны быть прописными, и наоборот.
    public static String reverseCase(String defstr){
        String[] cas = defstr.split("", 0);
        String res = "";
        for (int i = 0; i< cas.length; i++){
            if(cas[i].equals(cas[i].toLowerCase(Locale.ROOT))){
                res += cas[i].toUpperCase(Locale.ROOT);
            }
            else if(cas[i].equals(cas[i].toUpperCase(Locale.ROOT))){
                res += cas[i].toLowerCase(Locale.ROOT);
            }
        }
        return res;
    }
    //6 Конкатенирует inator до конца, если слово заканчивается согласным, в противном
    //случае вместо него конкатенирует -inator
    //Добавляет длину слова исходного слова в конец, снабженный '000'.
    public static String inatorInator(String slovo){
        boolean sogl;
        String[] slovos= slovo.split("");
        int max = slovo.length()-1;
        if (slovos[max].equalsIgnoreCase("a") || slovos[max].equalsIgnoreCase("u") ||
                slovos[max].equalsIgnoreCase("e") || slovos[max].equalsIgnoreCase("o") ||
                slovos[max].equalsIgnoreCase("y") || slovos[max].equalsIgnoreCase("i")){
            return slovo + "-inator " + slovo.length()*1000;
        }
        else return slovo + "inator " + slovo.length()*1000;
    }
    //7 Напишите функцию, которая принимает три измерения кирпича: высоту(a),
    //ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
    //отверстие с шириной(w) и высотой(h).
    public static boolean doesBrickFit(int a, int b, int c, int aOtv, int bOtv){
        /*int ploshOtv = aOtv * bOtv;
        if (ploshOtv >= a*b || ploshOtv >= a*c || ploshOtv >= b*c){
            return true;
        }
        else return false;*/
        return (a <= aOtv && b <= bOtv) || (b <= aOtv && a <= bOtv) ||
                (a <= aOtv && c <= bOtv) || (c <= aOtv && a <= bOtv) ||
                (c <= aOtv && b <= bOtv) || (b <= aOtv && c <= bOtv);
    }
    //8 Напишите функцию, которая принимает топливо (литры), расход топлива
    //(литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
    //максимальное расстояние, которое может проехать автомобиль.
    public static double totalDistance(double topl, double rash, int pas, boolean kond){
        double scale = Math.pow(10, 2);
        double pasrash = 0;
        for (int i = 0; i<pas; i++){
            pasrash += 5;
        }
        double resPasRush = 0;
        if(pas>0){
            resPasRush = rash*pasrash/100+rash;
        }
        else resPasRush = rash;
        if (kond){
            resPasRush= resPasRush*0.1+resPasRush;
        }
        return Math.round(topl/resPasRush*100*scale)/scale;
    }
    //9 Создайте функцию, которая принимает массив чисел и возвращает среднее
    //значение (average) всех этих чисел.
    public static double mean(int[] chisla){
        double all = 0;
        for (int i = 0; i< chisla.length; i++){
            all += chisla[i];
        }
        return all/ chisla.length;
    }
    //10 Создайте функцию, которая принимает число в качестве входных данных и
    //возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
    //противном случае верните false.
    public static boolean parityAnalysis(int a){
        int sum = 0;
        int b = a;
        while (b != 0){
            sum += b%10;
            b/=10;
        }
        String astr = Integer.toString(a);
        int sr = sum/astr.length();
        if (a%2 == 0 && sr%2 == 0 || a%2 > 0 && sr%2 >0){
            return true;
        }
        else return false;
    }
}
