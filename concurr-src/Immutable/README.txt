Immutable
================
Really nothing to learn here. If concurrent writes to / reads from the same
memory address is dangerous, let's not write to it at all (and in java's case
you can use syntax rules and absence of setters to enforce that).