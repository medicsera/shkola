import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class Visitor {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Book> favoriteBooks;
    private boolean subscribeToNewsletter;
}

@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private int yearOfPublication;
    private String ISBN;
    private String publisher;
}

@Data
public class SmsMessage {
    private String phoneNumber;
    private String message;
}

public class Library {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().create();
        Type visitorListType = new TypeToken<ArrayList<Visitor>>() {}.getType();
        List<Visitor> visitors = gson.fromJson(new FileReader("book.json"), visitorListType);

        // Задание 1
        System.out.println("Список посетителей:");
        visitors.forEach(visitor -> System.out.println(visitor.getFirstName() + " " + visitor.getLastName()));
        System.out.println("Количество посетителей: " + visitors.size());

        // Задание 2
        List<Book> allFavoriteBooks = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nСписок книг в избранном (без повторений):");
        allFavoriteBooks.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
        System.out.println("Количество книг в избранном: " + allFavoriteBooks.size());

        // Задание 3
        System.out.println("\nСписок книг, отсортированный по издателям:");
        allFavoriteBooks.stream()
                .sorted(Comparator.comparing(Book::getPublisher))
                .forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor() + " (Publisher: " + book.getPublisher() + ")"));

        // Задание 4
        boolean janeAustenBookFound = visitors.stream()
                .anyMatch(visitor -> visitor.getFavoriteBooks().stream()
                        .anyMatch(book -> book.getAuthor().equals("Jane Austen")));
        System.out.println("\nЕсть ли у кого-то в избранном книга автора \"Джейн Остин\": " + janeAustenBookFound);

        // Задание 5
        int maxFavoriteBooks = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .max()
                .getAsInt();
        System.out.println("\nНаибольшее количество добавленных в избранное книг: " + maxFavoriteBooks);

        // Задание 6
        double averageFavoriteBooks = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .average()
                .getAsDouble();

        List<SmsMessage> smsMessages = visitors.stream()
                .filter(Visitor::isSubscribeToNewsletter)
                .map(visitor -> {
                    int favoriteBookCount = visitor.getFavoriteBooks().size();
                    if (favoriteBookCount > averageFavoriteBooks) {
                        return new SmsMessage(visitor.getPhoneNumber(), "Вы книжный червь!");
                    } else if (favoriteBookCount < averageFavoriteBooks) {
                        return new SmsMessage(visitor.getPhoneNumber(), "Читать больше!");
                    } else {
                        return new SmsMessage(visitor.getPhoneNumber(), "Fine!");
                    }
                })
                .collect(Collectors.toList());

        System.out.println("\nSMS-сообщения для посетителей, подписанных на рассылку:");
        smsMessages.forEach(smsMessage -> System.out.println("Номер: " + smsMessage.getPhoneNumber() + ", Сообщение: " + smsMessage.getMessage()));
    }
}
