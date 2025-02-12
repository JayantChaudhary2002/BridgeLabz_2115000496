class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;

    public TaskScheduler() {
        head = null;
    }

    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            head = newTask;
            temp.next = head;
        }
    }

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
            if (current == head) {
                System.out.println("Position not found.");
                return;
            }
        }
        newTask.next = current.next;
        current.next = newTask;
    }

    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current = head;
        Task prev = null;
        do {
            if (current.taskId == taskId) {
                if (prev == null) {
                    Task temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = current.next;
                    temp.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with Task ID " + taskId + " not found.");
    }

    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + " (Task ID: " + head.taskId + ")");
    }

    public void moveToNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        head = head.next;
        System.out.println("Next Task: " + head.taskName + " (Task ID: " + head.taskId + ")");
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    public Task searchTaskByPriority(int priority) {
        if (head == null) {
            return null;
        }
        Task current = head;
        do {
            if (current.priority == priority) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtBeginning(1, "Task 1", 1, "2025-02-20");
        scheduler.addTaskAtEnd(2, "Task 2", 2, "2025-02-21");
        scheduler.addTaskAtEnd(3, "Task 3", 3, "2025-02-22");

        scheduler.displayAllTasks();

        scheduler.addTaskAtPosition(4, "Task 4", 1, "2025-02-23", 2);

        scheduler.displayAllTasks();

        scheduler.removeTaskById(2);

        scheduler.displayAllTasks();

        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.moveToNextTask();

        Task task = scheduler.searchTaskByPriority(1);
        if (task != null) {
            System.out.println("Found Task with Priority 1: " + task.taskName);
        } else {
            System.out.println("No task found with Priority 1.");
        }
    }
}
