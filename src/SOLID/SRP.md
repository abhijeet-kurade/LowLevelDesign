### Single Responsibility Principle (SRP)

This principle emphasizes that a class or module should have **one, and only one, well-defined responsibility**. When designing your code, you want to avoid creating monolithic components that handle multiple unrelated tasks. Instead, break down complex functionality into smaller, focused pieces.

Here's an example using pseudocode to illustrate SRP:

```pseudocode
class Invoice {
    public void AddInvoice() {
        // Logic for adding an invoice
    }

    public void DeleteInvoice() {
        // Logic for deleting invoices
    }

    public void GenerateReport() {
        // Logic for generating a report
    }

    public void EmailReport() {
        // Logic for emailing the report
    }
}
```

In this example, the `Invoice` class has four methods: `AddInvoice()`, `DeleteInvoice()`, `GenerateReport()`, and `EmailReport()`. Each method has a specific responsibility:
- `AddInvoice()` adds an invoice to the system.
- `DeleteInvoice()` handles invoice deletion.
- `GenerateReport()` generates a report.
- `EmailReport()` sends the report via email.

However, if we analyze the `Invoice` class as a whole, it violates SRP because it takes care of multiple responsibilities. To adhere to SRP, we can split these methods into separate classes, each responsible for a single task. For instance:

```pseudocode
class InvoiceManager {
    public void AddInvoice() {
        // Logic for adding an invoice
    }

    public void DeleteInvoice() {
        // Logic for deleting invoices
    }
}

class ReportGenerator {
    public void GenerateReport() {
        // Logic for generating a report
    }

    public void EmailReport() {
        // Logic for emailing the report
    }
}
```

Now we have two classes: `InvoiceManager` and `ReportGenerator`. Each class has a clear responsibility, adhering to SRP. By following this principle, you enhance code maintainability, readability, and flexibility. If changes are needed, you'll know exactly where to look without affecting unrelated functionality¹³.
