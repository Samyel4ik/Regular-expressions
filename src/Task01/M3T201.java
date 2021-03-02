package Task01;

public class M3T201 {
    //Даны открывающиеся теги. Вывести в консоль их имена.
    public static void main(String[] args) {
        String text = "<head><body><child><head>";
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
                System.out.print(str + ",");
                str = "";
            }
            if (tagFound) {
                str += array[i];
            }
        }
    }
}
