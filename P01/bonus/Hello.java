import java.util.Scanner;

public class Hello{
    public static void main(String[] args){

        System.out.println("Enter your name: ");
        Scanner in=new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Hello "+ name);
        
    }



}