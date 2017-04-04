package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }

}

class Fraction {
    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return this.a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return this.b;
    }

    public Fraction() {
    }

    public int countGCF(int a, int b) {
        int temp;
        if (a <= b) {
            for (temp = a; temp >= 1; temp--) {
                if (a % temp == 0 && b % temp == 0) {
                    return temp;
                }
            }
        } else {
            for (temp = b; temp >= 1; temp--) {
                if (a % temp == 0 && b % temp == 0) {
                    return temp;
                }
            }
        }
        return 1;

    }

    public Fraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double toDouble() {
        return (double) a / (double) b;
    }

    public Fraction plus(Fraction r) {
        return new Fraction(r.getA() * this.b + r.getB() * this.a, r.getB() * this.b);
    }

    public Fraction multiply(Fraction r) {
        return new Fraction(r.getA() * this.a, r.getB() * this.b);
    }

    public void print() {
        if (this.a == this.b)
            System.out.println(1);
        else
            System.out.println(this.a / this.countGCF(this.a, this.b) + "/" + this.b / this.countGCF(this.a, this.b));

    }
}
