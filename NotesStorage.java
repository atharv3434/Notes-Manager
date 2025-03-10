import java.io.*;
import java.util.*;

public class NotesStorage {
    private static final String FILE_PATH = "notes.txt";

    public static void saveNotes(List<Note> notes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            System.out.println("❌ Error saving notes.");
        }
    }

    public static List<Note> loadNotes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
