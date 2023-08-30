package org.example;

import java.util.List;

import static org.example.Utils.getCatsInfo;

public class Main {
    public static void main(String[] args) {
        String uri = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
        List<Cats> catsList = getCatsInfo(uri);
        try {
            assert catsList != null;
            List<Cats> cats = catsList.stream().filter(cat -> cat.getUpvotes() != null && cat.getUpvotes() > 0).toList();
            for (Cats cat : cats) {
                System.out.println(cat.toString());
            }
        } catch (NullPointerException e) {
            System.out.println("No data.");
        }
    }
}