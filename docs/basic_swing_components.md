# Text Input in Swing

## Introduction
In Java's Swing framework, text input components play a fundamental role in user interaction. Whether it's for a simple login form, a text editor, or a search field, Swing provides a variety of components tailored to different input needs. These components facilitate the acquisition of textual data from users, which can be processed, stored, or displayed as per application requirements.

## Characteristics

- **Flexibility**: Swing text components can handle everything from plain text to styled content like HTML.
- **Interactivity**: These components can be combined with listeners to respond immediately to user actions or inputs.
- **Customizability**: The look and feel of text input components can be customized using various methods, including using custom UIs and painting routines.
- **Data Security**: For sensitive input, like passwords, Swing provides components that can mask entered data.
- **Extensibility**: The Swing text components' behavior can be extended, and their properties can be tailored to specific needs.

## Types

### 1. `JTextField`
- **Description**: A single-line textbox ideal for short textual input.
- **Example**:
  ```java
  JTextField textField = new JTextField(20);  // 20 columns wide
  frame.add(textField);
  ```

### 2. `JPasswordField`
- **Description**: A text field specialized for password entry. It conceals the actual characters typed.
- **Example**:
  ```java
  JPasswordField passwordField = new JPasswordField(20);
  frame.add(passwordField);
  ```

### 3. `JTextArea`
- **Description**: A multiline text area suitable for larger text input or display. Can be embedded in a scroll pane for added functionality.
- **Example**:
  ```java
  JTextArea textArea = new JTextArea(5, 20);  // 5 rows and 20 columns
  JScrollPane scrollPane = new JScrollPane(textArea);
  frame.add(scrollPane);
  ```

### 4. `JEditorPane`
- **Description**: A versatile text component capable of editing plain text, RTF, and HTML content.
- **Example**:
  ```java
  JEditorPane editorPane = new JEditorPane();
  editorPane.setContentType("text/html");
  editorPane.setText("<h1>Hello, Swing!</h1><p>This is HTML content.</p>");
  frame.add(new JScrollPane(editorPane));
  ```

Each of these text input types in Swing serves a distinct purpose and is geared towards specific use cases. Choosing the right one depends on the requirements of the application being developed.

# TextFields in Swing

## Introduction
`JTextField` is one of the most commonly used components in Java Swing for gathering text input from the user. It provides a single-line area for the user to input text.

## Characteristics
- **Single Line Input**: `JTextField` is ideal for single-line input, like usernames, search queries, or any short text input.
- **Customizable Size**: The size of the field can be defined by the number of columns it should display.
- **Event Handling**: Action listeners can be added to respond to events, such as when the user presses the Enter key.
- **Text Manipulation**: Methods like `getText()` and `setText(String t)` provide ways to retrieve and set the content of the text field respectively.

## Example

Here's a simple Swing example to demonstrate the use of `JTextField`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextField Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel label = new JLabel("Enter your name:");
        panel.add(label);
        
        JTextField textField = new JTextField(20);
        panel.add(textField);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                JOptionPane.showMessageDialog(frame, "Hello, " + name + "!");
            }
        });
        panel.add(button);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
```

# PasswordFields in Swing

## Introduction
`JPasswordField` is a Swing component used for inputting sensitive data such as passwords. It inherits from `JTextField` but masks the entered text for added security. Typically, the characters entered into a `JPasswordField` are replaced by asterisks (`*`) or dots to conceal the password from prying eyes.

## Characteristics
- **Text Masking**: By default, `JPasswordField` masks entered characters with a dot (`•`). You can change this masking character if needed.
- **Character Retrieval**: It provides a method `getPassword()` which returns the password as a char array instead of a string for security reasons. It is recommended to handle password data as char array and then clear it as soon as it's not needed to minimize the time it stays in memory.
- **Text Manipulation**: Like `JTextField`, it provides the `setText(String t)` method, but caution should be exercised when using it with sensitive data.
- **Event Handling**: Similar to `JTextField`, action listeners can be added to respond to user actions.

## Example

Here's a simple Swing example to demonstrate the use of `JPasswordField`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordFieldExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JPasswordField Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel label = new JLabel("Enter your password:");
        panel.add(label);
        
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                // Handle password. Here, just displaying length for demonstration.
                JOptionPane.showMessageDialog(frame, "Password length: " + password.length);
                // Clear the password char array for security
                java.util.Arrays.fill(password, '0');
            }
        });
        panel.add(button);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
```

