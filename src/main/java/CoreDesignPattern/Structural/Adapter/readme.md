Purpose: Convert one interface into another expected by the client.
Problem Solved: Incompatible interfaces.
Relationship: Has-A (Composition) is preferred.
Adapter wraps the existing object.
Does not modify existing code.
Acts as a translator between two interfaces.
Client depends only on the target interface.
Follows Open/Closed Principle.
Useful when integrating legacy or third-party libraries.