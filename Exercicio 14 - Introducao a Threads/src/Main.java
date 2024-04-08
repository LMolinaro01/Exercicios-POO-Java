public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new threadEx()); //criei uma nova thread

        System.out.println("Estado atual da thread: " + thread.getState()); //Estado atual (não foi iniciada)
        thread.start(); //thread iniciada (RUNNABLE -> Executável), ela está em execução ou pronta para ser executada

        System.out.println("Novo Estado da thread: " + thread.getState());
        try{
            thread.join(); //espera a thread completar sua execução
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        //Terminated -> término da execução
        System.out.println("Estado final da thread: " + thread.getState());
    }

}