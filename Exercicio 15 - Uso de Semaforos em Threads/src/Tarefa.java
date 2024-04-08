import java.util.concurrent.Semaphore;

class Tarefa implements Runnable{
    private String nome;
    private Semaphore semaphore;

    public Tarefa(Semaphore semaphore, String nome){
        this.semaphore = semaphore;
        this.nome = nome;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void run(){
        try{
            System.out.println(nome + " tentando adquirir a permissão.");
            semaphore.acquire();
            System.out.println(nome + " obteve a permissão.");

            //simulação de um trabalho feito pela thread
            Thread.sleep(2000);

        } catch (InterruptedException e){
            e.printStackTrace();
        } finally{
            //libera a permição (sinal verde)
            System.out.println(nome + " liberando a permissão.");
            semaphore.release();
        }
    }

    @Override
    public String toString(){
        return "Nome: " + getNome();
    }
}