package my.rnd.practice.trial;

import java.util.ArrayList;
import java.util.Collections;

public class ErrorTestClass 
    {
        public static void main(String [] args) 
        {
        	ErrorTestClass p = new ErrorTestClass();
            p.start();
            ArrayList<Person>  personList = new ArrayList<>();
            Collections.sort(personList, (p1, p2) -> p1.getSurName().compareTo(p2.getSurName()));
        }

        void start() 
        {
            String s1 = "sleep";
            String s2 = fix(s1);
            System.out.println(s1 + " " + s2);
        }

        String fix(String s1) 
        {
            s1 = s1 + "stream";
            System.out.print(s1 + " ");
            return "steem";
        }
    }

class Person {
	private String surName;
	public String getSurName( ) {
		return this.surName;
	}
}