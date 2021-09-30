## Generics

Constructs introduced in Java 5 whic enforce compile time by allowing you to use paramatized types.

- They are used heavily with the Collections API
  They are essentially a placeholder for a future data type that helps us enforce data safety.

Generics can be declared on a class, method parameters, or return type.
With generics, you can restrict a class to only accept objects of a given type and the compiler will prevent you from using any other type:

```List<String> names = new ArrayList<>(); // using a List of Strings only
names.add("Alice"); // nice!
names.add(new Object()); // now we get a compilation error to stop this - generics save the day!
```

To make a class (or interface) generic, use the angle brackets when declaring it, and use an arbitrary "generic type" which is determined by the invoking code. The generic type can then be reused throughout the class to enforce type safety.

echnically, type parameters can be named anything you want. The convention is to use single, uppercase letters to make it obvious that they are not real class names.

- E => Element
- K => Map Key
- V => Map Value
- N => Number
- T => Generic data type
- S, U, V, and so on => For multiple generic data types

## Threads and Concurrency

Concurrencyrefers to breaking up a task into different parts that can be executed independent of one another

## Threads:

a thread is a subset of a process that is also an independent sequence of execution

- threads of the main process will run in the same memmory space, but managed independently by the scheduler

## States of threads

Threads follow a lifecycle of 6 different states:

- New : newly created thread that has not started executing;
- Runnable: either running or ready for execution but waiting for its resource allocation;
- Blocked: waiting to acquire monitor lock to enter or re-enter a synchronized block/method;
- Waiting: waiting for some other thread to perform an action;
- Thread_Waiting: waiting for some other thread to perform a specific action for a specific time;
- Terminated: has completed its execution.

## Thread Priorities

Priorities signify which order threads are to be run. The Thread class contains a few static variables for priority:

- MIN_PRIORITY = 1
- NORM_PRIORITY = 5, default
- MAX_PRIORITY = 10

In Java, multithreading is achieved via the Thread class and/or the Runnable interface.

## Custom Threads

You can create custom threads in one of two ways, extending the `Thread` class, or extending the `Runable` Interface

## Thread Class

creating a thread by extedning the thread class will grant you access to the thread class methods:

- getters and setters for id, name, and priority
- interrupt() to explicitly interrupt the thread
- isAlive(), isInterrupted() and isDaemon() to test the state of the thread
- join() to wait for the thread to finish execution
- start() to actually begin thread execution after instantiation

To create a thread this way:

1. Create a class that extends Thread;
2. Implement the run() method;
3. Use the custom thread with the `.start()` method

## Runnable Interface

Creating a thread with implementing the Runnable Interface will give you the freedom to extend any different class you'd like

To create a class in this way:

1. Create a class that extends `Runnable`;
2. Implement the run() method;
3. To use this thread you must create a generic thread object and pass your custom runnable object as a parameter to the constructor

## Thread Problems

There are issues that can occur if you try implementing multithreading yourself. One of these is called Deadlock

- Desdlockoccurs when two or more threads are blocked trying to access the same resource, waiting for one another. Neither thread can continue execution, so the program haults indefinitely.This is where synchronization comes in.
- Synchronization is the capability to control the access of multiple threads to any shared resource
  To do this, use the `synchronized` keyword. The synchronized keyword enforces that only one thread can access the resource at a give time.
  Another problem multithreading programs run into is produce consumer problem

  ## Producer Consumer Problem

  In this problem we have a fized size buffer that is shared between the producer and the consumer.

  - The producer adds to the buffer
  - The consumer takes from the buffer.
    The problem is that date should only be added if the buffer is not full, and data should only be consumed if the buffer is not empty.

  To solve this we can use the `synchronized` keyword, as well as the `.wait()` and `.notify()` methods to communicate across threads

- .wait(): can pause the consumer depending on the amount of data in the buffer;
- .notify(): can send a notification to either thread when they can be used.

# POJO vs Bean

In Java a POJO is a Plan Old Java Object.

A Bean is a special Java Object with specific rules:

- Every Java Bean is a POJO, but not every POJO is a Bean;
- they must be serializeable, i.e implement the Serializable Interface;
- All fields should be private;
- Fields should have getters and setters;
- There should be a no-args constructors;
- Fields are accessible only by contructor and setters and getters.

# Serialization

the process writing the state of an object to a Byte stream, the reverse is called deserialization.

- We serialize Java Beans.

## Marker Interfaces

- An interface with no methods. Its purpose is to provide metadate to the compiler.
- Serializable is a marker interface. It tells the compiler the object can be serialized.

# File I/O

"I/O" refers to how data is accessed, either via reading or writing. In Java file I/O objects dall into two categories:

- Streams: reading or writing bytes;
- Reader/ Writer: reads or writes characters.
  Common file I/O classes:
- FileInputStream - reads raw bytes from a file
- FileOutputStream - writes raw bytes to a file
- FileReader - reads characters from a file
- FileWriter - writes characters to a file
- BufferedReader - reads a file line by line, needs an instance of a FileReader with a path to the resource to be read in the constructor
- BufferedWriter - writes to a file line by line, needs an instance of a FileWriter with a path to the destination file in the constructor
- Scanner - can read from an InputStream, useful methods for character reading /_ this is what we will be using for project zero _/

Character files are read line by line, either until a carriage return (\r) or a newline (\n), depending on your operating system. When using I/O classes to read and write, you should always close your resources with the .close() method. This prevents exceptions from being thrown later, memory leaks, and system overutilization of unused resources.

The way you serialize data is with a FileOutputStream and ObjectOutputStream.

The way you deserialize is with a FileInputStream and ObjectInputStream.

# Scanner

The Scanner class can be used to read user input from the command line.

# Try with Resources

Java 7 implemented a new use for the try catch block, try with resources allows you to add a resource in the try block, and Java will automatically close the resource for you when you are finished using it.

The only catch is that the object in the try parenthesis must implement the AutoCloseable interface
