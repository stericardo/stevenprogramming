package com.stevenprogramming.ocp11.stream;

import java.util.*;

public class MapLambdaSnap {

    public static final Set<String> HIGH_RISK_SET = new HashSet<>(Arrays.asList("HIGH"));
    private static  Map<Set<String>, AvailableUsersByStatusHandler> commandsUsersByStatusMap;

    public static void main(String[] args){
        MapLambdaSnap mapLambdaSnap = new MapLambdaSnap();
        mapLambdaSnap.mapLambdaValueTest();
        mapLambdaSnap.testDefault();
    }





    public void testDefault(){
        List<Book> books = List.of(
                new Book("Gone with the wind", "Fiction"),
                new Book("Bourne Ultimatum", "Thriller"),
                new Book("The Client", "Thriller")
        );
        Reader r = b->{
            System.out.println("Reading book "+b.getTitle());
        };
        books.forEach(x->r.read(x));

    }

    public void mapLambdaValueTest(){
        this.commandsUsersByStatusMap = new HashMap<>();
        // High Risk
        this.commandsUsersByStatusMap.put(
                HIGH_RISK_SET,
                (status, users, token) -> {
                    addUsersByStatus(status, users, token);
                });
    }




    private static  void addUsersByStatus(String status, List<UserSalesRepDto> totalUsers, String token) {
        List<UserSalesRepDto> users = getUserSalesRep(status, token);
        totalUsers.addAll(users);
    }

    private static List<UserSalesRepDto> getUserSalesRep(String status,String token){
        List<UserSalesRepDto> users = new ArrayList<>();
        users.add(new UserSalesRepDto());
        return users;
    }


    @FunctionalInterface
    public interface AvailableUsersByStatusHandler {
        void handleUsersByStatus(String status, List<UserSalesRepDto> users, String token);
    }

    static class UserSalesRepDto {
        public String name = "Steven";
    }

    class Book {
        private String title;
        private String genre;
        public Book(String title, String genre){
            this.setTitle(title); this.setGenre(genre);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }
        //accessors not shown
    }

    interface Reader{
        default void read(Book b){
            System.out.println("Default Reading book "+b.getTitle());

        }
        void unread(Book b);
    }

}
