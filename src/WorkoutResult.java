public class WorkoutResult {
    private int totalExercises;
    private int totalCalories;
    private int totalTime; 

    public WorkoutResult(int totalExercises, int totalCalories, int totalTime) {
        this.totalExercises = totalExercises;
        this.totalCalories = totalCalories;
        this.totalTime = totalTime;
    }

    public int getTotalExercises() {
        return totalExercises;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public int getTotalTime() {
        return totalTime;
    }
}
