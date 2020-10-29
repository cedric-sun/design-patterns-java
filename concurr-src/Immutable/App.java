package Immutable;

/*
Immutable
================
The key to the immutable "pattern" is a programmer that does not write assignment
statement to change the value at the memory address in question.

Really nothing to learn here. If concurrent writes to / reads from the same
memory address is dangerous, let's not write to it at all (and in java's case
you can use syntax rules and absence of setters to enforce that).
 */
public class App {
    public static void main(String[] args) {

    }
}
