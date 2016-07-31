package com.Java.Basics.ObjectOreineted.AccessModifiers.Abstract;

public class Employee extends Person {
     
    private int empId;
     
    public Employee(String nm, String gen, int id) {
        super(nm, gen);
        this.empId=id;
    }
 
    @Override
    public void work() {
        if(empId == 0){
            System.out.println("Not working");
        }else{
            System.out.println("Working as employee!!");
        }
    }
     
    public static void main(String args[]){
        //coding in terms of abstract classes
        Person student = new Employee("Dove","Female",0);
        Person employee = new Employee("Abraham","Male",123);
        student.work();
        employee.work();
        //using method implemented in abstract class - inheritance
        employee.changeName("Steve");
        System.out.println(employee.toString());
    }
 
}
