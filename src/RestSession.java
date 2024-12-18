public class RestSession extends Exercise {
    private int duration; // Durasi istirahat dalam detik

    public RestSession(int id, int duration) {
        super(id, "Istirahat", null, "Istirahat selama " + duration + " detik", null);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "RestSession{" +
                "id=" + getID() +
                ", duration=" + duration +
                '}';
    }
}
