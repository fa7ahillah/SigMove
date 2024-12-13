import java.util.ArrayList;
import java.util.List;

public class WorkoutSession {
    private List<Exercise> exercises; 
    private int currentExerciseIndex; 
    private boolean isRunning; 
    private int totalTime; 
    // Constructor
    public WorkoutSession(List<Exercise> exercises) {
        if (exercises.isEmpty()) {
            throw new IllegalArgumentException("Daftar latihan tidak boleh kosong.");
        }
        this.exercises = new ArrayList<>(exercises);
        this.currentExerciseIndex = 0;
        this.isRunning = false;
        this.totalTime = 0;
    }

    // Mulai sesi latihan
    public void start() {
        if (isRunning) {
            System.out.println("Latihan sudah berjalan.");
            return;
        }

        if (currentExerciseIndex >= exercises.size()) {
            System.out.println("Semua latihan selesai. Total waktu: " + totalTime + " detik.");
            return;
        }

        isRunning = true;
        Exercise currentExercise = exercises.get(currentExerciseIndex);
        System.out.println("Mulai latihan: " + currentExercise.getName() + " selama " + currentExercise.getDuration() + " detik.");
    }

    // Hentikan sesi latihan
    public void stop() {
        if (!isRunning) {
            System.out.println("Latihan belum dimulai.");
            return;
        }

        isRunning = false;
        System.out.println("Latihan dihentikan.");
    }

    // Lanjut ke latihan berikutnya
    public void nextExercise() {
        if (currentExerciseIndex < exercises.size()) {
            Exercise currentExercise = exercises.get(currentExerciseIndex);
            totalTime += currentExercise.getDuration();
            System.out.println("Selesai: " + currentExercise.getName());
            giveFeedback();

            currentExerciseIndex++;
            if (currentExerciseIndex < exercises.size()) {
                System.out.println("Latihan berikutnya: " + exercises.get(currentExerciseIndex).getName());
            } else {
                System.out.println("Semua latihan selesai! Total waktu: " + totalTime + " detik.");
            }
        } else {
            System.out.println("Tidak ada latihan tersisa.");
        }
    }

    // Dapatkan status sesi
    public void getStatus() {
        int completed = currentExerciseIndex;
        int total = exercises.size();
        System.out.println("Status: " + completed + "/" + total + " latihan selesai (" + (completed * 100 / total) + "%).");
    }

    // Berikan feedback motivasi
    private void giveFeedback() {
        String[] feedbacks = {
            "Bagus! Tetap semangat!",
            "Kerja keras tidak akan mengkhianati hasil!",
            "Hebat, teruskan!",
            "Luar biasa! Satu langkah lebih dekat ke tujuanmu!"
        };
        int index = (int) (Math.random() * feedbacks.length);
        System.out.println("Motivasi: " + feedbacks[index]);
    }

    // Atur durasi latihan tertentu
    public void setDurationForExercise(int exerciseIndex, int duration) {
        if (exerciseIndex < 0 || exerciseIndex >= exercises.size()) {
            throw new IllegalArgumentException("Indeks latihan tidak valid.");
        }
        exercises.get(exerciseIndex).setDuration(duration);
        System.out.println("Durasi untuk latihan \"" + exercises.get(exerciseIndex).getName() + "\" diatur menjadi " + duration + " detik.");
    }

    // Reset sesi latihan
    public void resetSession() {
        currentExerciseIndex = 0;
        totalTime = 0;
        isRunning = false;
        System.out.println("Sesi latihan direset.");
    }
}
