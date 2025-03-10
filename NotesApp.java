import java.util.Scanner;

public class NotesApp {
    private static NotesManager notesManager = new NotesManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("📝 Welcome to Notes Manager 📝");

        while (true) {
            System.out.println("\n1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Edit Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Search Notes");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    notesManager.addNote();
                    break;
                case 2:
                    notesManager.viewNotes();
                    break;
                case 3:
                    notesManager.editNote();
                    break;
                case 4:
                    notesManager.deleteNote();
                    break;
                case 5:
                    notesManager.searchNotes();
                    break;
                case 6:
                    System.out.println("Exiting... Keep your notes safe! 📖");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
