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
            System.out.println(createText(text));
        }
        if (method == 2) {
            System.out.println(sortedTextByWordsInSentences(text));
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
        return text.split("\n");
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

    public static String[] sortedTextBySentences(String text) {
        String[] paragraph = splitByParagraphs(text);
        return sortByNumOfWords(paragraph);
    }

    public static String createText(String text) {
        String[] sortedParagraph = sortedTextBySentences(text);

        StringBuilder sorted = new StringBuilder();                     // перезаписываем
        for (int i = 0; i < sortedParagraph.length; i++) {
            sorted.append(sortedParagraph[i]).append("\n");
        }
        return sorted.toString();

    }


    //2.
    public static String[] divideIntoParagraphs(String text) {
        String[] array = text.split("\n");                 //разделяем текст на абзацы
        return array;
    }

    public static String[] divideIntoSentencesM(String text) {
        String[] array = text.split(".");                   // разделяем на предложения
        return array;
    }

    public static String[] divideIntoWords(String text) {
        String[] arrayWord = text.split(" ");                  // разделяем  предложение на слова
        return arrayWord;
    }

    public static String[] sortingWords(String[] arrayWord) {           //в предложении произвели сортировку

        boolean arraySorted = false;
        while (!arraySorted) {
            arraySorted = true;
            for (int i = 0; i < arrayWord.length - 1; i++) {
                if (arrayWord[i].length() > arrayWord[i + 1].length()) {
                    String zamena = arrayWord[i];
                    arrayWord[i] = arrayWord[i + 1];
                    arrayWord[i + 1] = zamena;
                    arraySorted = false;
                }
            }
        }
        return arrayWord;
    }

    public static String buildSentence(String[] arrayWords) {
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < arrayWords.length; i++) {
            sorted.append(arrayWords[i]).append(" ");
        }
        return sorted.toString();
    }

    public static String sortedTextByWordsInSentences(String text) {
        String[] divideIntoParagraphs = divideIntoParagraphs(text);                                // разбиваем на aбзацы

        StringBuilder sortParagraphByWordLength = new StringBuilder();
        StringBuilder sortedTextByWordsInSentences = new StringBuilder();

        for (int i = 0; i < divideIntoParagraphs.length; i++) {
            String[] divideIntoSentencesM = divideIntoSentencesM(divideIntoParagraphs[i]);                      // разбиваем абзац на предложения
            String[] divideIntoWords = divideIntoWords(String.valueOf(divideIntoSentencesM));                  // разбиваем предложение  на слова
            String[] sortingWords = sortingWords(divideIntoWords);                                           // отсортировали слова  в предлож
            String buildSentence = buildSentence(sortingWords);                                              // собрали предложение
            String textResult = sortParagraphByWordLength.append(buildSentence).append(".").toString();     //собрали абзац
            sortedTextByWordsInSentences.append(textResult).append("\n");
        }
        return sortedTextByWordsInSentences.toString();
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

    public static String[] sortedSentenceWord(String[] arrayWords, char x) {               //сортируем предложение по количуству символов в слове
        boolean arraySorted = false;
        while (!arraySorted) {
            arraySorted = true;

            for (int i = 0; i < arrayWords.length - 1; i++) {
                if (numWord(arrayWords[i], x) < numWord(arrayWords[i + 1], x)) {
                    String zamena = arrayWords[i];
                    arrayWords[i] = arrayWords[i + 1];
                    arrayWords[i + 1] = zamena;
                    arraySorted = false;
                }
            }
        }
        return arrayWords;
    }

    public static String sortedSentence(String[] arrayWords) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arrayWords.length; i++) {
            result.append(arrayWords[i]).append(" ");
        }
        return result.toString();
    }

    public static String resultSortedText(String text, char x) {
        String[] arrayParagraph = divideIntoParagraphs(text);                               //абзац
        StringBuilder result1 = new StringBuilder();
        StringBuilder resultTextSorted = new StringBuilder();

        for (int i = 0; i < arrayParagraph.length; i++) {
            String[] divideIntoSentencesM = divideIntoSentencesM(arrayParagraph[i]);       //предложение
            String[] divideIntoWords = divideIntoWords(String.valueOf(divideIntoSentencesM)); // слово
            String[] sortedSentenceWord = sortedSentenceWord(divideIntoWords, x);            // сортировка
            String sortedSentence = sortedSentence(sortedSentenceWord);                      //склеили предложение
            String text1 = result1.append(sortedSentence).append(".").toString();
            resultTextSorted.append(text1).append("\n");
        }

        return resultTextSorted.toString();
    }
}
