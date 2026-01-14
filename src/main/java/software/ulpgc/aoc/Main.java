package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.DeviceController;
import software.ulpgc.aoc.io.FileSourceReader;
import software.ulpgc.aoc.io.MachineLigthsParser;
import software.ulpgc.aoc.view.ConsolePrinter;
import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "baterias.txt");

    public static void main(String[] args) {
        try {
            var lines = new FileSourceReader(INPUT_PATH).readLines();
            var machinesLights = MachineLigthsParser.parse(lines);

            long total = new DeviceController().turnOnMachines(machinesLights);

            new ConsolePrinter().showResult(total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}