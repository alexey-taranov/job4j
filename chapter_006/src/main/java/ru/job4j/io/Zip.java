package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public List<File> seekBy(String root, String ext) {
        List<File> resultListOfFiles = new ArrayList<>();
        Queue<File> queueRoot = new LinkedList<>();
        queueRoot.offer(new File(root));
        while (!queueRoot.isEmpty()) {
            File files = queueRoot.poll();
            if (files != null && files.isDirectory()) {
                for (File checkFile : files.listFiles()) {
                    queueRoot.offer(checkFile);
                }
            } else {
                if (files.isFile() && !files.getName().endsWith(ext)) {
                    resultListOfFiles.add(files);
                }
            }
        }
        return resultListOfFiles;
    }

    public void pack(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Zip().pack(new File("." + File.separator + "chapter_005" + File.separator + "pom.xml"),
                new File("." + File.separator + "chapter_005" + File.separator + "pom.zip"));
    }
}
