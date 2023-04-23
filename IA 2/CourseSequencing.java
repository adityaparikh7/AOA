import java.util.*;

public class CourseSequencing {

    public static void main(String[] args) {
        // Define the list of courses and their prerequisites
        Map<String, List<String>> courseList = new HashMap<>();
        courseList.put("CS101", Arrays.asList("MATH101"));
        courseList.put("MATH101", new ArrayList<>());
        courseList.put("CS201", Arrays.asList("CS101"));
        courseList.put("CS301", Arrays.asList("CS201"));

        // Get the user's selected courses
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the course codes for the courses you want to take, separated by commas:");
        String[] courseCodes = scanner.nextLine().split(",");

        // Calculate the optimal course sequence for the selected courses
        List<String> selectedCourses = new ArrayList<>(Arrays.asList(courseCodes));
        List<String> optimalSequence = calculateOptimalSequence(courseList, selectedCourses);

        // Print the optimal course sequence
        System.out.println("Optimal course sequence: " + optimalSequence);
    }

    public static List<String> calculateOptimalSequence(Map<String, List<String>> courseList, List<String> selectedCourses) {
        // Initialize the memoization table
        Map<String, List<String>> memoTable = new HashMap<>();

        // Calculate the optimal sequence for each selected course
        for (String course : selectedCourses) {
            calculateOptimalSequenceHelper(course, courseList, memoTable);
        }

        // Find the maximum sequence length
        int maxLength = 0;
        for (List<String> sequence : memoTable.values()) {
            if (sequence.size() > maxLength) {
                maxLength = sequence.size();
            }
        }

        // Find the optimal sequence with the maximum length
        List<String> optimalSequence = new ArrayList<>();
        for (List<String> sequence : memoTable.values()) {
            if (sequence.size() == maxLength && isSequenceValid(sequence, courseList)) {
                optimalSequence = sequence;
                break;
            }
        }

        return optimalSequence;
    }

    private static List<String> calculateOptimalSequenceHelper(String course, Map<String, List<String>> courseList, Map<String, List<String>> memoTable) {
        // Check if the optimal sequence for this course has already been calculated
        if (memoTable.containsKey(course)) {
            return memoTable.get(course);
        }

        // Calculate the optimal sequence for each prerequisite course
        List<String> optimalSequence = new ArrayList<>();
        for (String prerequisite : courseList.get(course)) {
            List<String> prerequisiteSequence = calculateOptimalSequenceHelper(prerequisite, courseList, memoTable);
            if (prerequisiteSequence.size() > optimalSequence.size()) {
                optimalSequence = prerequisiteSequence;
            }
        }

        // Add this course to the optimal sequence
        optimalSequence.add(course);

        // Store the optimal sequence in the memoization table
        memoTable.put(course, optimalSequence);

        return optimalSequence;
    }

    private static boolean isSequenceValid(List<String> sequence, Map<String, List<String>> courseList) {
        // Check that all prerequisites are satisfied
        for (int i = 1; i < sequence.size(); i++) {
            String course = sequence.get(i);
            List<String> prerequisites = courseList.get(course);
            for (String prerequisite : prerequisites) {
                if (!sequence.contains(prerequisite)) {
                    return false;
                }
            }
        }
        return true;
    }

}
