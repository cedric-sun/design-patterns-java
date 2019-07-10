### Iterator
Decouple the iteration function from implementation.

### Bridge
Both "adding functionality" and "adding implementation"
can be done by inheritance. But it would be good to
structurally separate these two kinds of inheritance.

### State
A State class is a collection of methods that depend
on the concept "state". Instead of condition on states, State Pattern replaces the state 
(thus the collection of methods) as a whole.

"Who manages the transfer of states" matters.  