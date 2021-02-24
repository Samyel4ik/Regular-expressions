package Task1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Expression {
    //создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции:
    // отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
    // отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = scanner.toString();

        System.out.println("1.Отсортироват абзацы по колиичеству предложений:");
        System.out.println("2.В каждом предложении отсортирвать слова по длинне:");
        System.out.println("3.отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.");
        int method = scanner.nextInt();
        if (method==1){
            System.out.println(paragraph(text));
        }
        if (method==2){
            System.out.println(sortedText(text));
        }
        if (method==3){
            System.out.println("Введите значение символа:");

        }

    }

    //1.
    public static int sentence(String text) {                   // подсчет предложений в абзаце
        String sing = "!.?";
        char[] array = text.toCharArray();
        int t = 0;
        for (int i = 0; i < array.length; i++) {
            if (sing.contains(String.valueOf(array[i]))) ;
            t++;
        }
        return t;
    }

    // метод сортировки абзацев+
    public static String paragraph(String text) {               //  сортировка абзцев по кол предлож

        String[] paragraph = text.split("\n");
        int t = 0;
        while (t == 0) {
            t = 1;
            for (int i = 0; i < paragraph.length - 1; i++) {
                if (sentence(paragraph[i]) > sentence(paragraph[i + 1])) {
                    String zamena = paragraph[i];
                    paragraph[i] = paragraph[i + 1];
                    paragraph[i + 1] = zamena;
                    t = 0;
                }
            }
        }
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < paragraph.length; i++) {
            sorted.append(paragraph[i]).append("\n");
        }
        return sorted.toString();
    }

    //2.
    public static String sortedSentence(String text) {       // сортировка слов в предложении по количеству букв.
        char[] array = text.toCharArray();
        StringBuilder text_1 = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '\n') {                         // удаляем с текста все переносы
                text_1.append(array[i]);
            }
        }
        String text1 = text_1.toString();

        String[] arrayWords = text1.split(" ");
        int t = 0;
        while (t == 0) {
            t = 1;
            for (int i = 0; i < arrayWords.length - 1; i++) {
                if (arrayWords[i].length() > arrayWords[i + 1].length()) {
                    String zamena = arrayWords[i];
                    arrayWords[i] = arrayWords[i + 1];
                    arrayWords[i + 1] = zamena;
                    t = 0;
                }
            }

        }
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < arrayWords.length; i++) {
            sorted.append(arrayWords[i]).append(" ");
        }
        return sorted.toString();
    }

    // метод сортировки слов в предложении по длине каждого
    public static String sortedText(String text) {                   // сортировка каждого предложение и записываем его в новый стрингбилдер
        String[] breakOffer = text.split("\\.");                // разбиваем на предложения

        StringBuilder sortedText = new StringBuilder();

        for (int i = 0; i < breakOffer.length; i++) {
            sortedText.append(sortedSentence(breakOffer[i])).append(".").append("\n");         // сортируем предложение и вставляем в стрингбилдер

        }
        return sortedText.toString();
    }

    //  3.отсортировать слова по количеству заданаго символа , в предложении(по убыванию),елси символов одинаково по алфавиту.
    public static int numWord(String str, char x) {
        char[] array = str.toCharArray();
        int t = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                t++;
            }
        }
        return t;                                                                           //количество симолов в слове +
    }
    // метод сравнивания двух слов на первую букву в алфавите --


    public static String sortedSentenceWord(String text, char x) {                           //сортируем предложение по количуству символов в слове
        String[] arrayPredlozenie = text.split(" ");
        int t = 0;
        while (t == 0) {
            t = 1;
            for (int i = 0; i < arrayPredlozenie.length - 1; i++) {
                if (numWord(arrayPredlozenie[i], x) < numWord(arrayPredlozenie[i + 1], x)) {
                    String zamena = arrayPredlozenie[i];
                    arrayPredlozenie[i] = arrayPredlozenie[i + 1];
                    arrayPredlozenie[i + 1] = zamena;
                    t = 0;
                }
                if (numWord(arrayPredlozenie[i], x) == numWord(arrayPredlozenie[i + 1], x)) {
                    //сортировка слов по алфавиту

                }
            }
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arrayPredlozenie.length; i++) {
            result.append(arrayPredlozenie[i]).append(" ");
        }
        return result.toString();
    }

    public static String resultSortedText(String text, char x) {
        char[] array = text.toCharArray();
        StringBuilder text_1 = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '\n') {                         // удаляем с текста все переносы
                text_1.append(array[i]);
            }
        }
        String textNew = text_1.toString();

        String [] arrayNew = textNew.split("\\.");
        StringBuilder resultTextSorted = new StringBuilder();

        for (int i = 0; i < arrayNew.length; i++) {
            resultTextSorted.append(sortedSentenceWord(arrayNew[i],x)).append(".").append("\n");
        }
        return resultTextSorted.toString();
    }
}
