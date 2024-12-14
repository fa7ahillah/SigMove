import java.util.List;


public class TimeBasedExercise extends Exercise{
    private int duration;

    public TimeBasedExercise(int id, String name, int duration, List<String> targetArea, String description, String imagePath) {
        super(id, name, targetArea, description, imagePath);
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
        return "TimeBasedExercise{" + 
        "id=" + getID() + 
        ", name='" + getName() + '\'' + 
        ", duration=" + duration + 
        ", targetArea='" + getTargetArea() + '\'' + 
        ", description='" + getDescription() + '\'' + 
        '}';
    }
}