package Task02;

public class M3T202 {
    //Даны открывающиеся теги. Вывести в консоль их имена.
    public static void main(String[] args) {
        String text = "<head/><body/><child/><head/>";
        StringBuilder result = new StringBuilder();
        char[] array = text.toCharArray();

        boolean tagFound = false;
        String str = "";

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '<') {
                tagFound = true;
                continue;
            }
            if (array[i] == '>') {
                tagFound = false;
                str += ",";
            }
            if (array[i] == '/') {
                tagFound = false;
            }
            if (tagFound) {
                str += array[i];
            }
        }
        result.append(str);
        System.out.println(result.toString());
    }
}

