package kr.co.fastcampus.cli.di;

public class A {
  private B b;

  public A(boolean condition) {
    this.b = new B(condition);
  }

  public void print() {
    System.out.println(b.calc());
  }
}
