package Task1;

import java.util.Scanner;

//import java sdasdsaaaaa.utail saad.Scanners ssaad.
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
            System.out.println(sortByNumOfSentences(text));
        }
        if (method == 2) {
            System.out.println(sortWordsInTextByLength(text));
        }
        if (method == 3) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите значение символа:");
            String y = scanner1.nextLine();
            char x = y.charAt(0);

            System.out.println(sortWordsInTextByNumberOfCharacters(text, x));
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

    //делим текст на абзацы.
    public static String[] splitByParagraphs(String text) {
        return text.split("\n");
    }

    //  сортировка абзцев по кол предлож
    public static String[] sortByNumOfWords(String[] paragraph) {

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

    public static String sortByNumOfSentences(String text) {
        String[] paragraphs = splitByParagraphs(text);
        String[] sortedParagraphs = sortByNumOfWords(paragraphs);

        return buildParagraph(sortedParagraphs);
    }

    //2.
    public static String[] divideIntoSentencesM(String text) {
        String[] array = text.split("\\.");                   // разделяем на предложения
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

    public static String buildText(String[] str) {
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sorted.append(str[i]).append("\n");
        }
        return sorted.toString();
    }

    public static String buildParagraph(String[] text) {
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            sorted.append(text[i]).append(".");
        }
        return sorted.toString();
    }

    static String sortWordsInTextByLength(String text) {
        String[] paragraphs = splitByParagraphs(text);
        String[] sortedParagraphs = sortWordsInParagraphsByLength(paragraphs);

        return buildText(sortedParagraphs);
    }

    static String[] sortWordsInParagraphsByLength(String[] paragraphs) {
        String[] result = new String[paragraphs.length];
        for (int i = 0; i < paragraphs.length; i++) {
            String[] sentences = divideIntoSentencesM(paragraphs[i]);
            String[] sortedSentences = sortWordsInSentencesByLength(sentences);

            result[i] = buildParagraph(sortedSentences);
        }

        return result;
    }

    static String[] sortWordsInSentencesByLength(String[] sentences) {
        String[] result = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            String[] words = divideIntoWords(sentences[i]);
            String[] sortedWords = sortingWords(words);

            result[i] = buildSentence(sortedWords);
        }

        return result;
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

    public static String[] sortWordsInSentencesByNumberOfCharacters(String[] sentences, char x) {
        String[] result = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            String[] words = divideIntoWords(sentences[i]);
            String[] sortedWords = sortedSentenceWord(words, x);
            result[i] = buildSentence(sortedWords);
        }
        return result;
    }

    static String[] sortWordsInParagraphsByNumberOfCharacters(String[] paragraphs, char x) {
        String[] result = new String[paragraphs.length];
        for (int i = 0; i < paragraphs.length; i++) {
            String[] sentences = divideIntoSentencesM(paragraphs[i]);
            String[] sortedSentences = sortWordsInSentencesByNumberOfCharacters(sentences, x);

            result[i] = buildParagraph(sortedSentences);
        }

        return result;
    }

    static String sortWordsInTextByNumberOfCharacters(String text, char x) {
        String[] paragraphs = splitByParagraphs(text);
        String[] sortedParagraphs = sortWordsInParagraphsByNumberOfCharacters(paragraphs, x);

        return buildText(sortedParagraphs);
    }
}
