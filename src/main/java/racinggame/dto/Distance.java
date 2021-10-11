package racinggame.dto;

public class Distance {

    private long distance;

    public Distance(long distance) {
        this.distance = distance;
    }
    public Distance() {
    }
    public void increaseDistance() {
        this.distance++;
    }
    public long getDistance() {
        return this.distance;
    }

    public boolean isSameDistance(Distance compare) {
        return this.distance == compare.distance;
    }
}
