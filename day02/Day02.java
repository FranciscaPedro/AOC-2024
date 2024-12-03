package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day02 {
    private static final List<Integer> safe = new ArrayList<>();
    private static final List<Integer> new_safe = new ArrayList<>();

    public static boolean ex1(List<String> results){
        List<Integer> list = new ArrayList<>();
        for (String s : results) {
            list.add(Integer.parseInt(s));
        }

        List<Integer> list_sorted = new ArrayList<>(list);
        list.sort(Integer::compareTo);
        if (list.equals(list_sorted) ) {
            for (int i = 0; i < results.size()-1; i++) {
                if (Math.abs(list.get(i+1) - list.get(i)) > 3){
                    return false;
                }
                if (Math.abs(list.get(i+1) - list.get(i)) < 1){
                    return false;
                }
            }
            return true;
        } else if (list.equals(list_sorted.reversed())) {
            for (int i = 0; i < list.size()-1; i++) {
                if (Math.abs(list.get(i+1) - list.get(i)) > 3){
                    return false;
                }
                if (Math.abs(list.get(i+1) - list.get(i)) < 1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean ex2(List<String> results){
        List<String> list = new ArrayList<>(results);
        for (int i = 0; i < results.size(); i++) {
            results.remove(i);
            if (ex1(results)) {
                return true;
            }
            results.add(i, list.get(i));
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("./day02/input.txt"));
        for (int i = 0; i < lines.size(); i++) {
            List<String> results = new ArrayList<>();
            for (String s : lines.get(i).split(" ")) {
                results.add(s);
            }
            if (ex1(results)){
                safe.add(i);
            } else if (ex2(results)) {
                new_safe.add(i);
            }
        }

        System.out.println("Result of the first exercise: " + safe.size());
        System.out.println("Result of the second exercise: " + (safe.size() + new_safe.size()));
    }
}
