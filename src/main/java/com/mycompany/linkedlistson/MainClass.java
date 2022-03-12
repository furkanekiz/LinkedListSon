package com.mycompany.linkedlistson;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainClass {

    public static void islemleriBastir() {
        System.out.println("0 - Islemleri Goster\n"
                + "1 - Bir sonraki sehre git\n"
                + "2 - Bir onceki sehre git\n"
                + "3 - Uygulamadan cık");
    }

    public static void sehileriTurla(LinkedList<String> sehirler) {
        ListIterator<String> iterator = sehirler.listIterator();

        int islem;

        islemleriBastir();

        Scanner scanner = new Scanner(System.in);

        if (!iterator.hasNext()) {
            System.out.println("Herhangi bir sehir bulunmuyor...");
        }

        boolean cikis = true;
        boolean ileri = true;

        while (cikis) {
            System.out.println("Bir islem seciniz:");
            islem = scanner.nextInt();

            switch (islem) {
                case 0:
                    islemleriBastir();
                    break;
                case 1:
                    if (!ileri) {
                        if (iterator.hasNext()) {
                            iterator.next();
                            ileri = true;
                        }
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Sehre gidiliyor: " + iterator.next());
                    } else {
                        System.out.println("Gidilecek sehir kalmadı...");
                        ileri = true;//asaki comment acilirsa bu false olur
                    }
                    break;
                case 2:
                    if (ileri) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            ileri = false;
                        }
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Sehre gidiliyor: " + iterator.previous());
                    } else {
                        System.out.println("Sehir Turu Basladi...");
                        //ileri = true;//**
                    }
                    break;
                case 3:
                    cikis = false;
                    System.out.println("Uygulamadan cikiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz islem...");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> sehirler = new LinkedList<String>();

        sehirler.add("Ankara");
        sehirler.add("Eskisehir");
        sehirler.add("Afyon");

        sehileriTurla(sehirler);
    }
}
