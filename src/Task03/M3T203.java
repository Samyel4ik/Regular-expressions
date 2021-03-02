package Task03;

public class M3T203 {
    //Даны открывающиеся и закрывающиеся тэги. Вывести в консоль их имена и тип
    public static void main(String[] args) {
        String string = "<head><body/><child><head/>";
        char[] array = string.toCharArray();

        boolean tagFound = false;
        String str = "";

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '<') {
                tagFound = true;
                continue;
            }
            if (array[i] == '>' && array[i - 1] != '/') {
                System.out.println("открывающий тэг:" + str);
                str = "";
                tagFound = false;
            }
            if (array[i] == '/' && array[i + 1] == '>') {
                System.out.println("закрывающий тэг:" + str);
                str = "";
                tagFound = false;

            }
            if (tagFound) {
                str += array[i];
            }
        }
    }
}

