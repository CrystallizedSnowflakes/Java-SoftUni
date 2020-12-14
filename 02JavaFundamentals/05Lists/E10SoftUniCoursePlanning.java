package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialSchedule = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        while (true){
            String commands = scanner.nextLine();

            if (commands.equals("course start")){
                break;
            }

            String[] tokens = commands.split(":");
            String lessonTitle = tokens[1];
            String exerciseLesson = String.format("%s-Exercise", lessonTitle);

            switch (tokens[0]){
                case "Add":
                    if (!initialSchedule.contains(lessonTitle)){
                        initialSchedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!initialSchedule.contains(lessonTitle)){
                        initialSchedule.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    initialSchedule.remove(lessonTitle);
                    initialSchedule.remove(exerciseLesson);
                    break;
                case "Swap":
                    String newLessonTitle = tokens[2];
                    String exerciseNewLesson = String.format("%s-Exercise", newLessonTitle);

                    if (initialSchedule.contains(lessonTitle) && initialSchedule.contains(newLessonTitle)){
                        //Collections.swap(initialSchedule, initialSchedule.indexOf(newLessonTitle), initialSchedule.indexOf(lessonTitle));
                        int swapIndex = initialSchedule.indexOf(newLessonTitle);
                        initialSchedule.set(initialSchedule.indexOf(lessonTitle), newLessonTitle);
                        initialSchedule.set(swapIndex, lessonTitle);

                        if (initialSchedule.contains(exerciseNewLesson)){
                            initialSchedule.remove(exerciseNewLesson);
                            initialSchedule.add(initialSchedule.indexOf(newLessonTitle) + 1, exerciseNewLesson);
                        }

                        if (initialSchedule.contains(exerciseLesson)){
                            initialSchedule.remove(exerciseLesson);
                            initialSchedule.add(initialSchedule.indexOf(lessonTitle) + 1, exerciseLesson);
                        }
                    }
                    break;
                case "Exercise":
                    if (!initialSchedule.contains(lessonTitle)){
                        initialSchedule.add(lessonTitle);
                        initialSchedule.add(exerciseLesson);
                    } else {
                        if (!initialSchedule.contains(exerciseLesson)){
                            initialSchedule.add(initialSchedule.indexOf(lessonTitle) + 1, exerciseLesson);
                        }
                    }
                    break;
            }
        }
        for (int i = 0; i < initialSchedule.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, initialSchedule.get(i));
        }
    }
}
