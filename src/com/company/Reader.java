package com.company;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        String fail = input.nextLine();
        ArrayList<String> list = new ArrayList<>(crList(fail));


        for (int i = 0; i < list.size(); i++) {
            String [] s = (list.get(i)).split(";");
            System.out.println(s[0]);
            System.out.println("Avg Temp is: " + findAvg(convertArr(s)));
            System.out.println("Min Temp is: " + minTemp(convertArr(s)));
            System.out.println("Max Temp is: " + maxTemp(convertArr(s)));
            System.out.println("Avg Temp excluding extremes is: " + findAvgExt(convertArr(s)));
        }
    }

    public static double findAvgExt(double[] array) {
        double amount = array.length - 3;
        double sum = 0;
        double avg;
        for (double value : array) {
            sum += value;
        }
        sum -= (minTemp(array) + maxTemp(array));
        avg = sum / amount;
        return avg;
    }

    public static double minTemp( double [] array ){
        double min = array [1];
        for (int i = 1; i < array.length; i++) {
            if (array [i] < min){
                min = array [i];
            }
        }
        return min;
    }

    public static double maxTemp( double [] array ){
        double max = array [0];
        for (int i = 1; i < array.length; i++) {

            if (array [i] > max){
                max = array [i];
            }
        }
        return max;
    }

    public static double[] convertArr(String[] array) {
        double [] t = new double [array.length];
        for (int i = 1; i < t.length; i++) {
            t[i] = Double.parseDouble(array[i]);
        }
        return t;
    }

    public static double findAvg(double[] array) {
        double amount = array.length - 1;
        double sum = 0;
        double avg;
        for (double value : array) {
            sum += value;
        }
        avg = sum / amount;
        return avg;
    }

    public static ArrayList crList(String fail) {

        ArrayList<String> result = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader(fail))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
            return result;
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return null;
    }
}

