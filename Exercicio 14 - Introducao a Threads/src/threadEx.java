class threadEx implements Runnable {
    @Override
    public void run() {
        //thread em execução (RUNNABLE)
        System.out.println("Estado da thread: " + Thread.currentThread().getState());
        try{
            //TIME_WAITING -> thread esperando um tempo
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println("Um erro ocorreu.");
            e.printStackTrace();
        }
        System.out.println("Estado final da thread: " + Thread.currentThread().getState()); //thread terminada
    }
}
