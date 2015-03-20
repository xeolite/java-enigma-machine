package com.github.xeolite.enigma.support;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class SequentialOnly<T,U> implements BinaryOperator<T>, BiConsumer<T, U> {

    public static <T,U> SequentialOnly<T,U> sequentially() {
        return new SequentialOnly<>();
    }

    @Override
    public T apply(T t, T u) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(T t, U u) {
        throw new UnsupportedOperationException();
    }

}