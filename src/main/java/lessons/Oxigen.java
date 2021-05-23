package lessons;

import java.util.concurrent.Semaphore;

public class Oxigen extends Thread {
        Semaphore sem;
        int num = 0;
        String id = "O";
        Oxigen(Semaphore sem)
        {
            this.sem=sem;
            //this.id=id;
        }

        public void run()
        {
            try
            {
                while(num<1)
                {
                    sem.acquire();
                    //System.out.println (id);
                    sleep(500);
                    num++;
                    System.out.println (id);
                    sem.release();
                    sleep(500);
                }
            }
            catch(InterruptedException e)
            {
                System.out.println ("у " + id + " проблемы");
            }
        }
    }


