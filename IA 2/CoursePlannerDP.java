import java.util.*;

public class CoursePlannerDP {

    public static List<String> getOptimalCourseSequence(List<String> courses, List<List<String>> prerequisites) {
        int n = courses.size();
        List<String>[] dp = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
        }

        // Iterate over all the courses
        for (int i = 0; i < n; i++) {
            // Iterate over all the prerequisites for the current course
            for (List<String> prerequisite : prerequisites) {
                if (prerequisite.get(0).equals(courses.get(i))) {
                    int j = Integer.parseInt(prerequisite.get(1));
                    if (dp[i].size() < dp[j].size() + 1) { // Check if the current sequence is longer than the previous best
                        dp[i] = new ArrayList<>(dp[j]);
                        dp[i].add(courses.get(i));
                    }
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        // Define the list of courses
        List<String> courses = Arrays.asList("CSC101", "CSC102", "CSC201", "CSC202", "CSC301", "CSC302", "CSC401", "CSC402");

        // Define the list of prerequisites
        List<List<String>> prerequisites = new ArrayList<>();
        prerequisites.add(Arrays.asList("CSC102", "0"));
        prerequisites.add(Arrays.asList("CSC201", "1"));
        prerequisites.add(Arrays.asList("CSC202", "1"));
        prerequisites.add(Arrays.asList("CSC301", "2"));
        prerequisites.add(Arrays.asList("CSC302", "2"));
        prerequisites.add(Arrays.asList("CSC401", "3"));
        prerequisites.add(Arrays.asList("CSC402", "3"));

        Scanner scanner = new Scanner(System.in);

        // Prompt the user to select a course
        System.out.println("Select a course:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i+1) + ". " + courses.get(i));
        }
        int courseIndex = scanner.nextInt() - 1;
        String selectedCourse = courses.get(courseIndex);

        // Calculate the required prerequisites for the selected course
        List<String> requiredPrerequisites = getOptimalCourseSequence(courses, prerequisites);
        requiredPrerequisites.remove(selectedCourse);

        // Print the required prerequisites for the selected course
        System.out.println("Required prerequisites for " + selectedCourse + ": " + requiredPrerequisites);
    }
}
