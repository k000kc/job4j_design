package ru.job4j.algo;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (totalGas >= totalCost) {
            result = start;
        } else {
            result = -1;
        }
        return result;
    }
}
