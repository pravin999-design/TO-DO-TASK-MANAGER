package com.example.todoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText taskInput;
    Button addTaskButton;
    ListView taskListView;
    ArrayList<String> taskList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        addTaskButton = findViewById(R.id.addTaskButton);
        taskListView = findViewById(R.id.taskListView);

        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(adapter);

        addTaskButton.setOnClickListener(v -> {
            String task = taskInput.getText().toString();
            if (!task.isEmpty()) {
                taskList.add(task);
                adapter.notifyDataSetChanged();
                taskInput.setText("");
            } else {
                Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        taskListView.setOnItemLongClickListener((adapterView, view, position, id) -> {
            taskList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}
