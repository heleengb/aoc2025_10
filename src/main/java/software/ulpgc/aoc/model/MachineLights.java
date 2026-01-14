package software.ulpgc.aoc.model;

import java.util.List;

public record MachineLights(long onPositionMask, List<Long> buttonMasks) {}