package ru.samsung.lesson06042021;

import java.util.Arrays;

public class Address {
    int []address;

    public Address(int[] address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address=" + Arrays.toString(address) +
                '}';
    }
}
