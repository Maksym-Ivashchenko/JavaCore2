package lessons;

import java.util.concurrent.Semaphore;

public class Oxygen extends Thread {
        //private static final Semaphore sem = new Semaphore(1);
        int num = 0;
        String id;
        Oxygen(String id)
        {
            //this.sem=sem;
            this.id=id;
        }

        public void run()
        {
            try
            {
                while(num<1)
                {
                    //sem.acquire();
                    //System.out.println (id);
                    sleep(500);
                    num++;
                    System.out.println (id);
                   // sem.release();
                    sleep(500);
                }
            }
            catch(InterruptedException e)
            {
                System.out.println ("у " + id + " проблемы");
            }
        }
    }


