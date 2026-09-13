# Prototype Design Pattern

## Pattern name
Prototype Pattern

## What problem does it solve?
Sometimes creating a new object from scratch is expensive or logically complex.

For example:
- creating many similar objects
- expensive initialization
- object creation depends on preconfigured state

## What is the idea behind this pattern?
Instead of creating a new object manually, create a prototype object first and then clone it.

This is especially useful when many objects need to share the same initial configuration.

## Structure in this project
Files involved:
- `CoreDesignPattern/Creational/Prototype/Main.java`

## Main components
### 1) `Shape`
This is the prototype base class.

It declares:
- `clone()`
- `draw()`

It also stores shared prototype state such as `id` and `type`.

### 2) `Circle`
This concrete prototype represents a circle.

It has extra fields such as `radius`.

### 3) `Rectangle`
This concrete prototype represents a rectangle.

It has fields such as `width` and `height`.

### 4) `ShapeCache`
This class stores pre-created prototype objects in a map.

When the client requests a shape type, the cache returns a clone of the stored prototype.

## How the example works
- `ShapeCache` initially contains a `Circle` prototype and a `Rectangle` prototype
- `ShapeCache.getShape("circle")` returns a cloned circle
- `ShapeCache.getShape("rectangle")` returns a cloned rectangle
- The client can then modify the clone without affecting the original cached prototype

## Why this pattern is useful
- Avoids repeated expensive initialization
- Saves time when creating many similar objects
- Makes object creation more flexible
- Useful for game objects, config objects, and cached models

## Interview-style explanation
"Prototype Pattern is used when object creation is costly and many objects need similar initial state. Instead of constructing every object from scratch, we create a prototype and clone it. In this example, the cache stores prototype shapes, and the client asks for clones whenever needed. This keeps the original template unchanged while allowing independent customized copies."
