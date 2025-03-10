import java.util.*;

public class NotesManager {
    private List<Note> notes;
    private Scanner sc;

    public NotesManager() {
        this.notes = NotesStorage.loadNotes();
        this.sc = new Scanner(System.in);
    }

    public void addNote() {
        System.out.print("Enter note title: ");
        String title = sc.nextLine();
        System.out.print("Enter note content: ");
        String content = sc.nextLine();

        notes.add(new Note(title, content));
        NotesStorage.saveNotes(notes);
        System.out.println("✅ Note Added Successfully!");
    }

    public void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("📄 No notes found.");
            return;
        }

        System.out.println("\n📌 Your Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }

    public void editNote() {
        viewNotes();
        System.out.print("Enter note number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < notes.size()) {
            System.out.print("Enter new title: ");
            notes.get(index).setTitle(sc.nextLine());
            System.out.print("Enter new content: ");
            notes.get(index).setContent(sc.nextLine());

            NotesStorage.saveNotes(notes);
            System.out.println("✅ Note Updated Successfully!");
        } else {
            System.out.println("❌ Invalid note number.");
        }
    }

    public void deleteNote() {
        viewNotes();
        System.out.print("Enter note number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            NotesStorage.saveNotes(notes);
            System.out.println("✅ Note Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid note number.");
        }
    }

    public void searchNotes() {
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Note note : notes) {
            if (note.getTitle().toLowerCase().contains(keyword) || note.getContent().toLowerCase().contains(keyword)) {
                System.out.println("\n🔍 Found Note:");
                System.out.println(note);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No notes found with the given keyword.");
        }
    }
}
