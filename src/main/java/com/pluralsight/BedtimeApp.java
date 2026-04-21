package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeApp {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        println("""
                What is the file name of the story you want to read?:
                    (G)oldilocks
                    (H)ansel and Gretel
                    (M)ary had a Little Lamb""");
        String userChoice = input.next().toLowerCase();
        String userStory = "";
        int lineCounter = 1;

        switch(userChoice){
            case "g":
                userStory = "goldilocks.txt";
                break;
            case "h":
                userStory = "hansel_and_gretel.txt";
                break;
            case "m":
                userStory = "mary_had_a_little_lamb.txt";
                break;
            default:
                println("Please enter a valid option");
        }

        try {
            FileReader fileReader = new FileReader(userStory);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String bedtimeLine = bufReader.readLine();

            while (bedtimeLine != null){
                println(lineCounter +". " + bedtimeLine);
                lineCounter++;
                bedtimeLine = bufReader.readLine();
            }

            bufReader.close();
        }
        catch (IOException e){
            println("Grrrr pick a correct option");
        }

    }
    static void println(String message){
        System.out.println(message);
    }
}
