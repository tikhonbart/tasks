package com.company;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


public class task5 {
    public static void main(String[] args){
        /*1*/System.out.println(sameLetterPattern("FFFF", "ABCD"));
        /*2*/System.out.println(spiderVsFly("B4", "H3"));
        /*3*/System.out.println(digitsCount(0));
        /*4*/System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        /*5*/System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));
        /*6*/System.out.println(takeDownAverage(new int[]{10}));
        /*7*/System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
        /*8*/System.out.println(maxPossible(8732, 91255));
        /*9*/System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        /*10*/System.out.println(isNew(869));
        /*System.out.println(timeDifference1("Los Angeles", "April 1, 2011 23:23", "Canberra"));*/
    }
    //1 Создайте функцию, которая возвращает true, если две строки имеют
    // один и тот же буквенный шаблон, и false в противном случае.
    public static boolean sameLetterPattern(String a, String b){
        boolean res = true;
        String[] amass = a.split("");

        String[] bmass = b.split("");
        int i = 0;
        while (i < a.length()){
            if (a.indexOf(amass[i], i+1) != b.indexOf(bmass[i], i+1)){
                res = false;
            }
            i += 1;
        }
        return res;
    }
    //2 Создайте функцию, которая принимает координаты паука и мухи и
    // возвращает кратчайший путь для паука, чтобы добраться до мухи.
    public static String spiderVsFly(String spider, String fly) {
        String radials = "ABCDEFGH";
        char sr = spider.charAt(0), sl = spider.charAt(1), fr = fly.charAt(0), fl = fly.charAt(1);
        char midRing = Math.abs(sr - fr) <= 2 || 6 <= Math.abs(sr - fr) ? (char)Math.min(sl,fl) : '0';
        String answer = ""+sr+sl+"-";
        while (sl > midRing) answer += --sl == '0' ? "A0-" : ""+ sr + sl + "-";
        while (sl <= fl && midRing != '0') {
            if (sr == fr) break;
            if (6 <= Math.abs(sr -fr)) {
                if (sr > fr) { sr++; if (sr == 'I') sr = 'A';
                }else{ sr--; if (sr == '@') sr = 'H';}
            }
            else{
                if (sr < fr) sr++; else sr--;
            }
            answer += "" + sr + sl + "-";
        }
        while (sl++ < fl) answer += "" + fr + sl + "-";
        return answer.substring(0,answer.length()-1);
    }

    //3 Создайте функцию, которая будет рекурсивно подсчитывать количество цифр числа.
    // Преобразование числа в строку не допускается, поэтому подход является рекурсивным.
    public static int digitsCount (long chislo){
        int kol = 1;
        while (chislo > 0){
            chislo /= 10;
            kol += 1;
        }
        return kol;
    }
    //4 Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-буквенное слово и
    // возвращает общее количество очков, набранных игроком в определенном раунде
    public static int totalPoints(String[] ugad, String bkv){
        int score = 0;
        int sc = 0;
        for(int i = 0; i < ugad.length; i++){
            sc = 0;
            StringBuilder bkvmass = new StringBuilder(bkv);
            for (int j = 0; j < ugad[i].length(); j++) {
                if (bkvmass.indexOf(String.valueOf(ugad[i].charAt(j))) >= 0){
                    bkvmass.deleteCharAt(bkvmass.indexOf(String.valueOf(ugad[i].charAt(j))));
                    sc += 1;
                }
            }
            if (sc == ugad[i].length()){
                if (ugad[i].length() == 3){
                    score += 1;
                }
                if (ugad[i].length() == 4){
                    score += 2;
                }
                if (ugad[i].length() == 5){
                    score += 3;
                }
                if (ugad[i].length() == 6){
                    score += 54;
                }

            }
        }
        return score;
    }
    //5 Создайте функцию, которая принимает массив чисел и возвращает
    // длину самого длинного последовательного запуска.
    public static int longestRun (int[] massch){
        int count1 = 1;
        int count2 = 1;
        for (int i = 0; i < massch.length-1; i++){
            if (Math.abs(massch[i] - massch[i+1]) == 1){
                count1 +=1;
            }
            else if (count1 > count2) {
                count2 = count1;
                count1 = 1;
            }
        }
        return Math.max(count1, count2);
    }
    //6 Какой процент вы можете набрать на тесте, который в одиночку снижает средний балл по классу на 5%?
    // Учитывая массив оценок ваших одноклассников, создайте функцию, которая возвращает ответ.
    public static int takeDownAverage(int[] oc){
        int sum = 0;
        for (int i = 0; i < oc.length; i++){
            sum += oc[i];
        }
        sum = sum / oc.length - (oc.length * 5 + 5);
        return sum;
    }
    //7 Учитывая предложение с числами, представляющими расположение слова,
    // встроенного в каждое слово, верните отсортированное предложение.
    public static String rearrange(String arrange){
        int ind = 0;
        int end = 0;
        String resStr = "";
        //пробелы в начале и конце строки
        arrange = " " + arrange + " ";
        String[] newrange = arrange.split("");
        String[] massrange = arrange.split(" ");
        //формируем новую строку в соответсвии с числами в словах
        for (int i = 1; i < massrange.length; i++){
            //находим начало и конец слова
            ind = arrange.indexOf(String.valueOf(i));
            end = arrange.indexOf(" ", ind);
            while (!newrange[ind].equals(" ")){
                ind -= 1;
            }
            resStr += arrange.substring(ind, end);
        }
        //удаляем цифры
        for (int i = 1; i < massrange.length; i++){
            resStr = resStr.replace(String.valueOf(i), "");
        }
        return resStr.trim();
    }
    //8 Напишите функцию, которая делает первое число как можно больше,
    // меняя его цифры на цифры во втором числе.
    public static String maxPossible(int one, int two){
        String sOne = String.valueOf(one);
        String sTwo = String.valueOf(two);
        int[] massone = new int[sOne.length()];
        int[] masstwo = new int[sTwo.length()];
        int oneLen = sOne.length()-1;
        int twoLen = sTwo.length()-1;
        //представление обоих чисел в виде массива
        while (one>0){
            massone[oneLen] = one%10;
            one = one/10;
            oneLen--;
        }
        while (two>0){
            masstwo[twoLen] = two%10;
            two = two/10;
            twoLen--;
        }
        for (int i = 0; i < massone.length; i++){
            int massmax = 0;
            int cout = 0;
            //находим максимальное число второго массива
            for (int j = 0; j < masstwo.length; j++){
                if (masstwo[j] > massmax){
                    massmax = masstwo[j];
                    cout = j;
                }
            }
            //присваиваем число и изменяем втрой массив
            if (massone[i] < massmax){
                massone[i] = massmax;
                masstwo[cout] = 0;
            }
        }
        String res = "";
        for (int i = 0; i < massone.length; i++){
            res += massone[i];
        }
        return res;
    }
    //9 Вы должны вернуть новую метку времени с датой и соответствующим временем в cityB,
    public static String timeDifference(String town, String date, String newTown){
        String[][] time = new String[][]{
                {"Los Angeles","-8"},
                {"New York",   "-5"},
                {"Caracas",    "-4:30"},
                {"Buenos Aires","-3"},
                {"London",     "+0"},
                {"Rome",       "+1"},
                {"Moscow",     "+3"},
                {"Tehran",     "+3:30"},
                {"New Delhi",  "+5:30"},
                {"Beijing",    "+8"},
                {"Canberra",   "+10"}
        };
        //преобразем строку с датой в массив
        String[] massDate = date.split("[, :]+");
        //присвоение часового пояса к указанному городу
        for (int i = 0; i < time.length; i++){
            if (time[i][0].equals(town)){
                town = time[i][1];
            }
            if (time[i][0].equals(newTown)){
                newTown = time[i][1];
            }
        }
        //создаем переменную с датой старого города
        LocalDateTime gh = LocalDateTime.of(Integer.parseInt(massDate[2]),Month.valueOf(massDate[0].toUpperCase(Locale.ROOT)),
                Integer.parseInt(massDate[1]),Integer.parseInt(massDate[3]),Integer.parseInt(massDate[4]));
        //возвращаем дату в новом городе
        return ZonedDateTime.ofInstant(gh, ZoneOffset.of(town), ZoneId.of(newTown)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    //10 Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
    // если целое число является новым числом, и false, если это не так.
    // 869-это не новое число, потому что это просто перестановка меньших чисел, 689 и 698.
    public static boolean isNew(int ch){
        String mas = Integer.toString(ch);
        String rev = "";
        //переворачиваем число
        for (int i = mas.length()-1; i >= 0; i--) {
            rev += mas.charAt(i);
        }
        int revint = Integer.parseInt(rev);
        if (revint*10 == ch){
            return true;
        }
        return revint >= ch;
    }
}
