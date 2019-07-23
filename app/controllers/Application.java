package controllers;

import models.Customer;
import play.*;
import play.data.validation.Validation;
import play.mvc.*;

import java.util.*;



public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void sayHello(String myName){
        if (Validation.hasErrors()){
            flash.error("Oops, please enter your name!");
            index();
        }
        render(myName);
    }
    public static void addCustomer(){
        Customer customer = new Customer(1613,"zhang,","969177324@qq.com",19);
        customer.save();
        render(customer);
    }
    public static void allCustomer(){
        List<Customer> customer = Customer.findAll();
        render(customer);
    }
}