package pl.sda.hibernate.fakturownia.komenda;

import java.util.Scanner;

public interface Komenda {
    public static final Scanner scanner = new Scanner(System.in);

    String getKomenda();

    void obsluga();
}
