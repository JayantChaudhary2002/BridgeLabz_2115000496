class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class CircularQueue {
    Process head;
    Process tail;
    int size;

    public CircularQueue() {
        head = tail = null;
        size = 0;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;  // Circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;  // Circular link
        }
        size++;
    }

    public boolean removeProcess(int processId) {
        if (head == null) return false;
        Process current = head;
        Process prev = null;

        do {
            if (current.processId == processId) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                    tail.next = head;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        return false;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Remaining Time: " + current.remainingTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public Process getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
}

public class RoundRobinScheduling {
    CircularQueue queue;
    int timeQuantum;

    public RoundRobinScheduling(int timeQuantum) {
        queue = new CircularQueue();
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        queue.addProcess(processId, burstTime, priority);
    }

    public void schedule() {
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;

        while (queue.getSize() > 0) {
            Process currentProcess = queue.getHead();

            if (currentProcess.remainingTime > timeQuantum) {
                currentProcess.remainingTime -= timeQuantum;
                totalWaitingTime += currentProcess.remainingTime;
                queue.addProcess(currentProcess.processId, currentProcess.remainingTime, currentProcess.priority);
                queue.removeProcess(currentProcess.processId);
            } else {
                totalTurnAroundTime += currentProcess.burstTime;
                totalWaitingTime += totalTurnAroundTime - currentProcess.burstTime;
                queue.removeProcess(currentProcess.processId);
                completedProcesses++;
            }

            queue.displayProcesses();
        }

        int avgWaitingTime = totalWaitingTime / completedProcesses;
        int avgTurnaroundTime = totalTurnAroundTime / completedProcesses;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void main(String[] args) {
        RoundRobinScheduling rrScheduler = new RoundRobinScheduling(4);

        rrScheduler.addProcess(1, 8, 1);
        rrScheduler.addProcess(2, 6, 2);
        rrScheduler.addProcess(3, 4, 3);
        rrScheduler.addProcess(4, 5, 4);

        rrScheduler.schedule();
    }
}
