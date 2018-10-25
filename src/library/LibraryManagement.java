package library;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryManagement {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Romeo and Juliet", "William Shakespeare", "Romance", true, 4));
        bookList.add(new Book("Hamlet", "William Shakespeare", "Drama", false, 100));
        bookList.add(new Book("Macbeth", "William Shakespeare", "Thriller", true, 15));
        bookList.add(new Book("The Tempest", "William Shakespeare", "Horror", false, 1));
        bookList.add(new Book("Othello", "William Shakespeare", "Romance", true, 111));
        bookList.add(new Book("King Lear", "William Shakespeare", "Drama", false, 100));
        bookList.add(new Book("Julius Caesar", "William Shakespeare", "History", true, 0));
        bookList.add(new Book("A Midsummer Night's Dream", "William Shakespeare", "Adventure", false, 1));

        bookList.stream().forEach(book -> System.out.println(book.toString()));

        Comparator<Book> compareLoanNumber = (bookOne, bookTwo) -> {
            if (bookOne.getLoanNumber() == bookTwo.getLoanNumber()) {
                return 0;
            }
            if (bookOne.getLoanNumber() > bookTwo.getLoanNumber()) {
                return 1;
            }
            return -1;
        };

        //Calculate the average,min,max and sum of the number of times the books have been loaned using streams
        List<Integer> numberOfLoans = bookList.stream()
                                                .map(Book::getLoanNumber)
                                                .collect(Collectors.toList());

        IntSummaryStatistics statisticsOfBooks = numberOfLoans.stream().collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Average number of loans: " + statisticsOfBooks.getAverage());
        System.out.println("Minimum number of loans: " + statisticsOfBooks.getMin());
        System.out.println("Maximum number of loans: " + statisticsOfBooks.getMax());
        System.out.println("Sum of number of loans: " + statisticsOfBooks.getSum());

        averageLoanByAuthorAndGenre(bookList);
    }

    public static void averageLoanByAuthorAndGenre(List<Book> bookList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert author:");
        String author = scan.nextLine();
        System.out.println("Insert genre:");
        String genre = scan.nextLine();
        Predicate<Book> authorAndGenreFilter = book -> book.getAuthor().equalsIgnoreCase(author)
                                                    && book.getGenre().equalsIgnoreCase(genre);

        IntSummaryStatistics statsOfBooksByAuthorAndGenre = bookList.stream()
                                                                    .filter(authorAndGenreFilter)
                                                                    .collect(Collectors.summarizingInt(Book::getLoanNumber));

        System.out.println("Average loans of " + author + " on " + genre + " is " + statsOfBooksByAuthorAndGenre.getAverage());
    }
}
