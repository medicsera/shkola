package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
class Visitor {
    String name;
    String lastName;
    String phoneNumber;
    List<Book> favoriteBooks;
    boolean subscribesToNewsletter;
}

@Data
@NoArgsConstructor
class Book {
    String title;
    String author;
    int publicationYear;
    String isbn;
    String publisher;
}

@Data
@AllArgsConstructor
class SmsMessage {
    String phoneNumber;
    String message;
}
class LibraryVisitors {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        List<Visitor> visitors = parseJson("C:\\Users\\anton\\IdeaProjects\\mirko\\shkola\\src\\main\\java\\org\\example\\books.json", gson);


        // Task 1: List of visitors and their count
        System.out.println("Visitors:");
        long visitorCount = visitors.stream().peek(System.out::println).count();
        System.out.println("Total visitors: " + visitorCount);
        System.out.println();


        // Task 2: List and count of unique books
        Set<Book> uniqueBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .collect(Collectors.toSet());
        System.out.println("Unique books:");
        uniqueBooks.forEach(System.out::println);
        System.out.println("Total unique books: " + uniqueBooks.size());
        System.out.println();


        // Task 3: Sorted list of books by publication year
        List<Book> sortedBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPublicationYear))
                .collect(Collectors.toList());
        System.out.println("Sorted books by publication year:");
        sortedBooks.forEach(System.out::println);
        System.out.println();


        // Task 4: Check for Jane Austen's book
        boolean janeAustenBookExists = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .anyMatch(b -> b.getAuthor().equals("Jane Austen"));
        System.out.println("Does anyone have a Jane Austen book? " + janeAustenBookExists);
        System.out.println();


        // Task 5: Maximum number of favorite books
        int maxFavoriteBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .max().orElse(0);
        System.out.println("Maximum number of favorite books: " + maxFavoriteBooks);
        System.out.println();


        // Task 6: SMS messages based on average favorite books
        double avgFavoriteBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .average().orElse(0);

        List<SmsMessage> smsMessages = visitors.stream()
                .filter(Visitor::isSubscribesToNewsletter)
                .map(v -> {
                    int bookCount = v.getFavoriteBooks().size();
                    String message = bookCount > avgFavoriteBooks ? "you are a bookworm" :
                            bookCount < avgFavoriteBooks ? "read more" : "fine";
                    return new SmsMessage(v.getPhoneNumber(), message);
                })
                .collect(Collectors.toList());

        System.out.println("SMS messages:");
        smsMessages.forEach(System.out::println);

    }


    // Helper function to parse the JSON file
    public static List<Visitor> parseJson(String filePath, Gson gson) {
        Type listType = new TypeToken<List<Visitor>>() {}.getType();
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list if there's an error
        }
    }
}