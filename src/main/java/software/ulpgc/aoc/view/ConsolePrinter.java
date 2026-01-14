package software.ulpgc.aoc.view;

public class ConsolePrinter implements SolutionPrinter {
    @Override
    public void showResult(long total) {
        System.out.println("La cantidad óptima de veces que se pueden pulsar los botones es: " + total);
    }
}