package ua.edu.sumdu.in71;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class PointSet {

    private final List<Double> args = new LinkedList<>();
    private final List<Double> vals = new LinkedList<>();

    void addPoints(int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the points in the following format\nx y");
        for (int i = 0; i < amount; i++) {
            System.out.println((i + 1) + " point:");
            try {
                args.add(scanner.nextDouble());
                vals.add(scanner.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("Error.Please, reenter the point.");
                if (args.size() > vals.size()) {
                    args.remove(i);
                }
                i--;
            }
        }
    }

    List<Double> getArgs() {
        return args;
    }

    List<Double> getVals() {
        return vals;
    }
}
