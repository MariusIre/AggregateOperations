package library;

public class Book {
    private String name;
    private String author;
    private String genre;
    private Boolean isLoaned;
    private Integer loanNumber;

    public Book(String name, String author, String genre, boolean isLoaned, int loanNumber) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isLoaned = isLoaned;
        this.loanNumber = loanNumber;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public Boolean getLoaned() {
        return isLoaned;
    }

    public Integer getLoanNumber() {
        return loanNumber;
    }

    public void setLoaned(Boolean loaned) {
        isLoaned = loaned;
    }

    public void setLoanNumber(Integer loanNumber) {
        this.loanNumber = loanNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isLoaned=" + isLoaned +
                ", loanNumber=" + loanNumber +
                '}';
    }
}
