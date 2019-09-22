package com.kukhotskovolets;


interface StackOverflowProgrammer {
    void visitStackOverflow();
    void copyPasteFromStackOverflow();
    void askOnStackOverflow();
}

public interface Programmer extends StackOverflowProgrammer {
    <T> void learn(Iterable<T> technologies);
    void writeCode();
    void debug();
}
