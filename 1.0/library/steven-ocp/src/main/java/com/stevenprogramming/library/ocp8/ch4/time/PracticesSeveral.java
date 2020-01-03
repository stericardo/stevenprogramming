package com.stevenprogramming.library.ocp8.ch4.time;

import java.io.Serializable;
import java.time.Duration;
import java.time.Period;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author steven
 */
public class PracticesSeveral {

    transient int ti2 = 10;
    static int si2;

    static {
        si2 = 20;
    }

    public static void main(String[] args) {
        Consumer<Book> c = b -> {
            String details = b.getId() + ":" + b.getTitle();
            System.out.println(details);
        };
        Book book = new Book();
        book.setTitle("test");
        c.accept(book);
        System.out.println(c);

        Boo boo = new Boo();
        Boo.si++;
        boo.ti++;
        System.out.println(boo.ti + " " + boo.si);
        Duration d = Duration.ofDays(10);
        System.out.println(d);
        d = Duration.ofMinutes(0);
        System.out.println(d);
        Period p = Period.ofMonths(0);
        System.out.println(p);
        Map m;

    }

}

class Boo implements Serializable {

    transient int ti = 10;
    Thread h;
    static int si = 20;

    protected void switchOFF() {
    }
}

abstract class Switch {

    abstract void switchON();

    protected abstract void switchOFF();
}

class Book {

    private int id;
    private String title;
//constructors and accessors not shown

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
