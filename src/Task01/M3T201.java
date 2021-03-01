package Task01;

public class M3T201 {
    //Даны открывающиеся теги. Вывести в консоль их имена.
    public static void main(String[] args) {
        String text = " <head><body><child><head>";

        System.out.println(result(text));
    }

    public static String[] splitBySymbol(String text) { //разделяем по символу ">"
        return text.split(">");
    }

    public static String removeTheSymbol(String text1 ) {    //удаляем символ "<"
    char [] array = text1.toCharArray();
    StringBuilder withoutSymbol = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i]!='<'){
                withoutSymbol.append(array[i]);
            }
        }
        return withoutSymbol.toString();
    }

    public static String result (String text) {
        String [] splitBySymbol = splitBySymbol(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < splitBySymbol.length; i++) {
           String removeTheSymbol = removeTheSymbol(splitBySymbol[i]);
            result.append(removeTheSymbol).append(",");
        }
        return result.toString();
    }
}
