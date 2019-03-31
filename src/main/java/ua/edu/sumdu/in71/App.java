package ua.edu.sumdu.in71;

public class App {
    public static void main( String[] args ) {
        PointSet pointSet = new PointSet();
        pointSet.addPoints(5);
        for (int i = 0; i < 10; i++) {
            System.out.println("Interpolating arg = " + i + " val = " + inerpolate(i, pointSet));
        }
        //printTest(arg, val);
    }

    private static double inerpolate(double arg, PointSet pointSet) {
        double sum = 0;
        for (int i = 0; i < pointSet.getArgs().size(); i++) {
            double mult = pointSet.getVals().get(i);
            for (int j = 0; j < pointSet.getArgs().size(); j++) {
                if (i != j) {
                    mult *= (arg - pointSet.getArgs().get(j)) / (pointSet.getArgs().get(i) - pointSet.getArgs().get(j));
                }
            }
            sum += mult;
        }
        return sum;
    }

    private static double inerpolate(double arg, double [] args, double [] vals) {
        double sum = 0;
        for (int i = 0; i < args.length; i++) {
            double mult = vals[i];
            for (int j = 0; j < args.length; j++) {
                if (i != j) {
                    mult *= (arg - args[j]) / (args[i] - args[j]);
                }
            }
            sum += mult;
        }
        return sum;
    }

    private static void printTest() {
        double [] args = new double[] {1, 3, 5, 7, 9};
        double [] vals = new double[] {16.9, 18.4, 21.4, 27.4, 32.6};
        for (int i = 0; i < args.length; i++) {
            System.out.println("Interpolating: x = " + args[i] + " y = " + inerpolate(args[i], args, vals) + ". Must be " + vals[i]);
        }
    }
}