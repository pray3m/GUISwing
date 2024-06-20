# Design Patterns in Swing

## 1. Observer (Event Listener) Pattern
Swing heavily relies on the Observer pattern, especially in event handling.

### Concept
- The **Observer pattern** defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

# Observer Pattern

The Observer Pattern defines a one-to-many relationship between objects, such that when one object (the "subject" or "observable") changes its state, all of its dependents ("observers") are notified and updated automatically.

## Key Components:
- **Observable (Subject)**: The object being observed. It maintains a list of observers and provides methods to add, remove, and notify them.
- **Observer**: An interface that defines the methods to be invoked when the observable changes its state.

## Workflow:
1. An observer subscribes (registers) with an observable to receive updates.
2. When the state of the observable changes, it notifies all its registered observers.
3. Each observer then takes appropriate action based on the update.

## Benefits:
- **Decoupling**: The observable is independent of its observers, and vice versa. This allows for modularity and separation of concerns.
- **Dynamic relationships**: Observers can be added or removed at runtime.

## Example in Java:

```java
import java.util.ArrayList;
import java.util.List;

// Observable
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer interface
interface Observer {
    void update();
}

// Concrete Observer
class BinaryObserver implements Observer {
    private Subject subject;

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary state: " + Integer.toBinaryString(subject.getState()));
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);

        System.out.println("Setting state to 5");
        subject.setState(5);
    }
}
```

### In Swing
- Swing components (`JButton`, `JTextField`, etc.) are the "subjects" (or "observables").
- Event listeners (`ActionListener`, `MouseListener`, etc.) act as the "observers".

### Example
```java
JButton button = new JButton("Click me");
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
});
```

## Model-View-Controller (MVC) Pattern in Swing

### Model

The **Model** represents data and the business logic. It's agnostic of the user interface. Changes in the user interface (View) won't affect the Model and vice versa.

## View
The **View** displays the data from the Model to the user and is the UI. It retrieves data from the Model for its display but doesn't interact directly with it.

## Controller
The **Controller** acts as an intermediary between the Model and the View. It processes user input from the View, potentially updates the Model, and then refreshes the View.

```

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Model
class DataModel {
    private DefaultListModel<String> listModel;

    public DataModel() {
        listModel = new DefaultListModel<>();
    }

    public void addItem(String item) {
        listModel.addElement(item);
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}

// View
class DataView {
    private JFrame frame;
    private JList<String> list;
    private JTextField textField;
    private JButton addButton;

    public DataView() {
        frame = new JFrame("MVC Demo");
        frame.setLayout(new BorderLayout());

        list = new JList<>();
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        addButton = new JButton("Add");
        frame.add(addButton, BorderLayout.SOUTH);

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void updateList(DefaultListModel<String> model) {
        list.setModel(model);
    }
}

// Controller
class DataController {
    private DataModel model;
    private DataView view;

    public DataController(DataModel model, DataView view) {
        this.model = model;
        this.view = view;

        initView();
    }

    private void initView() {
        view.updateList(model.getListModel());

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = view.getTextField().getText();
                model.addItem(input);
                view.updateList(model.getListModel());
                view.getTextField().setText("");
            }
        });
    }
}

// Driver
public class MVCDemo {
    public static void main(String[] args) {
        DataModel model = new DataModel();
        DataView view = new DataView();
        new DataController(model, view);
    }
}
```
