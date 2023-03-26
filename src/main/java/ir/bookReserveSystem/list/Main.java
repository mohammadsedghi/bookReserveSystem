package ir.bookReserveSystem.list;

import ir.bookReserveSystem.service.AuthorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CreatePrintList createPrintList = new CreatePrintList();
        AuthorService authorService = new AuthorService();
        boolean program = true;
        int menu;
        while (program) {
            System.out.println("inter your menu number");
            System.out.println("menu: 1-create author");
            System.out.println("menu: 2-create book");
            System.out.println("menu: 3-sort author family");
            System.out.println("menu: 4-create print book of author with id ");
            System.out.println("menu: 5-print all of book from all author and their info ");
            System.out.println("menu: 6-EXIT");
            switch (menu = scanner.nextInt()) {
                case 1:
                    createPrintList.createAuthor();
                    break;
                case 2:
                    createPrintList.createBook();
                    break;

                case 3:
                    authorService.sortAuthorFamily();
                    break;

                case 4:
                    createPrintList.printAuthorBook(1);
                    break;

                case 5:
                    authorService.printAuthorInfo();
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}