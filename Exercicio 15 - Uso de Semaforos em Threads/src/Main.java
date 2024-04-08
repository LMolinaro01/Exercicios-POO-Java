import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        //criação de um semáforo com uma permiçãp
        Semaphore semaphore = new Semaphore(1);

        //criação das threads
        Thread thread = new Thread(new Tarefa(semaphore, "Thread 1"));
        Thread thread2 = new Thread(new Tarefa(semaphore, "Thread 2"));

        thread.start();
        thread2.start();

    }
}
