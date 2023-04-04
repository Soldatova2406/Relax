package ru.netology.services;

public class Main {
    public static void main(String[] args) {

        RestCounter service = new RestCounter();
        int count = service.calculate(100_000, 60_000, 150_000);
        System.out.println(count);

    }

}