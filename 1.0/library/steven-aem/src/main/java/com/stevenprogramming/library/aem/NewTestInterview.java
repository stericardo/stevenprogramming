package com.stevenprogramming.library.aem;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author steven.mendez
 * @since Oct 19 2017
 * @version 1.0
 */
public class NewTestInterview {

    private String brand;
    
    public NewTestInterview(String brand) {
        this.brand = brand;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        NewTestInterview car = (NewTestInterview) o;
        
        return !(brand != null ? !brand.equals(car.brand) : car.brand != null);
    }
    
    @Override
    public int hashCode() {
        return (int) (2 * 5000);
    }
    
    public static void main(String[] args) {
        Set<NewTestInterview> cars = new HashSet<>();
        cars.add(new NewTestInterview("Alfa Romeo"));
        
        System.out.printf("Do you have an 'Alfa Romeo' car? %b\n", cars.contains(new NewTestInterview("Alfa Romeo")));
    }
  

}
