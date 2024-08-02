### The Open-Closed Principle (OCP)

The OCP states that software entities (such as classes, modules, or functions) should be **open for extension** (allowing new functionality to be added) but **closed for modification** (existing code should remain unchanged). In other words, you should be able to extend behavior without altering existing code.

#### Example Breaking OCP

Consider a simple `Logger` class that logs messages:

```csharp
public class Logger
{
    public void Log(string message)
    {
        // Logic for logging the message
    }
}
```

In this example, the `Logger` class is closed for extension because it doesn't allow adding new log types (e.g., file-based logging, email logging) without modifying its existing code. If we want to add a new log type, we'd have to modify the `Logger` class, which violates the OCP.

#### Corrected Version Using Polymorphism

To adhere to the OCP, we can use interfaces and polymorphism. Here's an improved version:

```csharp
// Define an interface for loggers
public interface ILogger
{
    void Log(string message);
}

// Implement specific loggers
public class FileLogger : ILogger
{
    public void Log(string message)
    {
        // Logic for logging to a file
    }
}

public class EmailLogger : ILogger
{
    public void Log(string message)
    {
        // Logic for sending an email with the message
    }
}

// Client code
public class LogManager
{
    private readonly List<ILogger> loggers;

    public LogManager()
    {
        loggers = new List<ILogger>();
        // Initialize loggers (e.g., add FileLogger, EmailLogger)
    }

    public void AddLogger(ILogger logger)
    {
        loggers.Add(logger);
    }

    public void LogMessage(string message)
    {
        foreach (var logger in loggers)
        {
            logger.Log(message);
        }
    }
}
```

In this corrected version:
- We define an `ILogger` interface that represents different loggers.
- We create specific implementations (`FileLogger`, `EmailLogger`) that adhere to the interface.
- The `LogManager` class uses a list of loggers and allows adding new loggers without modifying its code.

Now, you can easily extend the system by adding new loggers (e.g., database logger, console logger) without altering existing code. This approach promotes flexibility and maintainability while following the OCP¹².

Feel free to ask if you'd like further clarification or more examples! 😊👍

Source: Conversation with Copilot, 27/07/2024
(1) The Open/Closed Principle with Code Examples - Stackify. https://stackify.com/solid-design-open-closed-principle/.
(2) SOLID: Open-Closed Principle - TutorialsTeacher.com. https://www.tutorialsteacher.com/csharp/open-closed-principle.
(3) Open-Closed Principle (OCP) - Let's make it easy to understand. https://appcitor.com/dev-articles/best-practice/solid-principle/open-closed-principle/.
(4) Open-Closed Principle in C# with Examples - Dot Net Tutorials. https://dotnettutorials.net/lesson/open-closed-principle/.
(5) Open Closed Principle in Java with Examples - GeeksforGeeks. https://www.geeksforgeeks.org/open-closed-principle-in-java-with-examples/.