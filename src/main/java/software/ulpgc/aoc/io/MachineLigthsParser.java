package software.ulpgc.aoc.io;

import software.ulpgc.aoc.model.MachineLights;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MachineLigthsParser {
    public static List<MachineLights> parse(List<String> lines) {
        List<MachineLights> machines = new ArrayList<>();
        for (String line : lines) {
            // Filtrar solo líneas de parte 1
            if (!line.contains("[")) continue;

            // Extraer objetivo [ . # # . ]
            String targetPart = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            long targetMask = 0;
            for (int i = 0; i < targetPart.length(); i++) {
                if (targetPart.charAt(i) == '#') targetMask |= (1L << i);
            }

            // Extraer botones (0,3,4)
            List<Long> buttons = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(line);
            while (matcher.find()) {
                long btnMask = 0;
                String content = matcher.group(1);
                if (!content.isEmpty()) {
                    for (String idx : content.split(",")) {
                        btnMask |= (1L << Integer.parseInt(idx.trim()));
                    }
                }
                buttons.add(btnMask);
            }
            machines.add(new MachineLights(targetMask, buttons));
        }
        return machines;
    }
}