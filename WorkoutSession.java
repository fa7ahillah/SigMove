import java.util.ArrayList;
import java.util.List;

public class WorkoutSession {
    private List<String> exercises; 
    private List<Integer> durations; 
    private int currentExerciseIndex; 
    private boolean isRunning; 

    // Constructor
    public WorkoutSession(List<String> exercises, List<Integer> durations) {
        if (exercises.size() != durations.size()) {
            throw new IllegalArgumentException("Jumlah latihan dan durasi harus sama.");
        }
        this.exercises = new ArrayList<>(exercises);
        this.durations = new ArrayList<>(durations);
        this.currentExerciseIndex = 0;
        this.isRunning = false;
    }

    // Mulai sesi latihan
    public void start() {
        if (isRunning) {
            System.out.println("Latihan sudah berjalan.");
            return;
        }

        if (currentExerciseIndex >= exercises.size()) {
            System.out.println("Latihan selesai. Mulai ulang untuk mengulang sesi.");
            return;
        }

        isRunning = true;
        System.out.println("Mulai latihan: " + getCurrentExercise() + " selama " + getCurrentDuration() + " detik.");
    }

    // Hentikan sesi latihan
    public void stop() {
        if (!isRunning) {
            System.out.println("Latihan belum dimulai.");
            return;
        }

        isRunning = false;
        System.out.println("Latihan dihentikan pada: " + getCurrentExercise());
    }

    // Lanjut ke latihan berikutnya
    public void nextExercise() {
        if (currentExerciseIndex + 1 < exercises.size()) {
            currentExerciseIndex++;
            System.out.println("Latihan berikutnya: " + getCurrentExercise());
        } else {
            System.out.println("Semua latihan selesai!");
            resetSession();
        }
    }

    // Dapatkan latihan saat ini
    public String getCurrentExercise() {
        if (currentExerciseIndex < exercises.size()) {
            return exercises.get(currentExerciseIndex);
        }
        return null;
    }

    // Dapatkan durasi latihan saat ini
    public int getCurrentDuration() {
        if (currentExerciseIndex < durations.size()) {
            return durations.get(currentExerciseIndex);
        }
        return 0;
    }

    // Atur durasi latihan tertentu
    public void setDurationForExercise(int exerciseIndex, int duration) {
        if (exerciseIndex < 0 || exerciseIndex >= durations.size()) {
            throw new IllegalArgumentException("Indeks latihan tidak valid.");
        }
        durations.set(exerciseIndex, duration);
        System.out.println("Durasi untuk latihan \"" + exercises.get(exerciseIndex) + "\" diatur menjadi " + duration + " detik.");
    }

    // Atur semua durasi latihan
    public void setAllDurations(int duration) {
        for (int i = 0; i < durations.size(); i++) {
            durations.set(i, duration);
        }
        System.out.println("Semua durasi latihan diatur menjadi " + duration + " detik.");
    }

    // Reset sesi latihan
    public void resetSession() {
        currentExerciseIndex = 0;
        isRunning = false;
        System.out.println("Sesi latihan direset.");
    }

    // Periksa status sesi
    public boolean isRunning() {
        return isRunning;
    }
}
