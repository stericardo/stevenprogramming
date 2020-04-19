package com.stevenprogramming.ocp11.stream;

import java.util.Objects;

public class Dog implements Comparable<Dog> {

    private String name;
    private int age;
    private int weight;

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String toString() {
        return "Name= " + this.name + " Age= " + this.age + " weight= " + this.weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getName2() {
        return this.name + "$";
    }

    @Override
    public int compareTo(Dog dog) {
        return this.weight > dog.getWeight() ? 1 : this.weight == dog.getWeight() ? 0 : -1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) age;
        hash = 31 * hash + (int) weight;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dog other = (Dog) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
