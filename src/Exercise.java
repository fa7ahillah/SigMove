public class Exercise {
    private int id;
    private String name;
    private int duration; 
    private int jumlahTarget; 
    private String targetArea;
    private String description;

    
    public Exercise(int id, String name, int duration, int jumlahTarget, String targetArea, String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.jumlahTarget = jumlahTarget;
        this.targetArea = targetArea;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getJumlahTarget() {
        return jumlahTarget;
    }

    public void setJumlahTarget(int jumlahTarget) {
        this.jumlahTarget = jumlahTarget;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", jumlahTarget=" + jumlahTarget +
                ", targetArea='" + targetArea + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
