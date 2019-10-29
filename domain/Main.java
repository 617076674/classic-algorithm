package domain;

public class Main {
    public static void main(String[] args) {
        Father father = new Son();
        System.out.println(Son.a);
        System.out.println(Son.b);
        System.out.println(father.c);
        System.out.println(father.d);
        Son son = new Son();
        System.out.println(son.c);
        System.out.println(son.d);
    }
}
