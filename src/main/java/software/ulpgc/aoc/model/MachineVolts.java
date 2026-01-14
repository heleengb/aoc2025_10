package software.ulpgc.aoc.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record MachineVolts(int[] targets, List<int[]> buttons) {
    @Override
    public String toString() {
        String buttonsFormatted = buttons.stream()
                .map(Arrays::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        return "Targets: " + Arrays.toString(targets) + " | Buttons: " + buttonsFormatted;
    }
}