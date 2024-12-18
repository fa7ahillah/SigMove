import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private List<Exercise> exerciseList;

    public Workout() {
        exerciseList = new ArrayList<>();

        //**rest session** 

        exerciseList.add(new RestSession(300, 10));
        exerciseList.add(new RestSession(301, 15));
        exerciseList.add(new RestSession(302, 20));
        exerciseList.add(new RestSession(303, 30));



        //**list workout berdasarkan waktu**

        //target area dada, kaki
        exerciseList.add(new TimeBasedExercise(1011, "Jumping Jacks", 20, Arrays.asList( "Dada", "Kaki"), null, "assets\\jumping jacks.png"));
        exerciseList.add(new TimeBasedExercise(1012, "Jumping Jacks", 30, Arrays.asList( "Dada", "Kaki"), null, "assets\\jumping jacks.png"));

        //target area perut, kaki
        exerciseList.add(new TimeBasedExercise(1021, "Plank", 20, Arrays.asList("Perut", "Kaki"), null, "assets\\plank.png"));
        exerciseList.add(new TimeBasedExercise(1022, "Plank", 30, Arrays.asList("Perut", "Kaki"), null, "assets\\plank.png"));
        exerciseList.add(new TimeBasedExercise(1031, "Cobra Stretch", 20, Arrays.asList("Perut", "Kaki"), null, "assets\\cobra stretch.png"));
        exerciseList.add(new TimeBasedExercise(1032, "Cobra Stretch", 30, Arrays.asList("Perut", "Kaki"), null, "assets\\cobra stretch.png"));
        exerciseList.add(new TimeBasedExercise(1041, "Spine Lumbar Twist Stretch Left", 30, Arrays.asList("Perut", "Kaki"), null, "assets\\Spine Lumbar Twist Stretch Left.png"));
        exerciseList.add(new TimeBasedExercise(1051, "Spine Lumbar Twist Stretch Right", 30, Arrays.asList("Perut", "Kaki"), null, "assets\\Spine Lumbar Twist Stretch Right.png"));

        //target area lengan, dada
        exerciseList.add(new TimeBasedExercise(1061, "Chest Stretch", 20, Arrays.asList("Lengan", "Dada"), null, "assets\\chest stretch.png"));
        exerciseList.add(new TimeBasedExercise(1121, "Punches", 30, Arrays.asList("Lengan", "Dada"), null, "assets\\Punches.png"));

        //target area lengan
        exerciseList.add(new TimeBasedExercise(1071, "Arm Raises", 30, Arrays.asList("Lengan"), null, "assets\\arm raises.png"));        
        exerciseList.add(new TimeBasedExercise(1081, "Side Arm Raises", 30, Arrays.asList("Lengan"), null, "assets\\side arm raises.png"));
        
        //target area dada lengan
        exerciseList.add(new TimeBasedExercise(1111, "Chest Press Pulse", 16, Arrays.asList("Dada", "Lengan"), null, "assets\\Chest Press Pulse.png"));

        //target area lengan
        exerciseList.add(new TimeBasedExercise(1091, "Arm Circles Clockwise", 30, Arrays.asList( "Lengan"), null, "assets\\arm circles clockwise.png"));
        exerciseList.add(new TimeBasedExercise(1101, "Arm Circles Counterclockwise", 30, Arrays.asList( "Lengan"), null, "assets\\arm circles counterclockwise.png"));
        exerciseList.add(new TimeBasedExercise(1131, "Triceps Stretch Left", 30, Arrays.asList("Lengan"), null, "assets\\tricep stretch left.png"));
        exerciseList.add(new TimeBasedExercise(1141, "Triceps Stretch Right", 30, Arrays.asList("Lengan"), null, "assets\\tricep stretch right.png"));
        exerciseList.add(new TimeBasedExercise(1151, "Standing Biceps Stretch Left", 30, Arrays.asList("Lengan"), null, "assets\\Standing Biceps Stretch Left.png"));
        exerciseList.add(new TimeBasedExercise(1161, "Standing Biceps Stretch Right", 30, Arrays.asList("Lengan"), null, "assets\\Standing Biceps Stretch Right.png"));

        // target area kaki
        exerciseList.add(new TimeBasedExercise(1171, "Side Hop", 30, Arrays.asList("Kaki"), null, "assets\\side hop.png"));
        exerciseList.add(new TimeBasedExercise(1181, "Left Quad Stretch With Wall", 30, Arrays.asList("Kaki"), null, "assets\\Left Quad Stretch With Wall.png"));
        exerciseList.add(new TimeBasedExercise(1191, "Right Quad Stretch With Wall", 30, Arrays.asList("Kaki"), null, "assets\\Right Quad Stretch With Wall.png"));
        exerciseList.add(new TimeBasedExercise(1201, "Knee To Chest Stretch Left", 30, Arrays.asList("Kaki"), null, "assets\\Knee To Chest Stretch Left.png"));
        exerciseList.add(new TimeBasedExercise(1211, "Knee To Chest Stretch Right", 30, Arrays.asList("Kaki"), null, "assets\\Knee To Chest Stretch Right.png"));
        exerciseList.add(new TimeBasedExercise(1221, "Calf Stretch Left", 30, Arrays.asList("Kaki"), null, "assets\\Calf Stretch Left.png"));
        exerciseList.add(new TimeBasedExercise(1231, "Calf Stretch Right", 30, Arrays.asList("Kaki"), null, "assets\\Calf Stretch Right.png"));

        //**list workout berdasarkan target**

        //target area perut 
        exerciseList.add(new TargetBasedExercise(2011, "Abdominal Crunches", 12, Arrays.asList("Perut"), null, "assets\\Abdominal Crunches.png"));
        exerciseList.add(new TargetBasedExercise(2012, "Abdominal Crunches", 16, Arrays.asList("Perut"), null, "assets\\Abdominal Crunches.png"));
        exerciseList.add(new TargetBasedExercise(2021, "Russian Twist", 20, Arrays.asList("Perut"), null, "assets\\Russian Twist.png"));
        exerciseList.add(new TargetBasedExercise(2022, "Russian Twist", 32, Arrays.asList("Perut"), null, "assets\\Russian Twist.png"));
        exerciseList.add(new TargetBasedExercise(2041, "Heel Touch", 20, Arrays.asList("Perut"), null, "assets\\Heel Touch.png"));

        //target area perut dan kaki
        exerciseList.add(new TargetBasedExercise(2031, "Mountain Climber", 12, Arrays.asList("Perut", "Kaki"), null, "assets\\Mountain Climber.png"));
        exerciseList.add(new TargetBasedExercise(2032, "Mountain Climber", 16, Arrays.asList("Perut", "Kaki"), null, "assets\\Mountain Climber.png"));
        exerciseList.add(new TargetBasedExercise(2051, "Leg Raises", 14, Arrays.asList("Perut", "Kaki"), null, "assets\\Leg Raises.png"));
        exerciseList.add(new TargetBasedExercise(2052, "Leg Raises", 16, Arrays.asList("Perut", "Kaki"), null, "assets\\Leg Raises.png"));

        //target area lengan dan dada
        exerciseList.add(new TargetBasedExercise(2061, "Incline Push-Ups", 12, Arrays.asList("Dada", "Lengan"), null, "assets\\Incline Push-Ups.png"));
        exerciseList.add(new TargetBasedExercise(2062, "Incline Push-Ups", 16, Arrays.asList("Dada", "Lengan"), null, "assets\\Incline Push-Ups.png"));
        exerciseList.add(new TargetBasedExercise(2071, "Knee Push-Ups", 12, Arrays.asList("Dada", "Lengan"), null, "assets\\Knee Push-Ups.png"));
        exerciseList.add(new TargetBasedExercise(2081, "Push-Ups", 10, Arrays.asList("Dada", "Lengan"), null, "assets\\Push-Ups.png"));
        exerciseList.add(new TargetBasedExercise(2091, "Wide Arm Push-Ups", 10, Arrays.asList("Dada", "Lengan"), null, "assets\\Wide Arm Push-Ups.png"));
        exerciseList.add(new TargetBasedExercise(2101, "Box Push-Ups", 12, Arrays.asList("Dada", "Lengan"), null, null));
        exerciseList.add(new TargetBasedExercise(2111, "Hindu Push-Ups", 10, Arrays.asList("Dada", "Lengan"), null, "assets\\Hindu Push-Ups.png"));
        exerciseList.add(new TargetBasedExercise(2121, "Triceps Dips", 10, Arrays.asList("Dada", "Lengan"), null, "assets\\Triceps Dips.png"));
        exerciseList.add(new TargetBasedExercise(2131, "Diamond Push-Ups", 6, Arrays.asList("Dada", "Lengan"), null, "assets\\Diamond Push-Ups.png"));
        exerciseList.add(new TargetBasedExercise(2181, "Wall Push-Ups", 12, Arrays.asList("Dada", "Lengan"), null, "assets\\Wall Push-Ups.png"));

        //target area lengan
        exerciseList.add(new TargetBasedExercise(2141, "Leg Barbell Curl Left", 8, Arrays.asList( "Lengan"), null, "assets\\Leg Barbell Curl Left.png"));
        exerciseList.add(new TargetBasedExercise(2151, "Leg Barbell Curl Right", 8, Arrays.asList( "Lengan"), null, "assets\\Leg Barbell Curl Right.png"));

        //target area lengan dan kaki
        exerciseList.add(new TargetBasedExercise(2161, "Diagonal Plank", 10, Arrays.asList( "Lengan", "Kaki"), null, "assets\\Diagonal Plank.png"));

        //target area perut, dada, lengan, dan kaki
        exerciseList.add(new TargetBasedExercise(2171, "Inchworms", 10, Arrays.asList( "Perut", "Dada", "Lengan", "Kaki"), null, "assets\\Inchworms.png"));

        //target area kaki
        exerciseList.add(new TargetBasedExercise(2191, "Squats", 12, Arrays.asList("Kaki"), null, "assets\\Squats.png"));
        exerciseList.add(new TargetBasedExercise(2201, "Side-Lying Leg Lift Left", 12, Arrays.asList("Kaki"), null, "assets\\Side-Lying Leg Lift Left.png"));
        exerciseList.add(new TargetBasedExercise(2211, "Side-Lying Leg Lift Right", 12, Arrays.asList("Kaki"), null, "assets\\Side-Lying Leg Lift Right.png"));
        exerciseList.add(new TargetBasedExercise(2221, "Backward Lunge", 14, Arrays.asList("Kaki"), null, "assets\\Backward Lunge.png"));
        exerciseList.add(new TargetBasedExercise(2231, "Donkey Kicks Left", 16, Arrays.asList("Kaki"), null, "assets\\Donkey Kicks Left.png"));
        exerciseList.add(new TargetBasedExercise(2241, "Donkey Kicks Right", 16, Arrays.asList("Kaki"), null, "assets\\Donkey Kicks Right.png"));
        exerciseList.add(new TargetBasedExercise(2251, "Wall Calf Raises", 12, Arrays.asList("Kaki"), null, "assets\\Wall Calf Raises.png"));
        exerciseList.add(new TargetBasedExercise(2261, "Sumo Squat Calf Raises With Wall", 16, Arrays.asList("Kaki"), null, "assets\\Sumo Squat Calf Raises With Wall.png"));
    }
    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void addExerciseList(Exercise exercise) {
        exerciseList.add(exercise);
    }

    public List<Exercise> getFilteredExercises(String program) {
    List<Integer> ids;
    switch (program) {
        case "DADA":
            ids = Arrays.asList(1012, 2061, 2071, 2081, 
                                2091, 2061, 2101, 2091, 
                                2111, 1031, 1061);
            break;
        case "LENGAN":
            ids = Arrays.asList(1071, 1081, 2121, 1091, 
                                1101, 2131, 1012, 1111, 
                                2141, 2151, 2161, 1121, 
                                2081, 2171, 2181, 1131, 
                                1141, 1151, 1161);
            break;
        case "PERUT":
            ids = Arrays.asList(1011, 2012, 2021, 2032,
                                2041, 2052, 1021, 2011,
                                2022, 2031, 2041, 2051,
                                1022, 1032, 1041, 1051);
            break;
        case "KAKI":
            ids = Arrays.asList(1171, 2191, 2191, 2201,
                                2211, 2201, 2211, 2221, 
                                2221, 2231, 2241, 2231, 
                                2241, 1181, 1191, 1201, 
                                1211, 2251, 2251, 2261, 
                                2261, 1221, 1231);
            break;
        default:
            return new ArrayList<>();
    }

    List<Exercise> filteredExercises = exerciseList.stream()
        .filter(exercise -> ids.contains(exercise.getID()))
        .sorted(Comparator.comparingInt(exercise -> ids.indexOf(exercise.getID())))
        .collect(Collectors.toList());

    for (Exercise exercise : filteredExercises) {
        System.out.println("Latihan yang difilter: " + exercise.getName() + " - ID: " + exercise.getID());
    }

    return filteredExercises;
}

}