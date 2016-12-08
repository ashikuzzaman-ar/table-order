package util;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public abstract class FileReadWrite implements Serializable, Closeable {

    private Scanner scanner;

    public FileReadWrite(String fileName) {

        try {

            this.scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {

            System.err.println("File operation failed!");
            throw new ExceptionInInitializerError(e);
        }
    }

    public String[] getFoodItems() {

        StringBuilder stringBuilder = new StringBuilder();

        while (this.scanner.hasNext()) {

            stringBuilder.append(this.scanner.nextLine());
            stringBuilder.append(";;;");
        }

        String[] result = stringBuilder.toString().split(";;;");

        return result;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
