package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.DeviceController;
import software.ulpgc.aoc.io.FileSourceReader;
import software.ulpgc.aoc.io.MachineVoltParser;
import software.ulpgc.aoc.view.ConsolePrinter;
import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "baterias.txt");

    public static void main(String[] args) {
        try {
            var lines = new FileSourceReader(INPUT_PATH).readLines();
            var machinesVolts = MachineVoltParser.parse(lines);

            long total = new DeviceController().regulerVoltMachines(machinesVolts);

            new ConsolePrinter().showResult(total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}