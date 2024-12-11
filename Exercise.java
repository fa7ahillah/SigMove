public class Exercise {
    private String name;
    private int duration; // Durasi dalam detik

    // Constructor
    public Exercise(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
