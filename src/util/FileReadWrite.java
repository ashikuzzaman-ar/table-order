package util;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Formatter;
import java.util.Scanner;

public abstract class FileReadWrite implements Serializable, Closeable {

    private Scanner scanner;
    private Formatter formatter;
    private final File file;

    public FileReadWrite(String fileName) {

        this.file = new File(fileName);
    }

    public String[] getFoodItems() {

        String[] result = null;
        try {

            this.scanner = new Scanner(this.file);

            StringBuilder stringBuilder = new StringBuilder();

            while (this.scanner.hasNext()) {

                stringBuilder.append(this.scanner.nextLine());
                stringBuilder.append(";;;");
            }

            result = stringBuilder.toString().split(";;;");

            this.scanner.close();
        } catch (FileNotFoundException e) {

            System.err.println("File operation error!");
            throw new ExceptionInInitializerError(e);
        }

        return result;
    }

    public void putOrderList(String order) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(order);
        try {

            if (this.file.exists()) {

                this.scanner = new Scanner(this.file);

                while (this.scanner.hasNext()) {

                    stringBuilder.append(this.scanner.nextLine());
                }

                this.scanner.close();

                this.formatter = new Formatter(this.file);
                this.formatter.format("%s", stringBuilder.toString());
                this.formatter.close();
            }
        } catch (FileNotFoundException e) {

            System.err.println("No previous data found!");
            throw new ExceptionInInitializerError(e);
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Formatter getFormatter() {
        return formatter;
    }
}
