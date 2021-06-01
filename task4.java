package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class task4 {
    public static void main(String[] args){
        /*1*/System.out.println(sevenBoom(new int[]{78, 2, 6}));
        /*2*/System.out.println(cons(new int[]{1, 3, 4, 9, 6, 2, 5}));
        /*3*/System.out.println(unmix("badce"));
        /*4*/System.out.println(noelling("jirenbv!!!!"));
        /*5*/System.out.println(xPronounce("The x ray is excellent"));
        /*6*/System.out.println(largestGap(new int[]{9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        /*7*/System.out.println(chislas(832));
        /*8*/System.out.println(commonLastVowel("Hello World!"));
        /*9*/System.out.println(memeSum(26, 39));
        /*10*/System.out.println(unrepeated("teshahset"));
    }
    // 1 Создайте функцию, которая принимает массив чисел и возвращает "Бум!",
    // если в массиве появляется цифра 7. В противном случае верните "в массиве нет 7".
    public static String sevenBoom(int[] chisla){
        int len = 0;
        for (int i = 0; i<chisla.length; i++){
            len = chisla[i];
            while (len!=0){
                if (len%10 == 7){
                    return "boom!";
                }
                len /= 10;
            }
        }
        return "no 7";
    }
    // 2 Создайте функцию, которая определяет, могут ли элементы в массиве быть переупорядочены,
    // чтобы сформировать последовательный
    // список чисел, где каждое число появляется ровно один раз.
    public static boolean cons(int[] mass){
        Arrays.sort(mass);
        for (int i = 0; i<mass.length-1; i++){
            if (mass[i] == mass[i+1]){
                return false;
            }
            if (mass[i+1]-mass[i] > 1){
                return false;
            }
        }
        return true;
    }
    // 3 lPaeesh le pemu mnxit ehess rtnisg! О, извините,
    // это должно было быть: Пожалуйста, помогите мне распутать эти строки!
    public static String unmix(String str){
        String[] strarr = str.split("");
        String a = "";
        for(int i = 0; i<strarr.length-1; i+=2){
            a = strarr[i];
            strarr[i] = strarr[i + 1];
            strarr[i + 1] = a;

        }
        return String.join("", strarr);
    }
    //4 Создать функцию, которая преобразует предложения, заканчивающиеся несколькими вопросительными знаками ?
    // или восклицательными знаками ! в предложение, заканчивающееся только одним, без изменения пунктуации в
    // середине предложений
    public static String noelling(String pred){
        if (pred.lastIndexOf("?") == pred.length()-1){
            while (pred.lastIndexOf("?") == pred.length()-1){
                pred = pred.substring(0, pred.length()-1);
            }
            return pred + "?";
        }
        if (pred.lastIndexOf("!") == pred.length()-1){
            while (pred.lastIndexOf("!") == pred.length()-1){
                pred = pred.substring(0, pred.length()-1);
            }
        } return pred + "!";
    }
    //5 Замените все x на "cks", ЕСЛИ ТОЛЬКО:
    //Слово начинается с "x", поэтому замените его на "z".
    //Слово-это просто буква "х", поэтому замените ее на " cks "
    public static String xPronounce(String x){
        String[] xs = x.split(" ");
        for (int i = 0; i<xs.length; i++){
            if (xs[i].indexOf("x") == 0 && xs[i].length() > 1){
                xs[i] = xs[i].replace("x", "z");
            }
            if (xs[i].indexOf("x") == 0 && xs[i].length() == 1){
                xs[i] = xs[i].replace("x", "ecks");
            }
            else xs[i] = xs[i].replace("x", "cks");
        }
        return String.join(" ", xs);
    }
    //6 Учитывая массив целых чисел, верните наибольший разрыв
    // между отсортированными элементами массива.
    public static int largestGap (int[] mass){
        int max = 0;
        Arrays.sort(mass);
        for (int i = 0; i<mass.length-1; i++){
            if (mass[i+1]-mass[i]>max){
                max = mass[i+1]-mass[i];
            }
        }
        return max;
    }
    // 7 создать функцию, которая при подаче входных данных ниже
    // производит показанные примеры выходных данных
    public static int chislas(int ch){
        String s = String.valueOf(ch);
        int[] newMas = new int[s.length()];
        int count = 0;
        int ch1 = ch;
        while (count < s.length()){
            newMas[count] = ch1 % 10;
            ch1 /= 10;
            count += 1;
        }
        String res = "";
        Arrays.sort(newMas);
        for (int i = 0; i < newMas.length; i++){
            res += String.valueOf(newMas[i]);
        }
        return ch - Integer.parseInt(res);
    }
    //8 Создайте функцию, которая принимает предложение в качестве входных данных и возвращает наиболее
    // распространенную последнюю гласную в предложении в виде одной символьной строки.
    public static String commonLastVowel(String str) {
        int[] vowels = new int[6];
        int maxVowel = Integer.MIN_VALUE;
        str = str.toLowerCase();
        String[] words = str.split(" ");
        for (int i = words.length - 1; i > 0; i--) {
            for (int j = words[i].length() - 1; j > 0; j--) {
                if (words[i].charAt(j) == 'a') {
                    vowels[0]++;
                    break;
                }
                else if (words[i].charAt(j) == 'e') {
                    vowels[1]++;
                    break;
                }
                else if (words[i].charAt(j) == 'i') {
                    vowels[2]++;
                    break;
                }
                else if (words[i].charAt(j) == 'o') {
                    vowels[3]++;
                    break;
                }
                else if (words[i].charAt(j) == 'u') {
                    vowels[4]++;
                    break;
                }
                else if (words[i].charAt(j) == 'y') {
                    vowels[5]++;
                    break;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (vowels[i] > vowels[i+1]) maxVowel = i;
        }
        if (maxVowel == 0) return "a";
        else if (maxVowel == 1) return "e";
        else if (maxVowel == 2) return "i";
        else if (maxVowel == 3) return "o";
        else if (maxVowel == 4) return "u";
        else return "y";
    }
    //9 Для этой задачи забудьте, как сложить два числа вместе.
    // Лучшее объяснение того, что нужно сделать для этой функции, - это этот мем:
    public static double memeSum (int a, int b) {
        double sum = 0;
        int razr = 0;
        while (a > 0) {
            sum = sum + (a%10 + b%10)*(Math.pow(10, razr));
            if (sum>=10) razr += 2;
            a = a/10;
            b = b/10;
        }
        return sum;
    }
    //10 Создайте функцию, которая удалит все повторяющиеся символы в слове, переданном этой функции.
    // Не просто последовательные символы, а символы, повторяющиеся в любом месте строки.
    public static String unrepeated(String str) {
        int position = 1;
        char[] characters = str.toCharArray();
        for (int i = 1; i < str.length(); i++) {
            int j;
            // находим уже пройденную позицию
            for (j = 0; j < position; ++j) {
                if (characters[i] == characters[j]) {
                    break;
                }
            }
            // если это символ в этой же позиции, то идем к следующему символу
            if (j == position) {
                characters[position] = characters[i];
                ++position;
                // иначе заменяем его на шаблон 0 и переходим к следующему символу
            } else {
                characters[position] = 0;
                ++position;
            }
        }
        StringBuilder str3 = new StringBuilder(characters.length);
        for (char c :  characters) {
            if (c != 0) str3.append(c);
        }
        return str3.toString();
    }
}
