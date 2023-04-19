package remember;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListSample {
    int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    List<Integer> data = new ArrayList<>();

    public static void main(String args[]) {
        ListSample sample = new ListSample();

        sample.initData();
        sample.printData();
        sample.printData2();

        sample.swap(0, 4);
        sample.printData();

        sample.primesum();
        sample.shuffle();

        int r = (int)(Math.random() * 5);
        System.out.println(r);
    }

    void initData() {
        for(int i = 0; i < prime.length; i++) {
            data.add(prime[i]);
        }
    }

    void printData() {
        for(int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i) + " ");
        }
        System.out.println();

    }

    void printData2() {
        for(int d: data) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    void swap(int x, int y) {
        Collections.swap(data, x, y);
    }

    void primesum() {
        List<Integer> ps = new ArrayList<>();

        for(int i = 0; i < prime.length - 1; i++) {
            ps.add(prime[i] + prime[i + 1]);
            System.out.print(ps.get(i) + " ");
        }
        System.out.println();
    }

    void shuffle() {
        for(int i = 0; i < data.size(); i++) {
            swap(i, (int)(Math.random() * data.size()));
            System.out.print(data.get(i) + " ");
        }
        System.out.println();
    }
}
