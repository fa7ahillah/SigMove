import java.util.List;

public abstract class Exercise {
    private int id;
    private String name, description, imagePath;
    private List<String> targetArea;
    
    public Exercise(int id, String name, List<String> targetArea, String description, String imagePath) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.targetArea = targetArea;
        this.imagePath = imagePath;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(List<String> targetArea) {
        this.targetArea = targetArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Exercise{" + 
            "id=" + id + 
            ", name='" + name + '\'' + 
            ", targetArea='" + targetArea + '\'' + 
            ", description='" + description + '\'' + 
            ", imagePath='" + imagePath + '\'' + 
            '}';    
    }
}
