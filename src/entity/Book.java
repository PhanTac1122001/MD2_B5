package entity;

import run.Main;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner scanner) {
        this.bookId = inputBookId(scanner);
        this.bookName = inputBookName(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.author = inputAuthor(scanner);
        this.year = inputYear(scanner);
    }

    public String inputBookId(Scanner scanner) {
        System.out.println("Nhập mã sách:");
        do {
            String bookId = scanner.nextLine();
            boolean isExist = false;
            for (int i = 0; i < Main.currIndex; i++) {
                if (Main.arrbook[i].getBookId().equals(bookId)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Mã sách đã tồn tại, vui lòng nhập lại");
            } else {

                return bookId;
            }
        } while (true);
    }

    public String inputBookName(Scanner scanner) {
        System.out.println("Nhập tên sách:");
        do {
            String bookName = scanner.nextLine();


            boolean isExist = false;
            for (int i = 0; i < Main.currIndex; i++) {
                if (Main.arrbook[i].getBookName().equals(bookName)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Tên sách tồn tại, vui lòng nhập lại");
            } else {
                return bookName;
            }


        } while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        System.out.println("Gíá nhập của sách:");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập của sách có giá trị lớn hơn 0,vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        System.out.println("Giá xuất của sách");
        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice >= importPrice * 1.3) {
                return exportPrice;
            } else {
                System.err.println("Giá xuất của sách có giá trị lớn hơn ít nhất 30% so với giá nhập, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputAuthor(Scanner scanner) {
        System.out.println(" Mời nhập tác giả:");
        do {
            String author = scanner.nextLine();
            if (author.length() > 6 && author.length() < 50) {
                return author;
            } else {
                System.err.println("Tác giả có từ 6-50 ký tự,vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputInterest() {
        this.interest = this.exportPrice - this.importPrice;
        return this.interest;
    }

    public int inputYear(Scanner scanner) {
        System.out.println("Mời nhập năm xuất bản");
        do {
            int year = Integer.parseInt(scanner.nextLine());
            if (year > 2000) {
                return year;
            } else {
                System.err.println("Ít nhất xuất bản sau năm 2000,vui lòng nhập lại");
            }
        } while (true);
    }

    public void displayData() {
        System.out.printf("\nMã sách: %s Tên sách: %s Giá nhập: %.1f Giá xuất: %.1f Tác giả: %s Năm xuất bản: %d\n",
                this.bookId,
                this.bookName,
                this.importPrice,
                this.exportPrice,
                this.author,
                this.year);
    }
}
