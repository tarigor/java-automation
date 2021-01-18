package training.stage2.threads;

import java.time.LocalTime;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class TunnelThread implements Runnable {

    private BlockingDeque<Train> train;
    private String tunnelName;

    public TunnelThread(BlockingDeque<Train> train, String tunnelName) {

        this.train = train;
        this.tunnelName = tunnelName;
    }

    public synchronized void run() {
        try {
            Thread.currentThread().setName(tunnelName+": "+train.element().getTrainName());

            System.out.println(tunnelName + ": " + train.element().getTrainName() + " Thread started" + " Time:" + LocalTime.now());
            System.out.println(tunnelName + ": " + train.element().getTrainName() + " Travel time:" + train.element().getTrainTravelTime() + "s");
            TimeUnit.MILLISECONDS.sleep(train.element().getTrainTravelTime() * 1000);
            System.out.println(tunnelName + ": " + "passed:" + train.takeFirst().getTrainName() + " Time:" + LocalTime.now());
            System.out.println("");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
