package hw12;

import static java.lang.Thread.sleep;

public class Hydrogen implements Runnable{
    //private static final CyclicBarrier BARRIER = new CyclicBarrier(3);

  //  private static final Semaphore sem = new Semaphore(2); // семафор. ограничивающий число философов
        int num = 0; // кол-во приемов пищи
        String id; // условный номер философа
        // в качестве параметров конструктора передаем идентификатор философа и семафор
        Hydrogen(String id)
        {
            //this.sem=sem;
            this.id=id;
        }
        @Override
        public void run()
        {
            try
            {

                    //Запрашиваем у семафора разрешение на выполнение
                  //  sem.acquire();
                    //System.out.println (id);
                    // философ ест
                    sleep(500);
                    num++;
                    //BARRIER.await();
                    System.out.println (id);
                  //  sem.release();

                    // философ гуляет
                    sleep(500);

            }
            catch(InterruptedException e)
            {
                System.out.println ("у " + id + " проблемы");
            }
        }
}