# TextAreas in Swing

## Introduction
`JTextArea` is a multi-line area in Java Swing that allows users to enter or display plain text. It's suitable for larger chunks of text, such as comments, descriptions, or any form of multiline input.

## Characteristics
- **Multiline Input**: Unlike `JTextField`, which is for single-line input, `JTextArea` supports multiline text entry.
- **Scrolling**: Often wrapped inside a `JScrollPane` to provide scroll bars when the text exceeds the visible area.
- **Text Manipulation**: Methods like `append(String text)`, `getText()`, and `setText(String t)` are available to manage the text within the area.
- **Line Wrapping**: Provides the capability to set line wrapping, ensuring that lines are wrapped at word boundaries.
- **Editable & Non-Editable**: You can make a `JTextArea` non-editable, which is useful for displaying logs or other text-based outputs that users shouldn't modify.

## Example

Here's a simple Swing example demonstrating the use of `JTextArea`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextArea Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JTextArea textArea = new JTextArea(10, 30); // 10 rows, 30 columns
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        
        JButton button = new JButton("Display Text");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, textArea.getText());
            }
        });
        panel.add(button);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
```

# JScrollPane in Swing

## Introduction
`JScrollPane` is a component in Java Swing that provides a scrollable view of another component. When the visible area of the contained component is smaller than the component itself, scroll bars become available, allowing users to navigate through the full content.

## Characteristics
- **Viewport**: The visible part of the contained component is referred to as the viewport.
- **Scroll Bars**: Horizontal and/or vertical scroll bars are provided based on the size of the content relative to the viewport. They can be set to always appear, never appear, or appear only when necessary.
- **Adjustable Viewing Area**: The size of the viewport can be adjusted, which in turn affects when the scroll bars appear.
- **Compatibility**: `JScrollPane` can work with various components, most commonly with `JTextArea`, `JTable`, `JList`, and `JTree`.

## Example

Here's a simple Swing example to demonstrate the use of `JScrollPane`:

```java
import javax.swing.*;
import java.awt.*;

public class ScrollPaneExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JScrollPane Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a long content for JTextArea
        String longText = "This is a long text that exceeds the visible area of the JFrame.\n";
        for (int i = 0; i < 20; i++) {
            longText += longText;
        }

        JTextArea textArea = new JTextArea(longText);
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
```

# JLabel in Swing

## Introduction
`JLabel` is a lightweight Swing component used to display a short piece of text, an image, or both. It doesn't react to user input, making it ideal for labelling other user interface components.

## Characteristics
- **Text Display**: Can display a single line of text. For multiline text, HTML formatting can be utilized.
- **Image Display**: Can display an icon (usually an `ImageIcon`) alongside or instead of text.
- **Alignment**: Both text and image can be aligned horizontally and vertically within the label's borders.
- **Tooltips**: Tooltips can be associated with a `JLabel` to provide additional information when the user hovers over it.
- **Labelling Components**: One common use of `JLabel` is to label other components, especially components that don't display their own labels, such as `JTextField`.

## Example

Here's a simple Swing example to demonstrate the use of `JLabel`:

```java
import javax.swing.*;
import java.awt.*;

