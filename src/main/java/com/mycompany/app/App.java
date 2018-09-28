package com.mycompany.app;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Integer> t1 = new ArrayList<Integer>();
        t1.add(3);
        t1.add(8);
        t1.add(1);
        t1.add(4);

    }

    public String method(ArrayList<Integer> arrayList, Integer[] array, boolean divide, String operation) {
        String output = "";
        if (arrayList == null || array == null) {
            output = "Arrays can not be null.";
        }
        else {
            ArrayList<Integer> newArrayList;
            Integer[] newArray;
            int i1, i2;
            if (divide) {
                newArrayList = new ArrayList<Integer>();
                i1 = arrayList.size() / 2;
                i2 = array.length / 2;
                newArray = new Integer[i2];
                for (int i = 0; i < i1; i++) {
                    newArrayList.add(arrayList.get(i));
                }
                for (int i = 0; i < i2; i++) {
                    newArray[i] = array[i];
                }

            } else {
                newArrayList = arrayList;
                newArray = array;
                i1 = newArrayList.size();
                i2 = newArray.length;

            }
            int min = i1;
            if (i2 < min) {
                min = i2;
            }

            for (int i = 0; i < min; i++) {

                if (operation.equalsIgnoreCase("Sum")) {
                    if (i != min - 1)
                        output += newArrayList.get(i) + newArray[i] + ",";
                    else
                        output += (newArrayList.get(i) + newArray[i]) + "";

                } else if (operation.equalsIgnoreCase("Subtraction")) {
                    if (i != min - 1)
                        output += newArrayList.get(i) - newArray[i] + ",";
                    else
                        output += newArrayList.get(i) - newArray[i] + "";

                } else if (operation.equalsIgnoreCase("Multiply")) {
                    if (i != min - 1)
                        output += newArrayList.get(i) * newArray[i] + ",";
                    else
                        output += newArrayList.get(i) * newArray[i] + "";

                } else if (operation.equalsIgnoreCase("Division")) {
                    if (i != min - 1)
                        output += newArrayList.get(i) / newArray[i] + ",";
                    else
                        output += newArrayList.get(i) / newArray[i] + "";

                } else {
                    output = "There is a mistake in operation definition";
                    break;
                }
            }

        }
        return output;
    }
}
