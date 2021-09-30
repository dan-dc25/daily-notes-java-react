## Generics

Constructs introduced in Java 5 whic enforce compile time by allowing you to use paramatized types.

- They are used heavily with the Collections API
  They are essentially a placeholder for a future data type that helps us enforce data safety.

Generics can be declared on a class, method parameters, or return type.
With generics, you can restrict a class to only accept objects of a given type and the compiler will prevent you from using any other type:

````List<String> names = new ArrayList<>(); // using a List of Strings only
names.add("Alice"); // nice!
names.add(new Object()); // now we get a compilation error to stop this - generics save the day!```

To make a class (or interface) generic, use the angle brackets when declaring it, and use an arbitrary "generic type" which is determined by the invoking code. The generic type can then be reused throughout the class to enforce type safety.

echnically, type parameters can be named anything you want. The convention is to use single, uppercase letters to make it obvious that they are not real class names.

- E => Element
- K => Map Key
- V => Map Value
- N => Number
- T => Generic data type
- S, U, V, and so on => For multiple generic data types
````
