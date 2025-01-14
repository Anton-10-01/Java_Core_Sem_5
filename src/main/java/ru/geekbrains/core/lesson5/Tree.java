package ru.geekbrains.core.lesson5;

import java.io.File;
import java.io.IOException;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }
    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if(isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if(files != null) {
            int subDirTotal = 0;
            int subFileTotal = 0;
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    subDirTotal++;
                } else if (files[i].isFile()) {
                    subFileTotal++;
                }
            }

            int subDirCounter = 0;
            int subFileCounter = 0;
            for (int i = 0; i < files.length; i++) {
                try {
                    if (files[i].isDirectory()) {
                        print(files[i], indent, subDirTotal == ++subDirCounter);
                    } else if (files[i].isFile()) {
                        print(files[i], indent, subFileTotal == ++subFileCounter);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
