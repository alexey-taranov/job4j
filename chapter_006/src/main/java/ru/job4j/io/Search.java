package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Search {

    List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        File file = new File(parent);
        if (file.exists()) {
            data.offer(file);
            while (!data.isEmpty()) {
                File dirFile = data.poll();
                for (File checkFile : dirFile.listFiles()) {
                    if (checkFile.isDirectory()) {
                        data.offer(checkFile);
                    } else if (exts.contains(getExtension(checkFile))) {
                        result.add(checkFile);
                    }
                }
            }
        }
        return result;
    }

    public String getExtension(File file) {
        String fileName = file.getName();
        int index = fileName.indexOf('.');
        return index == -1 ? null : fileName.substring(index);
    }
}
