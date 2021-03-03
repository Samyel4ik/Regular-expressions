package Task2;

public class Expression {
    public static void main(String[] args) {
        String xml = "<notes>\n" +
                "\n" +
                "    <note id = \"1\">\n" +
                "\n" +
                "        <to>Вася</to>\n" +
                "\n" +
                "        <from>Света</from>\n" +
                "\n" +
                "        <heading>Напоминание</heading>\n" +
                "\n" +
                "        <body>Позвони мне завтра!</body>\n" +
                "\n" +
                "    </note>\n" +
                "\n" +
                "    <note id = \"2\">\n" +
                "\n" +
                "        <to>Петя</to>\n" +
                "\n" +
                "        <from>Маша</from>\n" +
                "\n" +
                "        <heading>Важное напоминание</heading>\n" +
                "\n" +
                "        </body>\n" +
                "\n" +
                "    </note>\n" +
                "\n" +
                "</notes>";

        String ss = lineWithoutHyphenation(characterArray(xml));
        result(characterArray(ss)); // вывод контента

    }

    //разделяем весь файл на массив символов
    public static char[] characterArray(String xml) {
        return xml.toCharArray();
    }

    //удаляем все переносы и лишние пробелы
    public static String lineWithoutHyphenation(char[] array) {
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] != '\n' && array[i] != ' ') {
                text.append(array[i]);
            }
        }
        return text.toString();
    }

    //какой тег и его название
    public static void result(char[] array) {
        String tagName = "";
        String content = "";
        boolean openingTagFound = false;
        boolean contentFound = false;
        boolean endTagFound = false;

        for (int i = 0; i < array.length; i++) {
            // открывающий тег
            if (array[i] == '<' && array[i + 1] != '/') {
                openingTagFound = true;
                continue;
            }
            if (array[i] == '>' && openingTagFound == true) {
                System.out.println("Открывающий тег:" + tagName);
                tagName = "";
                openingTagFound = false;
            }
            if (openingTagFound) {
                tagName += array[i];
            }
            // закрывающий тег
            if (array[i] == '/' && array[i - 1] == '<') {
                endTagFound = true;
                continue;
            }
            if (array[i] == '>' && endTagFound == true) {
                System.out.println("Закрывающий тег:" + tagName);
                tagName = "";
                endTagFound = false;
            }
            if (endTagFound) {
                tagName += array[i];
            }
            //контент тега
            if (array[i] == '>') {
                contentFound = true;
                continue;
            }
            if (array[i] == '<' && array[i + 1] == '/' && content.length() > 0) {
                System.out.println("Контент тега " + tagName + " " + content);
                content = "";
                contentFound = false;
            }
            if (contentFound) {
                content += array[i];
            }
        }
    }
}
