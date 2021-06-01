package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class task6 {
    public static void main(String[] args){
        /*1*/System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        /*2*/System.out.println(Arrays.toString(collect(new StringBuffer("pneumonoultramicroscopicsilicovolcanoconiosis"), 15)));
        /*3*/System.out.println(nicoCipher("andiloveherso", "tesha"));
        /*4*/System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        /*5*/System.out.println(isExact(24));
        /*6*/System.out.println(fractions("0.1097(3)"));
        /*7*/System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        /*8*/System.out.println(isValid("acccb"));
        /*9*/System.out.println(generateNonconsecutive(4));
        /*10*/System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5})));
    }
    //1 Создайте функцию, которая принимает две строки. Первая строка содержит предложение, содержащее буквы
    // второй строки в последовательной последовательности, но в другом порядке.
    public static String hiddenAnagram(String t, String p) {
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        p = p.toLowerCase().replaceAll(" ", "");

        for(int i = 0; i < t.length() - p.length() +1; i++){
            if(p.indexOf(t.charAt(i)) > -1){
                String subT = t.substring(i, i + p.length());
                if(isAnagram(subT, p)){ return subT;}
            }
        }
        return "noutfond";
    }
    private static Boolean isAnagram(String str1, String str2){
        StringBuilder s = new StringBuilder(str2);
        for(int i=0; i<str1.length(); i++){
            int in = s.indexOf(String.valueOf(str1.charAt(i)));
            if(in == -1){
                return false;
            }
            s.setCharAt(in, '-');
        }
        return true;
    }
    //2 Напишите функцию, которая возвращает массив строк,
    // заполненных из срезов символов n-длины данного слова
    public static String[] collect(StringBuffer text, int len){
        //если заданная строка меньше len, возвращаем 0
        if (text.length() <= len){
            return null;
        }
        //если длина текста нацело не делится на длину среза, удаляем лишние элементы

        if (text.length() % len > 0){
            int count = 0;
            count = text.length() / len * len;
            text.delete(count, text.length());
        }
        //создаем массив слов нужной длинны
        String[] collMas = new String[text.length() / len];
        int count = 0;
        for (int i = 0; i < text.length() / len; i++){
            collMas[i] = text.substring(count, count + len);
            count += len;
        }


        String allKey = "abcdefghijklmnopqrstuvwxyz";
        String[] res = new String[text.length() / len];
        count = 0;
        int j = 0;
        //упорядочиваем слова по алфавиту
        while (count < allKey.length()) {
            for (int i = 0; i < collMas.length; i++) {
                if (collMas[i].startsWith(String.valueOf(allKey.charAt(count)))) {
                    res[j] = collMas[i];
                    j += 1;
                }
            }
            count += 1;
        }
        return res;
    }
    //3 Создайте функцию, которая принимает два аргумента, message и key,
    // и возвращает закодированное сообщение.
    public static String nicoCipher(String message, String key){
        String allKey = "abcdefghijklmnopqrstuvwxyz";
        int[] keyMas = new int[key.length()];
        int[] newKey = new int[key.length()];
        String[] masMes = message.split("");
        String[][] shif = new String[newKey.length][(int) Math.ceil((double) message.length()/ (double) key.length())];
        //создаем массив цифр соответсвующих данной букве по алфавиту
        for (int i = 0; i < key.length(); i++){
            keyMas[i] = allKey.indexOf(key.charAt(i));

        }
        //создаем массив из упорядоченных маленьких чисел
        for (int j = 0; j < keyMas.length; j++) {
            int max = -1;
            int intMax = 0;
            for (int i = 0; i < keyMas.length; i++) {
                if (keyMas[i] > max) {
                    max = keyMas[i];
                    intMax = i;
                }
            }
            newKey[intMax] = keyMas.length - j;
            keyMas[intMax] = -1;
        }

        //назначаем каждой цифре соответствующие буквы
        int j = 0;
        int k = 0;
        for (int i = 0; i < masMes.length; i++){
            shif[j][k] = masMes[i];
            j += 1;
            if (j > newKey.length - 1){
                k += 1;
                j = 0;
            }
        }
        //массив упорядоченных маленьких чисел в строку
        String strNewKey = "";
        for (int g = 0; g < keyMas.length; g ++){
            strNewKey += String.valueOf(newKey[g]);
        }
        //новый упорядоченный массив цифр и значений
        String[][] res = new String[newKey.length][(int) Math.ceil((double) message.length()/ (double) key.length())];

        for (int i = 0; i < newKey.length; i ++){
            res[i] = shif[strNewKey.indexOf(String.valueOf(i+1))];
        }
        //заполняем упорядоченный массив пробелами чтобы не было пустых элементов
        int w = 0;
        int h = 0;

        for (int i = 0; i < newKey.length * shif[0].length; i++){
            if (res[w][h] == null){
                res[w][h] = " ";
            }
            w += 1;
            if (w > newKey.length-1){
                h += 1;
                w = 0;
            }
        }
        //записываем закодированный массив в строку
        String eMassage = "";
        int countW = 0;
        int countH = 0;
        for (int i = 0; i < newKey.length * res[0].length; i++){
            eMassage += res[countW][countH];
            countW += 1;
            if (countW > newKey.length-1){
                countH += 1;
                countW = 0;
            }
        }

        return eMassage;
    }
    //4 Создайте метод, который принимает массив arr и число n и возвращает
    // массив из двух целых чисел из arr, произведение которых равно числу n
    public static int[] twoProduct(int[] arr, int n){
        int [] res = new int[2];
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j ++){
                if (arr[i] * arr[j] == n && j < count){
                    res = new int[]{arr[i], arr[j]};
                    count = j;
                }
            }
        }
        return res;
    }
    //5 Создайте рекурсивную функцию, которая проверяет,
    // является ли число точной верхней границей факториала n
    public static String isExact(int ch){
        int nch = 1;
        int res = 0;
        for (int i = 1; nch < ch; i++){
            nch = nch * i;
            res = i;
            if (nch == ch){
                return Arrays.toString(new int[]{ch, res});
            }
        }
        return Arrays.toString(new int[]{});
    }
    //6 Создайте функцию, которая принимает десятичную дробь в строковой форме с повторяющейся частью в
    // круглых скобках и возвращает эквивалентную дробь в строковой форме и в наименьших членах
    public static String fractions(String decimalNum) {
        int commaIndex = decimalNum.indexOf('.');
        int openBracketIndex = decimalNum.indexOf('(');

        String integerPart = decimalNum.substring(0, commaIndex);
        String beforePeriodPart = decimalNum.substring(commaIndex + 1, openBracketIndex);
        String periodPart = decimalNum.substring(openBracketIndex + 1, decimalNum.length() - 1);
        String decimalPart = decimalNum
                .split("\\.")[1]
                .replaceAll("\\(", "")
                .replaceAll("\\)", "");

        int k = periodPart.length();
        int m = beforePeriodPart.length();

        int a = Integer.parseInt(decimalPart);
        int b = m != 0 ? Integer.parseInt(beforePeriodPart) : 0;

        String numerator = String.valueOf(a - b);
        String denominator = "9".repeat(k) + "0".repeat(m);
        return toCommonFraction(integerPart ,numerator + "/" + denominator);
    }

    private static String toCommonFraction(String integer, String fraction) {
        String numerator = fraction.split("/")[0];
        String denominator = fraction.split("/")[1];

        int integerNum = Integer.parseInt(integer);
        int numeratorNum = Integer.parseInt(numerator);
        int denominatorNum = Integer.parseInt(denominator);

        String newNumerator = String.valueOf(integerNum * denominatorNum + numeratorNum);
        return reduceFraction(newNumerator + "/" + denominatorNum);
    }

    private static String reduceFraction(String fraction) {
        int numeratorNum = Integer.parseInt(fraction.split("/")[0]);
        int denominatorNum = Integer.parseInt(fraction.split("/")[1]);

        int limit = Math.min(numeratorNum, denominatorNum);
        int divider = 2;

        while (divider < limit) {
            if (numeratorNum % divider == 0 && denominatorNum % divider == 0) {
                numeratorNum /= divider;
                denominatorNum /= divider;
            } else {
                divider++;
            }
        }

        return numeratorNum + "/" + denominatorNum;
    }
    //7 преобразуйте строку в серию слов (или последовательности символов), разделенных одним пробелом,
    //причем каждое слово имеет одинаковую длину, заданную первыми 15 цифрами десятичного представления числа Пи
    public static String pilish_string(String s) {
        int[] PI = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        String ans = "";
        int idx = 0;
        int l;
        String word;
        while(s.length() > 0 && idx < PI.length){
            l = PI[idx];
            if(s.length() >= l)
                word = s.substring(0, l);
            else
                word = s;
            while(word.length() < l)
                word += word.charAt(word.length() - 1);
            ans += " " + word;
            if(s.length() >= l)
                s = s.substring(l);
            else
                s = "";
            idx++;
        }
        return ans.trim();
    }
    //8 Создайте функцию для генерации всех непоследовательных двоичных строк, где непоследовательные
    // определяется как строка, в которой нет последовательных строк,
    // и где n определяет длину каждой двоичной строки.
    public static String generateNonconsecutive(int n) {
        int num = 0;
        String binaryString = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();

        while (binaryString.length() <= n) {
            if (!binaryString.contains("11")) {
                stringBuilder.append(resizeBinaryString(binaryString, n)).append(" ");
            }
            binaryString = Integer.toBinaryString(++num);
        }

        return stringBuilder.toString();
    }

    private static String resizeBinaryString(String binary, int n) {
        return "0".repeat(n - binary.length()) + binary;
    }
    //9 Шерлок считает строку действительной, если все символы строки встречаются одинаковое количество раз.
    // Также допустимо, если он может удалить только 1 символ из 1 индекса в строке, а остальные символы
    // будут встречаться одинаковое количество раз
    public static String isValid(String str) {
        Map<Character, Integer> counts = new HashMap<>();

        for (Character c: str.toCharArray()) {
            counts.put(c, counts.get(c) != null ? counts.get(c) + 1 : 1);
        }

        int firstValue = (int) counts.values().toArray()[0];
        List<Integer> otherValues = counts
                .values()
                .stream()
                .filter(x -> x != firstValue)
                .collect(Collectors.toList());

        return  otherValues.size() == 1 &&
                otherValues.get(0) - firstValue == 1 ? "YES" : "NO";
    }
    //10 Создайте функцию, которая получает каждую пару чисел из массива, который суммирует до восьми,
    // и возвращает его как массив пар (отсортированный по возрастанию).
    public static int[][] sumsUp(int[] ch){
        int count = 0;
        int[] prRes = new int[ch.length];
        //заполням одномерный массив парами чисел начиная с конца
        for (int i = ch.length-1; i >= 0; i--){
            for (int j = i-1; j >= 0; j --){
                if (ch[i] + ch[j] == 8){
                    prRes[count] =  Math.min(ch[i], ch[j]);
                    prRes[count+1] = Math.max(ch[i], ch[j]);
                    count += 2;
                }
            }
        }
        //заполняем двумерный массив парами в нужном порядке
        int[][] res = new int[count/2][2];
        int j = 0;
        for (int i = res.length-1; i >= 0; i--){
            res[i][0] = prRes[j];
            res[i][1] = prRes[j+1];
            j += 2;
        }
        return res;
    }
}
