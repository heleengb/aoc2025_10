package software.ulpgc.aoc.io;

import software.ulpgc.aoc.model.MachineVolts;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MachineVoltParser {
    public static List<MachineVolts> parse(List<String> lines) {
        List<MachineVolts> machines = new ArrayList<>();
        Pattern buttonPattern = Pattern.compile("\\((.*?)\\)");
        Pattern digitPattern = Pattern.compile("\\d+");

        for (String line : lines) {
            // Filtrar solo líneas de parte 2
            if (!line.contains("{")) continue;

            // Extraer targets {46,36,...}
            String targetPart = line.substring(line.indexOf("{") + 1, line.indexOf("}"));
            String[] targetStrs = targetPart.split(",");
            int[] targets = new int[targetStrs.length];
            for (int i = 0; i < targetStrs.length; i++) {
                targets[i] = Integer.parseInt(targetStrs[i].trim());
            }

            // Extraer botones (0,3,4)
            List<int[]> buttons = new ArrayList<>();
            Matcher btnMatcher = buttonPattern.matcher(line);

            while (btnMatcher.find()) {
                String content = btnMatcher.group(1);
                Matcher digitMatcher = digitPattern.matcher(content);
                List<Integer> indices = new ArrayList<>();
                while (digitMatcher.find()) {
                    indices.add(Integer.parseInt(digitMatcher.group()));
                }
                // Convertimos indices a array
                int[] effect = new int[targets.length];
                for(int idx : indices) {
                    if(idx < effect.length) effect[idx] = 1;
                }
                buttons.add(effect); // Guardamos la máscara entera, no solo los índices, para el solver
            }
            machines.add(new MachineVolts(targets, buttons));
        }
        return machines;
    }
}