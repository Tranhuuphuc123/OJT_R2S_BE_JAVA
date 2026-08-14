package session06_collections;

// ĐÃ XÓA: import entities.Course;
// ĐÃ XÓA: import utils.Constants;
// ĐÃ XÓA: import utils.ScannerUtil;
// ĐÃ XÓA: import utils.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CourseManagement {
    private final ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        new CourseManagement().run();
    }

    private void run() {
        while (true) {
            showMenu();
            int choice = ScannerUtil.readMenuChoice();
            switch (choice) {
                case Constants.MENU_CREATE -> createCourse();
                case Constants.MENU_SEARCH -> searchCourses();
                case Constants.MENU_DISPLAY_BY_FLAG -> displayByFlag();
                case Constants.MENU_QUIT -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n==== COURSE MANAGEMENT ====");
        System.out.println("1. Create a course");
        System.out.println("2. Search courses by attribute");
        System.out.println("3. Display courses by flag");
        System.out.println("0. Quit");
    }

    private void createCourse() {
        String code = readValidCode();
        String name = ScannerUtil.readNonEmpty("Enter name: ");
        boolean status = ScannerUtil.readBoolean("Enter status");
        short duration = ScannerUtil.readPositiveShort("Enter duration (>0): ");
        String flag = readValidFlag();

        courses.add(new Course(code, name, status, duration, flag));
        System.out.println("Course created!");
    }

    private String readValidCode() {
        while (true) {
            String code = ScannerUtil.readNonEmpty("Enter course code (RAxxx): ")
                    .toUpperCase(Locale.ROOT);
            if (!Validator.validateCode(code)) {
                System.out.println("Pattern must be RAxxx.");
                continue;
            }
            if (Validator.isDuplicatedCode(code, courses)) {
                System.out.println("Code already exists.");
                continue;
            }
            return code;
        }
    }

    private String readValidFlag() {
        while (true) {
            String flag = ScannerUtil.readNonEmpty("Enter flag (optional/prerequisite/N/A): ");
            if (Validator.validateFlag(flag)) {
                if (flag.equalsIgnoreCase("n/a"))
                    return Constants.FLAG_NA;
                return flag.toLowerCase(Locale.ROOT);
            }
            System.out.println("Invalid flag.");
        }
    }

    private void searchCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available in system.");
            return;
        }

        String type = ScannerUtil.readNonEmpty("Search by (code/name/status/duration/flag): ")
                .toLowerCase(Locale.ROOT);
        String data = ScannerUtil.readNonEmpty("Enter value to search: ");

        List<Course> result = switch (type) {
            case "code" -> courses.stream()
                    .filter(c -> c.getCode().equalsIgnoreCase(data))
                    .collect(Collectors.toList());

            case "name" -> courses.stream()
                    .filter(c -> c.getName().toLowerCase(Locale.ROOT).contains(data.toLowerCase(Locale.ROOT)))
                    .sorted(Comparator.comparing(Course::getName))
                    .collect(Collectors.toList());

            case "status" -> {
                boolean searchStatus = "active".equalsIgnoreCase(data) || "true".equalsIgnoreCase(data);
                yield courses.stream()
                        .filter(c -> c.isStatus() == searchStatus)
                        .collect(Collectors.toList());
            }

            case "duration" -> {
                try {
                    short searchDuration = Short.parseShort(data);
                    yield courses.stream()
                            .filter(c -> c.getDuration() == searchDuration)
                            .collect(Collectors.toList());
                } catch (NumberFormatException e) {
                    yield new ArrayList<>();
                }
            }

            case "flag" -> courses.stream()
                    .filter(c -> c.getFlag().equalsIgnoreCase(data))
                    .collect(Collectors.toList());

            default -> {
                System.out.println("Invalid search attribute.");
                yield new ArrayList<>();
            }
        };

        printCourseList(result);
    }

    private void displayByFlag() {
        if (courses.isEmpty()) {
            System.out.println("No courses available in system.");
            return;
        }

        String flag = readValidFlag();
        List<Course> filtered = courses.stream()
                .filter(c -> c.getFlag().equalsIgnoreCase(flag))
                .collect(Collectors.toList());

        printCourseList(filtered);
    }

    private void printCourseList(List<Course> list) {
        if (list.isEmpty()) {
            System.out.println("No matching courses found.");
            return;
        }
        System.out.println("\n" + Constants.TABLE_HEADER);
        System.out.println("-".repeat(60));
        for (Course c : list) {
            System.out.println(c); // Lấy từng khóa học 'c' và in ra
        }
    }
}