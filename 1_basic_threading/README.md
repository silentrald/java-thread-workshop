# How to use Threads

You could implement a thread in 3 ways:
1. Make a subclass of **Thread**
2. Make a class with an interface of **Runnable**
3. Use of lambda expression
 ___
The first one, we will create a subclass like seen in the `CustomThread.java` and you can see that it extends on the Thread class
```
public class CustomThread extends Thread {
```
This will inherit the everything inside the class, the more important thing is that there should be a function that we need to override which is the **run() function**
```
@Override
public void run() { 
    <some statements>
}
```
This will be the called when the thread starts running, so after making the run function we can then run a Driver class and instantiate the thread and start the thread as well
```
Thread t = new CustomThread();      // instantiate the object
t.start();                          // starts the thread

t.join();                           // waits until thread t is done running
```
the method `start()` will start the thread and `join()` waits until the thread is done running.
___
Instead of using a subclass, we can use the interface Runnable instead which will be used in the constructor call in Thread. So you can see in `CustomRunnable.java`
```
public class CustomRunnable implements Runnable {
```
It only implements the Runnable interface but we still need to override the `run()` method. So when we declare it in the driver class, we do this
```
Thread t = new Thread(new CustomRunnable());
t.start();
t.join();
```
We just put the runnable class inside the constructor call and it still works the same.
___
Lastly, if you don't want to add more classes or java files, you can opt to use a lambda expression which looks like this in the driver class.
```
Thread t = new Thread(() => {
    <whatever you put in the run method, put it here>
});
```
and it will work the same way.