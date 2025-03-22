package kr.co.fastcampus.cli.di;

public class Main {
    public static void main(String[] args) {
        boolean condition = true;
        A a = new A(condition);
        a.print();
    }
}
