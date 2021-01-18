package training.stage2.threads;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MainThreadTask {
    public static void main(String[] args) throws InterruptedException {

        BlockingDeque<Train> tunnelA = trainArraysCreatorOfFirstTunnel();
        BlockingDeque<Train> tunnelB = trainArraysCreatorOfSecondTunnel();

        BlockingDeque tunnelAMain = new LinkedBlockingDeque(1);
        BlockingDeque tunnelBMain = new LinkedBlockingDeque(1);

        ReentrantLock lockTunnelA = new ReentrantLock();
        ReentrantLock lockTunnelB = new ReentrantLock();

        new Thread(() -> {
            do {
                try {
                    lockTunnelA.lock();
                    if (!tunnelAMain.offer(tunnelA.element(), tunnelA.element().getTrainAcceptableWaitingTime(), TimeUnit.SECONDS)) {
                        System.out.println("");
                        System.out.println("Tunnel-1" + ": " + tunnelA.element().getTrainName() + " waiting time elapsed, redirected to another tunnel");
                        System.out.println("");
                        tunnelA.element().setTrainName(tunnelA.element().getTrainName() + "(redirected from " + "Tunnel-1" + ")");
                        tunnelB.put(tunnelA.take());

//                        tunnelB.put(tunnelA.element());
//                        tunnelA.remove(tunnelA.element());
                        continue;
                    }
                    new Thread(new TunnelThread(tunnelAMain, "Tunnel-1")).start();
                    tunnelA.removeFirst();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockTunnelA.unlock();
                }
            } while (tunnelA.size() != 0);
        }).start();

        new Thread(() -> {
            do {
                try {
                    lockTunnelB.lock();
                    if (!tunnelBMain.offer(tunnelB.element(), tunnelB.element().getTrainAcceptableWaitingTime(), TimeUnit.SECONDS)) {

                        System.out.println("");
                        System.out.println("Tunnel-2" + ": " + tunnelB.element().getTrainName() + " waiting time elapsed, redirected to another tunnel");
                        System.out.println("");

                        tunnelB.element().setTrainName(tunnelB.element().getTrainName() + "(redirected from " + "Tunnel-2" + ")");

                        tunnelA.put(tunnelB.take());

//                        tunnelA.put(tunnelB.element());
//                        tunnelB.remove(tunnelB.element());
                        continue;
                    }
                    new Thread(new TunnelThread(tunnelBMain, "Tunnel-2")).start();
                    tunnelB.removeFirst();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockTunnelB.unlock();
                }
            } while (tunnelB.size() != 0);
        }).start();
    }

    private synchronized static BlockingDeque<Train> trainArraysCreatorOfFirstTunnel() throws InterruptedException {
        BlockingDeque tunnel = new LinkedBlockingDeque();
        tunnel.put(new Train(20, 3, "Train-1", "Tunnel-1"));
        tunnel.put(new Train(6, 21, "Train-2", "Tunnel-1"));
        tunnel.put(new Train(8, 5, "Train-3", "Tunnel-1"));
        tunnel.put(new Train(5, 9, "Train-4", "Tunnel-1"));
//        tunnel.put(new Train(4, 6, "Train-5", "Tunnel-1"));
        return tunnel;
    }

    private synchronized static BlockingDeque trainArraysCreatorOfSecondTunnel() throws InterruptedException {
        BlockingDeque tunnel = new LinkedBlockingDeque();
        tunnel.put(new Train(15, 3, "Train-1", "Tunnel-2"));
        tunnel.put(new Train(6, 16, "Train-2", "Tunnel-2"));
        tunnel.put(new Train(8, 7, "Train-3", "Tunnel-2"));
        tunnel.put(new Train(5, 9, "Train-4", "Tunnel-2"));
        return tunnel;
    }
}
