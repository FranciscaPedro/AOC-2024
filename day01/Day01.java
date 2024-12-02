package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day01 {
  private static final List<Integer> list1 = new ArrayList<>();
  private static final List<Integer> list2 = new ArrayList<>();

  public static int ex1() {
    int result = 0;
    for (int i = 0; i < list1.size(); i++) {
      result += Math.abs(list2.get(i) - list1.get(i));
    }
    return result;
  }

  public static int ex2() {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int element : list1) {
      if (!map.containsKey(element)) {
        map.put(element, 0);
      }
    }
    for (int element : list2) {
      if (map.containsKey(element)) {
        map.put(element, map.get(element) + 1);
      }
    }

    for (int element :list1) {
      if (map.containsKey(element)) {
        result += element * map.get(element);
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Path.of("./day01/input.txt"));
    for (String line : lines) {
      list1.add(Integer.parseInt(line.split(" +")[0]));
      list2.add(Integer.parseInt(line.split(" +")[1]));
    }
    list1.sort(Integer::compareTo);
    list2.sort(Integer::compareTo);

    System.out.println("Result of the first exercise: " + ex1());
    System.out.println("Result of the second exercise: " + ex2());
  }
}