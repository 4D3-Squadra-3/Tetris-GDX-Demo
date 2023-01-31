package com.squadra3.tetris.tool;

// Interfaccia builder per usare la Builder pattern
public interface Builder<T> {
    T build();
    void reset();
}
