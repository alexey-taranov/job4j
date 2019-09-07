package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class Args {

    private Map<String, String> args = new HashMap<>();

    public Args(String[] args) {
        int i = 0;
        while (i < args.length) {
            if (args[i].equals("-d") || args[i].equals("-o") || args[i].equals("-e")) {
                this.args.put(args[i++], args[i++]);
            } else {
                i++;
            }
        }
    }

    public String directory() {
        return args.getOrDefault("-d", null);
    }

    public String output() {
        return args.getOrDefault("-o", null);
    }

    public String exclude() {
        String result = null;
        if (args.containsKey("-e")) {
            result = args.get("-e");
        }
        return result.substring(result.indexOf("."));
    }
}
