package Task1;

import java.util.Scanner;

public class Expression {
    //создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции:
    // отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
    // отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("1.Отсортироват абзацы по колиичеству предложений:");
        System.out.println("2.В каждом предложении отсортирвать слова по длинне:");
        System.out.println("3.отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.");

        int method = scanner.nextInt();
        if (method == 1) {
            System.out.println(sortedTextBySentences(text));
        }
        if (method == 2) {
            System.out.println(sortedText(text));
        }
        if (method == 3) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите значение символа:");
            String y = scanner1.nextLine();
            char x = y.charAt(0);

            System.out.println(resultSortedText(text, x));
        }

    }

    //1.
    public static int numOfSentences(String text) {                   // подсчет предложений в абзаце
        String sing = "!.?";
        char[] array = text.toCharArray();
        int t = 0;
        for (int i = 0; i < array.length; i++) {
            if (sing.contains(String.valueOf(array[i]))) ;
            t++;
        }
        return t;
    }

    public static String[] splitByParagraphs(String text) {                 //делим текст на абзацы.
        String[] paragraph = text.split("\n");
        return paragraph;
    }

    public static String[] sortByNumOfWords(String[] paragraph) {      //  сортировка абзцев по кол предлож

        boolean arraySorted = false;
        while (!arraySorted) {
            arraySorted = true;

            for (int i = 0; i < paragraph.length - 1; i++) {
                if (numOfSentences(paragraph[i]) > numOfSentences(paragraph[i + 1])) {
                    String zamena = paragraph[i];
                    paragraph[i] = paragraph[i + 1];
                    paragraph[i + 1] = zamena;
                    arraySorted = false;
                }
            }
        }
        return paragraph;
    }

    public static String sortedTextBySentences(String text) {
        String[] paragraph = splitByParagraphs(text);
        String[] sortedParagraph = sortByNumOfWords(paragraph);

        StringBuilder sorted = new StringBuilder();                     // перезаписываем
        for (int i = 0; i < sortedParagraph.length; i++) {
            sorted.append(paragraph[i]).append("\n");
        }
        return sorted.toString();

    }

    //2.
    public static String[] divideIntoWords(String text) {       // сортировка слов в предложении по количеству букв.
        String text1 = text.replace("\n", "");// удаляем с предложения все переносы
        String[] array = text1.split(" ");              // разделяем  предложение на слова
        return array;
    }

    public static String[] sortingWords(String[] array) {           //в предложении произвели сортировку

        boolean arraySorted = false;
        while (!arraySorted) {
            arraySorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].length() > array[i + 1].length()) {
                    String zamena = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = zamena;
                    arraySorted = false;
                }
            }
        }
        return array;
    }
    public static String line (String []arrayWords) {
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < arrayWords.length; i++) {
            sorted.append(arrayWords[i]).append(" ");
        }
        return sorted.toString();
    }

    public static String sortedText(String text) {
        String[]weDivideIntoSentences= text.split("\\.");                                // разбиваем на предложения
        StringBuilder sortedSentenceResult = new StringBuilder();

        for (int i = 0; i < weDivideIntoSentences.length; i++) {                                // взяли предложение
            String [] divideIntoWords = divideIntoWords(weDivideIntoSentences[i]);              // убрали лишнее и разбили на слова
            String []sortingWords = sortingWords(divideIntoWords);                               // сорт слова в предложении

            sortedSentenceResult.append(line(sortingWords)).append(".").append("\n");
        }
        return sortedSentenceResult.toString();
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
        boolean arraySorted = false;
        while (!arraySorted) {
            arraySorted = true;

            for (int i = 0; i < arrayPredlozenie.length - 1; i++) {
                if (numWord(arrayPredlozenie[i], x) < numWord(arrayPredlozenie[i + 1], x)) {
                    String zamena = arrayPredlozenie[i];
                    arrayPredlozenie[i] = arrayPredlozenie[i + 1];
                    arrayPredlozenie[i + 1] = zamena;
                    arraySorted = false;
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
        String textNew = text.replace("\n", "");

        String[] arrayNew = textNew.split("\\.");
        StringBuilder resultTextSorted = new StringBuilder();

        for (int i = 0; i < arrayNew.length; i++) {
            resultTextSorted.append(sortedSentenceWord(arrayNew[i], x)).append(".").append("\n");
        }
        return resultTextSorted.toString();
    }
}
