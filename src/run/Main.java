package run;

import entity.Book;

import java.util.Scanner;

public class Main {
    public static Book[] arrbook = new Book[100];
    public static int currIndex=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*******************Menu********************");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.println("Mời bạn chọn");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Main.inputListBook(sc);
                    break;
                case 2:
                    Main.inputListInterest(sc);
                    break;
                case 3:
                    Main.displayListBook(sc);
                    break;
                case 4:
                    Main.sortPriceBook();
                    Main.displayListBook(sc);
                    break;
                case 5:
                    Main.sortPriceInterest();
                    Main.displayListBook(sc);
                    break;
                case 6:
                    Main.searchPriceBook(sc);
                    break;
                case 7:
                    Main.countYear(sc);
                    break;
                case 8:
                    Main.countBookOfAuthor(sc);
                    break;
                case 9:
                    System.exit(0);
                    System.out.println("Thoát thành công");
                    break;
                default:
                    System.out.println("Mời bạn nhập lại từ 1-9");
                    break;


            }
        }while (true);
    }
   public static void inputListBook(Scanner sc) {
       System.out.println("Nhập số sách cần nhập thông tin:");
       int countOfBook= Integer.parseInt(sc.nextLine());
       for(int i=0;i<countOfBook;i++) {
           arrbook[currIndex]=new Book();
           arrbook[currIndex].inputData(sc);
           currIndex++;
       }
   }
   public static int getIndexById(String bookId){
       for (int i = 0; i < currIndex; i++) {
           if(arrbook[i].getBookId().equals(bookId)){
               return i;
           }
       }
       return -1;
   }
   public static  void displayListBook(Scanner sc) {
        if(currIndex==0){
            System.out.println("Chưa có sách nào trong hệ thống");
            return;
        }
       for (int i = 0; i < currIndex; i++) {
           arrbook[i].displayData();
       }
   }
   public static void  inputListInterest(Scanner sc) {
       if (currIndex == 0) {
           System.out.println("Chưa có sách nào trong hệ thống");
           return;
       }
       System.out.println("Nhập vào mã sách cần tính lợi nhuận:");
       String bookId=sc.nextLine();

       int indexInterest=getIndexById(bookId);
       if(indexInterest>=0) {
          for (int i = 0; i < currIndex; i++) {
              arrbook[i].inputInterest();
              System.out.println(arrbook[i].getBookName()+"Có lợi nhuận là: "+arrbook[i].getInterest());
          }

       }else {
           System.err.println("Mã sinh viên không tồn tại");
       }
   }
   public  static void sortPriceBook(){
    for (int i = 0; i < currIndex; i++) {
        for (int j = i+1; j < currIndex; j++) {
            if (arrbook[i].getExportPrice()<arrbook[j].getExportPrice()) {
                Book temp=arrbook[i];
                arrbook[i]=arrbook[j];
                arrbook[j]=temp;
            }
        }
    }

   }
   public static void sortPriceInterest(){
        for (int i = 0; i < currIndex; i++) {
            for (int j = i+1; j < currIndex; j++) {
                if (arrbook[i].getInterest()>arrbook[j].getInterest()) {
                    Book temp=arrbook[i];
                    arrbook[i]=arrbook[j];
                    arrbook[j]=temp;
                }
            }
        }

   }
    public static void searchPriceBook(Scanner sc){
        System.out.println("Nhập tên sách muốn tìm");
        String bookName = sc.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i < currIndex; i++) {
            if(arrbook[i].getBookName().toLowerCase().contains(bookName)){
                arrbook[i].displayData();
                count++;
            }
        }
        if(count == 0){
            System.out.println("Không tìm thấy sách bạn muốn tìm");
        }
    }
    public static void countYear(Scanner scanner){
        System.out.println("Nhập năm xuất bản");
        int year = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < currIndex; i++) {
            if(arrbook[i].getYear() == year){
                count++;
            }
        }
        System.out.printf("Co %d sách được xuất bản năm %d\n",count,year);
    }
    public static void countBookOfAuthor(Scanner scanner){
        System.out.println("Nhập tên tác giả");
        String author = scanner.nextLine();
        int count =0;
        for (int i =0; i<currIndex;i++){
            if(arrbook[i].getAuthor().equals(author)){
                count++;
            }
        }
        System.out.printf("tác giả %s có %d quyển sách\n",author,count);
    }
}
