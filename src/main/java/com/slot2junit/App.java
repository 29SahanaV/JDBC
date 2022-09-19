package com.slot2junit;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public int adding(int a,int b) {
    	return a+b;
    }
    
    public boolean checkEven(int n)     //to return boolean type 
    {
    	return n%2==0;
    }
    
    public int[] sortingofarray(int ar[])  //int[]=to return integer type of an array
    {
    	Arrays.sort(ar);
    	return ar;
    }
    
    
      public String wishme()
      {
    	return "Hello World";
    }

      public int divide(int a,int b)
      {
    	  return a/b;
      }
      
}
