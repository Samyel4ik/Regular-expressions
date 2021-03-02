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

        tagContent(characterArray(xml)); // вывод контента тега
        tagName(characterArray(ss)); // вывод название тегов!
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
    public static void tagName(char[] array) {
        String timeString = "";
        int x = 0;
        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '<' || array[i] == '/') {
                flag = true;
                continue;
            }
            if (array[i - 1 - x] != '/' && array[i] == '>') {
                System.out.println("Открывающий тег:" + timeString);
                timeString = "";
                x = 0;
                flag = false;
            }
            if (array[i] == '>' && array[i - x - 1] == '/') {
                System.out.println("Закрывающий тег:" + timeString);
                timeString = "";
                x = 0;
                flag = false;
            }
            if (flag) {
                x++;
                timeString += array[i];
            }
        }
    }

    // контент тега
    public static void tagContent(char[] array) {
        String timeString = "";
        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '>') {
                flag = true;
                continue;
            }
            if (array[i] == '<' && array[i + 1] != '/') {
                timeString = "";
                flag = false;
            }

            if (array[i] == '<' && array[i + 1] == '/') {
                System.out.println(timeString);
                timeString = "";
                flag = false;
            }
            if (flag) {
                timeString += array[i];
            }
        }

    }
}
