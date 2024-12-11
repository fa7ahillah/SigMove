import java.util.ArrayList;
import java.util.List;

public class WorkoutProgram {
    private String programName; 
    private List<Exercise> exercises; 

    // Constructor
    public WorkoutProgram(String programName) {
        this.programName = programName;
        this.exercises = new ArrayList<>();
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }


    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }


    public List<Exercise> getExercises() {
        return new ArrayList<>(exercises);
    }

    // Tampilkan detail program
    public void displayProgramDetails() {
        System.out.println("Program: " + programName);
        if (exercises.isEmpty()) {
            System.out.println("Tidak ada latihan dalam program ini.");
        } else {
            System.out.println("Daftar latihan:");
            for (int i = 0; i < exercises.size(); i++) {
                Exercise exercise = exercises.get(i);
                System.out.println((i + 1) + ". " + exercise.getName() + " - " + exercise.getDuration() + " detik");
            }
        }
    }
}
