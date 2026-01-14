package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.InitializationCommand;
import software.ulpgc.aoc.command.VoltRegulerCommand;
import software.ulpgc.aoc.model.MachineLights;
import software.ulpgc.aoc.model.MachineVolts;

import java.util.List;

public class DeviceController {
    public long turnOnMachines(List<MachineLights> machineLights) {
        return new InitializationCommand(machineLights).execute();
    }

    public long regulerVoltMachines(List<MachineVolts> machinesVolts) {
        return new VoltRegulerCommand(machinesVolts).execute();
    }
}