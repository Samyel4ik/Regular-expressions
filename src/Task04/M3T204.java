package Task04;

public class M3T204 {
    //Даны теги с контентом. Вывести в консоль их контент.
    public static void main(String[] args) {
        String string = "<head>some string<head/><body>another string</body>";
        char[] array = string.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean contentFound = false;
        String str = "";

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '>') {
                contentFound = true;
                continue;
            }

            if (array[i] == '<') {
                contentFound = false;
            }

            if (contentFound) {
                str += array[i];
            }
        }
        result.append(str);
        System.out.println(result.toString());
    }
}