public class LabelExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);
        
        // Associating JLabel with JTextField using setLabelFor()
        label.setLabelFor(textField);

        frame.add(label);
        frame.add(textField);
        frame.setVisible(true);
    }
}
```

# Choice Components in Swing

## Definition
Choice components in Swing offer a way to make selections or choices within a user interface. They present multiple options to the user, from which one or several can be chosen based on the nature of the component.

## Types

### 1. Check Boxes (`JCheckBox`)
- **Definition**: A `JCheckBox` represents an on/off or true/false choice. Multiple check boxes can be selected simultaneously.
- **Usage**: Often used when the user is allowed to make multiple selections from a set of options.

### 2. Radio Buttons (`JRadioButton`)
- **Definition**: A `JRadioButton` allows a single choice from a set of options. Radio buttons are typically grouped together using the `ButtonGroup` class, ensuring that only one can be selected at a time.
- **Usage**: Suitable when only one option needs to be selected from a group.

### 3. Combo Boxes (`JComboBox`)
- **Definition**: A `JComboBox` provides a drop-down list of items from which users can select. It can be both non-editable (select only) and editable (allowing custom input).
- **Usage**: Used when the user needs to choose from a predefined list of options, with optional custom input in the case of an editable combo box.

### 4. Sliders (`JSlider`)
- **Definition**: A `JSlider` represents a range of values through a draggable knob. The user can select a value by moving this knob along the range.
- **Usage**: Often used for adjusting settings that have a range, like volume or brightness controls.

## Note
All these components provide mechanisms to add listeners, which allow developers to respond to user choices and selections programmatically.

# Check Boxes (`JCheckBox`) in Swing

## Definition
A `JCheckBox` is a graphical user interface component in Java Swing that represents an on/off or true/false choice. It offers a box that can be either checked (selected) or unchecked (deselected). Multiple check boxes can be selected simultaneously, making them suitable for scenarios where multiple options can be chosen at once.

## Example

The following is a basic Java Swing program that demonstrates the use of `JCheckBox`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCheckBoxExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JCheckBox Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JCheckBox checkBox1 = new JCheckBox("Option 1");
        JCheckBox checkBox2 = new JCheckBox("Option 2");
        JCheckBox checkBox3 = new JCheckBox("Option 3");

        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder result = new StringBuilder("Selected Options: ");
                if (checkBox1.isSelected()) {
                    result.append("Option 1, ");
                }
                if (checkBox2.isSelected()) {
                    result.append("Option 2, ");
                }
                if (checkBox3.isSelected()) {
                    result.append("Option 3");
                }
                JOptionPane.showMessageDialog(frame, result.toString());
            }
        });

        frame.add(checkBox1);
        frame.add(checkBox2);
        frame.add(checkBox3);
        frame.add(button);

        frame.setVisible(true);
    }
}
```

# Radio Buttons (`JRadioButton`) in Swing

## Definition
A `JRadioButton` is a graphical user interface component in Java Swing that allows a user to choose one option from a set of options. Radio buttons are typically grouped together using the `ButtonGroup` class, ensuring that only one can be selected at a time. This exclusivity makes them suitable for scenarios where only one option should be chosen from a group.

## Example

Here's a basic Java Swing program demonstrating the use of `JRadioButton`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JRadioButtonExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JRadioButton Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JRadioButton option1 = new JRadioButton("Option 1");
        JRadioButton option2 = new JRadioButton("Option 2");
        JRadioButton option3 = new JRadioButton("Option 3");

        // Grouping the radio buttons to ensure only one can be selected
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = "";
                if (option1.isSelected()) {
                    selectedOption = "Option 1";
                } else if (option2.isSelected()) {
                    selectedOption = "Option 2";
                } else if (option3.isSelected()) {
                    selectedOption = "Option 3";
                }
                JOptionPane.showMessageDialog(frame, "Selected: " + selectedOption);
            }
        });

        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(submitButton);

        frame.setVisible(true);
    }
}
```
# Borders in Swing

## Definition
In Java Swing, a border is an aesthetic and functional decoration around a Swing component. The `javax.swing.border` package provides a range of border styles that can be applied to Swing components, adding visual cues and separation between elements. Borders can encapsulate just about any Swing component, from simple labels to more complex panels.

## Common Types of Borders:

1. **LineBorder**: A simple line border around a component.
2. **EtchedBorder**: Gives the effect of the component being either lowered or raised depending on the type specified.
3. **BevelBorder**: Similar to `EtchedBorder`, but with thicker lines giving a stronger 3D effect.
4. **TitledBorder**: Wraps another border and adds a title to it.
5. **CompoundBorder**: A combination of two borders.

## Example:

Below is a simple example showcasing different border types:

```java
import javax.swing.*;
import javax.swing.border.*;

