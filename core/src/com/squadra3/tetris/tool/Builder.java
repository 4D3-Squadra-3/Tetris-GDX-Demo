package com.squadra3.tetris.tool;

// Interfaccia builder per usare la Builder pattern, la quale in certi casi è preferibile rispetto ad un normale costruttore
public interface Builder<T> {
    T build();
    Builder<T> reset();
}
