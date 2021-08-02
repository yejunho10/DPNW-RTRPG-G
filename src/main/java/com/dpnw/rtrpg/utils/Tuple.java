package com.dpnw.rtrpg.utils;

public record Tuple<A, B>(A a, B b) {

    public static <A, B> Tuple<A, B> of(final A a, final B b) {
        return new Tuple<>(a, b);
    }
}