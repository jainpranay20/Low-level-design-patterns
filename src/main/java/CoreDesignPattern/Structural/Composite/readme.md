# Composite Design Pattern

## Pattern name
Composite Pattern

## What problem does it solve?
When you have a hierarchy of objects where some elements are individual items and others are groups containing multiple items, managing them with a single common interface becomes difficult.

Example:
- A file is a leaf node
- A folder is a composite node that can contain files and other folders
- The client should treat both in the same way

## What is the idea behind this pattern?
Create a common interface for both leaf and composite objects, and let composite objects contain child components.

This allows the client to work with the whole tree uniformly.

## Structure in this project
Files involved:
- `CoreDesignPattern/Structural/Composite/CompositeDemo.java`

## Main components
### 1) `FileSystemComponent`
This is the common interface.

It declares:
- `showDetails(String indent)`

Both files and folders implement this interface.

### 2) `File`
This is the leaf node.

It represents an individual file and knows how to display itself.

### 3) `Folder`
This is the composite node.

It stores a list of child components and can add/remove children.

It also calls `showDetails()` on each child recursively.

## How the example works
- `root` is a folder
- `src`, `docs`, and `api` are nested folders
- Files like `Main.java`, `readme.md`, and `pom.xml` are leaf nodes
- The client calls `root.showDetails("")`
- The folder prints itself and then recursively prints all children

## Why this pattern is useful
- Treats leaves and groups uniformly
- Makes recursive structure easy to manage
- Reduces duplicate handling code
- Good for file systems, UI tree structures, and organization charts

## Interview-style explanation
"Composite Pattern is used when an object needs to represent part-whole hierarchies. In this example, a folder can contain files and other folders, while a file is just a leaf. By defining one common interface, the client can treat both files and folders uniformly, and recursion helps in traversing the entire structure easily."
