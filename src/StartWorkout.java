import java.util.List;

public class StartWorkout {
    private List<Exercise> exercises;
    private int currentExerciseIndex;
    private boolean isWorkoutActive;
    private int totalCalories;
    private long startTime; // Waktu mulai latihan
    private long endTime; // Waktu selesai latihan
    private WorkoutGUI workoutGUI;

    public StartWorkout(List<Exercise> exercises, WorkoutGUI workoutGUI) {
        this.exercises = exercises;
        this.currentExerciseIndex = 0;
        this.isWorkoutActive = false;
        this.totalCalories = 0;
        this.startTime = 0;
        this.endTime = 0;
        this.workoutGUI = workoutGUI;
    }

    public void startWorkout() {
        if (!exercises.isEmpty()) {
            isWorkoutActive = true;
            currentExerciseIndex = 0;
            startTime = System.currentTimeMillis(); // Catat waktu mulai
            startExercise(exercises.get(currentExerciseIndex));
        } else {
            System.out.println("No exercises available to start the workout.");
        }
    }

    public void nextExercise() {
        if (isWorkoutActive && currentExerciseIndex < exercises.size() - 1) {
            Exercise currentExercise = exercises.get(currentExerciseIndex);
            if (currentExercise instanceof TimeBasedExercise) {
                TimeBasedExercise timeBasedExercise = (TimeBasedExercise) currentExercise;
                totalCalories += calculateCalories(timeBasedExercise.getDuration());
            }
            currentExerciseIndex++;
            startExercise(exercises.get(currentExerciseIndex));
        } else {
            endWorkout();
        }
    }

    private int calculateCalories(int duration) {
        return (duration / 60) * 5;
    }

    public void endWorkout() {
        isWorkoutActive = false;
        endTime = System.currentTimeMillis(); // Catat waktu selesai
        System.out.println("Workout completed. Great job!");
        if (workoutGUI != null) {
            workoutGUI.showWorkoutResult(getWorkoutResult());
        }
    }

    public WorkoutResult getWorkoutResult() {
        long totalTime = (endTime - startTime) / 1000; // Total waktu dalam detik
        return new WorkoutResult(exercises.size(), totalCalories, (int) totalTime);
    }

    private void startExercise(Exercise exercise) {
        System.out.println("Starting exercise: " + exercise.getName());
    }

    public boolean isWorkoutActive() {
        return isWorkoutActive;
    }

    public int getCurrentExerciseIndex() {
        return currentExerciseIndex;
    }

    public Exercise getCurrentExercise() {
        if (currentExerciseIndex < exercises.size()) {
            return exercises.get(currentExerciseIndex);
        }
        return null;
    }
}
    