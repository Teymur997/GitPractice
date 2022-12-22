import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class TextHandling {
    public static String[] TextReader() {
        System.out.println("Введите путь к файлу:");
        Scanner input = new Scanner(System.in);
        File txt = new File(String.valueOf(Path.of(input.next()).toAbsolutePath()));

        BufferedReader bfReader;
        String[] strings;
        try {
            bfReader = new BufferedReader(new FileReader(txt));
            strings = bfReader.lines().collect(Collectors.joining())
                    .replaceAll("-", " ")
                    .replaceAll("«", " ")
                    .replaceAll("»", " ")
                    .replaceAll("  ", ".")
                    .replaceAll("№", "")
                    .replaceAll("\\p{Punct}", "")
                    .replaceAll("\\d", " ")
                    .toLowerCase().split("\\s");
        } catch (IOException e) {
            System.out.println("Файл не найден! Укажите верный путь");
            throw new RuntimeException(e);
        }
        return strings;
    }
    public static void TextHandler(String[] strings) {
        if (strings != null) {
            double length = strings.length;
            TreeMap<String, Integer> vocabulary = new TreeMap<>();
            for (int i = 0; i < strings.length; i++) {
                if (!strings[i].isEmpty()) {
                    if (vocabulary.containsKey(strings[i])) {
                        vocabulary.replace(strings[i], vocabulary.get(strings[i]), vocabulary.get(strings[i])+1);
                    } else {
                        vocabulary.put(strings[i], 1);
                    }
                }
            }
            if (!vocabulary.isEmpty()) {
                System.out.println("Вывод слов, их количества и процентного содержания в тексте:");
                vocabulary.entrySet().stream().
                        map(s -> String.format("Слово: %s, Количество: %d,  Частота: %.2f%%",
                                s.getKey(), s.getValue(), s.getValue().doubleValue()*100L/length))
                        .forEach(System.out::println);

                System.out.println("\nВывод слов, чаще всего встречающихся в тексте:");
                vocabulary.entrySet().stream()
                        .filter(s -> s.getValue().equals(vocabulary.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue()))
                        .forEach(System.out::println);
            } else {
                System.out.println("Входящий массив не содержит слов!");
            }
        } else {
            System.out.println("Входящий массив строк пуст!");
        }
    }


    public static void main(String[] args) {
        TextHandler(TextReader());
    }
}
