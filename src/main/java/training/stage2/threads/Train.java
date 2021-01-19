package training.stage2.threads;

public class Train {
    private int trainTravelTime;
    private int trainAcceptableWaitingTime;
    private String trainName;
    private String tunnelName;

    public Train(int trainTravelTime, int trainAcceptableWaitingTime, String trainName, String tunnelName) {
        this.trainTravelTime = trainTravelTime;
        this.trainAcceptableWaitingTime = trainAcceptableWaitingTime;
        this.trainName = trainName;
        this.tunnelName = tunnelName;
    }

    public int getTrainTravelTime() {
        return trainTravelTime;
    }

    public int getTrainAcceptableWaitingTime() {
        return trainAcceptableWaitingTime;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
