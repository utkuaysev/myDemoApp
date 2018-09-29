package com.mycompany.app;

import java.util.ArrayList;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            System.out.println(req.queryParams("input1"));
            System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
                inputList.add(value);
            }
            System.out.println(inputList);

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            String[] inputArraystr;
            String arrayString="";
            while (sc1.hasNext()) {
                int value2 = Integer.parseInt(sc2.next().replaceAll("\\s", ""));
                arrayString+=value2+",";
            }
            inputArraystr=arrayString.split(",");
            Integer[] inputArray = new Integer[inputArraystr.length];
            for (int i = 0; i < inputArraystr.length; i++) {
                inputArray[i]= Integer.parseInt(inputArraystr[i]);
            }
            for (int i = 0; i < inputArray.length; i++) {
                System.out.println(inputArray[i]+",");
            }

            String input3 = req.queryParams("input3").replaceAll("\\s","");
            boolean divide = Boolean.parseBoolean(input3);

            String operation = req.queryParams("input4").replaceAll("\\s","");

            String result = App.method(inputList, inputArray,divide,operation);

            Map map = new HashMap();
           map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }



    public static String method(ArrayList<Integer> arrayList, Integer[] array, boolean divide, String operation) {
        String output = "";
        if (arrayList == null || array == null) {
            output = "Arrays can not be null.";
        } else {
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
