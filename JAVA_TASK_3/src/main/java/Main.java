import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static String get(String s) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(s).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static void main(String[] args) throws IOException, ParseException {
        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\teymu\\IdeaProjects\\JAVA_TASK_3\\src\\main\\java\\JSON")));
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(get(data));
        Companies companies = mapper.readValue(get(data), Companies.class);

        System.out.println("Задание №1");
        companies.getCompanies().stream()
                .map(s -> s.getName().substring(0, 3) + " - " + convertToLocalDate(s.getFounded())
                        .format(DateTimeFormatter.ofPattern("dd/MM/yy")))
                .forEach(System.out::println);


        System.out.println("Задание №2");
        LocalDate date = LocalDate.now();
        System.out.println("Акции, просроченные на текущий день: " + companies.getCompanies().stream()
                .map(a -> "\n" + "Компания-владелец: " + a.getName() + a.getSecurities().stream()
                        .filter(g -> convertToLocalDate(g.getDate()).isBefore(date))
                        .map(d -> "\n" + "Акция компании: " + d.getName() + ", Код: " + d.getCode() + ", Дата истечения: " + convertToLocalDate(d.getDate()).
                                format(DateTimeFormatter.ofPattern("dd/MM/yy"))).toList()).toList().toString()
        );

        System.out.println("\nОбщее количество просроченных акций: " + companies.getCompanies().stream().map(Company::getSecurities)
                .flatMap(Collection::stream)
                .filter(g -> convertToLocalDate(g.getDate()).isBefore(date))
                .map(d -> d.getName() + " " + convertToLocalDate(d.getDate()).format(DateTimeFormatter.ofPattern("dd/MM/yy")))
                .count());

        System.out.println("Задание №3");
        Scanner dateInput = new Scanner(System.in);
        Date inputDate = null;
        List<SimpleDateFormat> formats = Arrays.asList(new SimpleDateFormat("dd.MM.yyyy"),
                new SimpleDateFormat("dd.MM.yy"), new SimpleDateFormat("dd/MM/yyyy"), new SimpleDateFormat("dd/MM/yy"));
        String cdate = dateInput.nextLine();

        if (cdate != null && cdate.trim().length() > 0) {
            if (cdate.contains("/") && cdate.length()==10) {
                inputDate = formats.get(2).parse(cdate);
            } else if (cdate.contains("/") && cdate.length()==8) {
                inputDate = formats.get(3).parse(cdate);
            }
            if (cdate.contains(".") && cdate.length()==10) {
                inputDate = formats.get(0).parse(cdate);
            } else if (cdate.contains(".") && cdate.length()==8) {
                inputDate = formats.get(1).parse(cdate);
            }
        }
        LocalDate inputLocalDate = convertToLocalDate(inputDate);

        companies.getCompanies().stream()
                .filter(a -> convertToLocalDate(a.getFounded()).isAfter(inputLocalDate))
                .map(s -> "Название компании: " + s.getName() + "   Дата создания: " + convertToLocalDate(s.getFounded()).format(DateTimeFormatter.ofPattern("dd/MM/yy")))
                .forEach(System.out::println);

        System.out.println("Задание №4");
        System.out.println("Введите одну из валют (EU, USD, RUB):");
        Scanner input = new Scanner(System.in);
        String currency = input.nextLine().toUpperCase();
        switch (String.valueOf(input)) {
            case "EU":
                currency = "EU";
            case "RUB":
                currency = "RUB";
            case "USD":
                currency = "USD";
        }
        String finalCurrency = currency;

        companies.getCompanies().stream()
                .map(s -> "\n" + "id Компании-владельца: " + s.getId() + " " +
                        s.getSecurities().stream()
                                .filter(f -> f.getCurrency().contains(finalCurrency))
                                .map(f -> "\n" + "Код акции: " + f.getCode()).toList()).toList()
                .forEach(System.out::println);
    }
}
