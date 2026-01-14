package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.MachineVolts;
import java.util.*;

public class VoltRegulerCommand implements LightsCommand {
    private final List<MachineVolts> machines;

    public VoltRegulerCommand(List<MachineVolts> machines) {
        this.machines = machines;
    }

    @Override
    public long execute() {
        return machines.stream().mapToLong(this::solve).sum();
    }

    private long solve(MachineVolts m) {
        // Usamos una lista de Integers como clave porque es inmutable y tiene hashCode nativo correcto
        return minPresses(m.targets(), m.buttons(), new HashMap<>());
    }

    private long minPresses(int[] targets, List<int[]> buttons, Map<String, Long> memo) {
        // Verificar si llegamos al objetivo, todo ceros
        boolean allZero = Arrays.stream(targets).allMatch(t -> t == 0);
        if (allZero) return 0;

        // Verificar si nos pasamos (algún negativo, camino inválido)
        if (Arrays.stream(targets).anyMatch(t -> t < 0)) return Long.MAX_VALUE / 2;

        String key = Arrays.toString(targets);
        if (memo.containsKey(key)) return memo.get(key);

        long minCost = Long.MAX_VALUE / 2;

        for (int[] btnEffect : buttons) {
            // Generar nuevo estado restando el efecto del botón
            int[] nextState = new int[targets.length];
            for (int i = 0; i < targets.length; i++) nextState[i] = targets[i] - btnEffect[i];

            long res = minPresses(nextState, buttons, memo);
            if (res < minCost) minCost = res + 1;
        }

        memo.put(key, minCost);
        return minCost;
    }
}