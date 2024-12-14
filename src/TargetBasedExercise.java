import java.util.List;

public class TargetBasedExercise extends Exercise {
    private int jumlahTarget;

    public TargetBasedExercise(int id, String name, int jumlahTarget, List<String> targetArea, String description, String imagePath) {
        super(id, name, targetArea, description, imagePath);
        this.jumlahTarget = jumlahTarget;
    }

    public int getJumlahTarget() {
        return jumlahTarget;
    }

    public void setJumlahTarget(int jumlahTarget) {
        this.jumlahTarget = jumlahTarget;
    }

    @Override
    public String toString() {
        return "TargetBasedExercise{" +
                "id=" + getID() +
                ", name='" + getName() + '\'' +
                ", jumlahTarget=" + jumlahTarget +
                ", targetArea='" + getTargetArea() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
