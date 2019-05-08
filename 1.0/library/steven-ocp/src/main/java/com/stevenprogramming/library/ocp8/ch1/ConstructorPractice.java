package com.stevenprogramming.library.ocp8.ch1;

/**
 *
 * @author steven mendez
 */
public class ConstructorPractice {

    void useLocalClass() {
        


     class LocalClass {

         void print() {
            System.out.println("local");
        }
    }
     
     new LocalClass().print();
}
public static void main(String[] args) {
        
       
                
        new PlayerCharacterName2("Bill");
        new PlayerCharacterName2("Bill", "");
        String list = "6386 SE--6380--6376--4284--4280--4274 HE";
        String result = list.replaceAll("[647]","8" );
        System.out.println(list);
        System.out.println(result);
        
    

}
}

class CharacterName2 {

    public CharacterName2(String g) {
        System.out.println("Here CharacterName2");
    }

    public CharacterName2() {
        System.out.println("Here CharacterName2");
    }
}

class PlayerCharacterName2 extends CharacterName2 {

    public PlayerCharacterName2(String f) {
        //super();
        System.out.println("Here PlayerCharacterName2");
    }

    public PlayerCharacterName2(String f, String f2) {
        //super(f);
        System.out.println("Here PlayerCharacterName2");
    }
}

class CharacterName {

    private String givenName, surname;

    private CharacterName(String givenName) {
        this.givenName = givenName;
        printName();
    }

    protected CharacterName(String givenName, String surname) {
        this(givenName);
        this.surname = surname;
        printName();
    }

    protected void printName() {
        System.out.println(givenName + " " + surname);
    }
}

class PlayerCharacterName extends CharacterName {

    private String playerName;

    public PlayerCharacterName(String playerName) {
        super(playerName, playerName);
    }

    public PlayerCharacterName(String playerName, String givenName, String surname) {
        super(playerName, playerName);
        this.playerName = playerName;
        printName();
    }

    public static void main(String[] args) {
        new PlayerCharacterName("Bill", "Ash", "Williams");
    }
}