public class BordersExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Borders Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(5, 1));

        JButton btn1 = new JButton("LineBorder");
        btn1.setBorder(new LineBorder(Color.BLUE, 3));

        JButton btn2 = new JButton("EtchedBorder");
        btn2.setBorder(new EtchedBorder(EtchedBorder.RAISED));

        JButton btn3 = new JButton("BevelBorder");
        btn3.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JButton btn4 = new JButton("TitledBorder");
        btn4.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "Title"));

        JButton btn5 = new JButton("CompoundBorder");
        btn5.setBorder(new CompoundBorder(new LineBorder(Color.GREEN, 3), new BevelBorder(BevelBorder.RAISED)));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);

        frame.setVisible(true);
    }
}
```

# Combo Boxes (`JComboBox`) in Swing

## Definition
A `JComboBox` is a component in Java Swing that provides a drop-down list of items from which users can select. It allows users to select an item from a predefined list of options. The combo box can be both non-editable (select only) and editable (permitting user to input custom text in addition to selecting a predefined option).

## Characteristics

- **Drop-down List**: Displays a list of items when clicked.
- **Single Selection**: Allows only one item to be selected at a time.
- **Editable Option**: Can be configured to let users enter their own value.
- **Listeners**: Supports action listeners to detect when an item has been selected or the value has changed.

## Example

Here's a basic Java Swing program demonstrating the use of `JComboBox`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JComboBoxExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Create a JComboBox with a few items
        String[] items = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "Selected: " + selectedItem);
            }
        });

        frame.add(comboBox);
        frame.add(submitButton);
        
        frame.setVisible(true);
    }
}
```

# Sliders (`JSlider`) in Swing

## Definition
A `JSlider` is a component in Java Swing that lets users select a value from a range by sliding a knob within a bounded interval. Sliders can be oriented both horizontally and vertically, providing a visual and intuitive way for users to set values within a specified range.

## Characteristics

- **Range**: The slider has a minimum, maximum, and a current value.
- **Orientation**: Can be displayed either horizontally or vertically.
- **Ticks**: Can be configured to display major and minor tick marks.
- **Labels**: Supports labeling at major tick marks.
- **Listeners**: Supports change listeners to detect when the value of the slider has changed.

## Example

Here's a simple Java Swing program demonstrating the use of `JSlider`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class JSliderExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JSlider Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create a JSlider with range from 0 to 100, initial value set to 50
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        
        // Add major and minor ticks to the slider
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel label = new JLabel("Selected Value: 50");
        
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = ((JSlider) e.getSource()).getValue();
                label.setText("Selected Value: " + value);
            }
        });

        frame.add(slider);
        frame.add(label);
        
        frame.setVisible(true);
    }
}
```
# Menus in Swing

## Introduction
Menus in Java Swing provide a structured way to organize commands, options, and actions in a user interface. They are crucial for reducing clutter, especially in applications with numerous functions. Menus often reside at the top of a window (in a menu bar) but can also be used in other contexts, such as context (right-click) menus.

## Types of Menus

# Menu Building in Java Swing

## Introduction
Building menus in Java Swing applications is a systematic process that involves creating menu items, adding them to menus, and then adding those menus to a menu bar. Menus are essential for organizing the features and functionalities of an application, providing an intuitive navigation system.


1. **Create a Menu Bar (`JMenuBar`)**: This acts as the container for all your menus.
2. **Define Menus (`JMenu`)**: Create main categories like "File", "Edit", "Help", etc.
3. **Add Menu Items (`JMenuItem`)**: These are the individual commands or options within a `JMenu`.
4. **Add Optional Submenus**: Menus can be nested to provide a hierarchical structure.
5. **Add Action Listeners**: To make menus interactive, you'll often attach action listeners to individual menu items.
6. **Add the Menu Bar to a Frame**: Finally, the `JMenuBar` is added to the `JFrame` to display it in your application.

## Example

Here's a basic menu structure for a hypothetical text editor:

```java
import javax.swing.*;
import java.awt.event.*;

