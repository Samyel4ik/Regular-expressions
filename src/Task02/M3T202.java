package Task02;

public class M3T202 {
    //Даны открывающиеся теги. Вывести в консоль их имена.
    public static void main(String[] args) {
        String text = "<head/><body/><child/><head/>";
        char[] array = text.toCharArray();

        boolean tagFound = false;
        String str = "";

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '<') {
                tagFound = true;
                continue;
            }
            if (array[i] == '/' && array[i+1] == '>') {
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

