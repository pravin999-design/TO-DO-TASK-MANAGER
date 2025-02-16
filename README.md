# TO-DO-TASK-MANAGER
 #simple yet effective task management tool built with JavaScript. Easily add, complete, and remove tasks using basic console commands. 🚀
// QuickTask Manager - Simple To-Do List App

const tasks = [];

function addTask(task) {
    tasks.push({ text: task, completed: false });
    console.log(`Added: ${task}`);
}

function removeTask(index) {
    if (index >= 0 && index < tasks.length) {
        console.log(`Removed: ${tasks[index].text}`);
        tasks.splice(index, 1);
    } else {
        console.log("Invalid task index.");
    }
}

function completeTask(index) {
    if (index >= 0 && index < tasks.length) {
        tasks[index].completed = true;
        console.log(`Completed: ${tasks[index].text}`);
    } else {
        console.log("Invalid task index.");
    }
}

function listTasks() {
    console.log("Your Tasks:");
    tasks.forEach((task, index) => {
        console.log(`${index + 1}. [${task.completed ? '✔' : ' '}] ${task.text}`);
    });
}

// Example Usage
addTask("Finish GitHub project");
addTask("Review pull requests");
listTasks();
completeTask(0);
listTasks();
removeTask(1);
listTasks();
