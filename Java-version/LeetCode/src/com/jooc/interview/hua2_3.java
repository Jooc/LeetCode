package com.jooc.interview;

import java.util.HashMap;
import java.util.Scanner;

public class hua2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Long, String> virtualMemory = new HashMap<>();
        int numCommands = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            String cmd = command[0];

            if (cmd.equals("Read")) {
                long address = Long.parseLong(command[1].substring(2), 16);
                if (address > 800000000) {
                    continue;
                }
                int length = Integer.parseInt(command[2]);
                String result = readData(virtualMemory, address, length);
                System.out.println(result);
            } else if (cmd.equals("Write")) {
                long address = Long.parseLong(command[1].substring(2), 16);
                if (address > 800000000) {
                    continue;
                }
                int length = Integer.parseInt(command[2]);
                String data = command[3];
                writeData(virtualMemory, address, length, data);
            } else if (cmd.equals("Clear")) {
                clearData(virtualMemory);
            }
        }
    }

    private static String readData(HashMap<Long, String> virtualMemory, long address, int length) {
        StringBuilder resultSB = new StringBuilder();
        for (int i = 0; i < length; i++) {
            long curAddress = address + i;
            String curData = virtualMemory.getOrDefault(curAddress, "");
            resultSB.append(curData);
        }
        String result = resultSB.toString();
        if (result.length() < length * 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length * 2 - result.length(); i++) {
                sb.append("0");
            }
            result = result + sb;

        } else if (result.length() > length * 2) {
            result = result.substring(0, length * 2);
        }
        return result;
    }

    private static void writeData(HashMap<Long, String> virtualMemory, long address, int length, String data) {
        if (data.length() < length * 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length * 2 - data.length(); i++) {
                sb.append("0");
            }
            data = data + sb;
        } else if (data.length() > length * 2) {
            data = data.substring(0, length * 2);
        }

        for (int i = 0; i < length; i++) {
            long curAddress = address + i;
            String curData = data.substring(i * 2, i * 2 + 2);
            virtualMemory.put(curAddress, curData);
        }
    }

    private static void clearData(HashMap<Long, String> virtualMemory) {
        virtualMemory.clear();
    }
}
