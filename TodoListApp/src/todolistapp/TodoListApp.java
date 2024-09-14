package com.myapp.todolist;

import javax.swing.*;

public class TodoListUI extends JFrame {

    private JTextField taskField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public TodoListUI() {
        // Thiết lập JFrame
        setTitle("Todo List Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Khởi tạo các thành phần
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Thiết lập layout
        JPanel panel = new JPanel();
        panel.add(new JLabel("Task:"));
        panel.add(taskField);
        panel.add(addButton);
        add(new JScrollPane(taskList), "Center");
        add(panel, "South");

        // Thêm sự kiện cho nút Add
        addButton.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        // Khởi tạo và hiển thị giao diện người dùng
        new TodoListUI().setVisible(true);
    }
}