public class MenuExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Building Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        
        // Create and add menu items to the "File" menu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        
        // Create and add menu items to the "Edit" menu
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        
        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);
        
        frame.setVisible(true);
    }
}
```
# Adding Icons to Menu Items in Java Swing

## Introduction

In Java Swing, you can enhance `JMenuItem`s with icons for a more visually descriptive and interactive user experience. This is often seen in applications where icons alongside text provide a quick visual reference for functionalities.

## Steps to Add Icons to Menu Items

1. **Prepare the Icon**: Ensure you have an icon image file (e.g., `.png`, `.jpg`, `.gif`) available and added to your project resources.
2. **Create an ImageIcon**: Use the `ImageIcon` class to load your icon.
3. **Add the ImageIcon to JMenuItem**: When creating a `JMenuItem`, you can provide the `ImageIcon` as an argument or set it later using the `setIcon` method.

## Example

Here's a basic example to demonstrate adding icons to menu items:

```java
import javax.swing.*;

public class IconMenuExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Icon on Menu Items Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // Create a menu
        JMenu fileMenu = new JMenu("File");
        
        // Load icons
        ImageIcon newIcon = new ImageIcon("path/to/new_icon.png");
        ImageIcon openIcon = new ImageIcon("path/to/open_icon.png");
        
        // Create menu items with icons
        JMenuItem newItem = new JMenuItem("New", newIcon);
        JMenuItem openItem = new JMenuItem("Open", openIcon);
        
        // Add menu items to the menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        
        // Add menu to the menu bar
        menuBar.add(fileMenu);
        
        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);
        
        frame.setVisible(true);
    }
}
```

# CheckBox and Radio Buttons in Menu Items

## Introduction

Menus in Java Swing applications aren't limited to just simple actionable items. They can also contain checkboxes and radio buttons to offer more interactive options. This allows users to select one or multiple choices directly from the menus.

## CheckBox Menu Items (`JCheckBoxMenuItem`)

A `JCheckBoxMenuItem` acts just like a regular checkbox but is situated within a menu. Users can select or deselect it.

### Example:

```java
import javax.swing.*;

public class CheckBoxMenuItemExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBox in Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");

        JCheckBoxMenuItem showGridItem = new JCheckBoxMenuItem("Show Grid");
        optionsMenu.add(showGridItem);

        menuBar.add(optionsMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}
```

## Radio Button Menu Items (`JRadioButtonMenuItem`)
A `JRadioButtonMenuItem` behaves like a regular radio button, which allows users to select one option from a group.

### Example

```
import javax.swing.*;

public class RadioButtonMenuItemExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Radio Button in Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JMenuBar menuBar = new JMenuBar();
        JMenu themeMenu = new JMenu("Theme");

        JRadioButtonMenuItem lightThemeItem = new JRadioButtonMenuItem("Light");
        JRadioButtonMenuItem darkThemeItem = new JRadioButtonMenuItem("Dark");

        ButtonGroup themeGroup = new ButtonGroup();
        themeGroup.add(lightThemeItem);
        themeGroup.add(darkThemeItem);

        themeMenu.add(lightThemeItem);
        themeMenu.add(darkThemeItem);

        menuBar.add(themeMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}
```