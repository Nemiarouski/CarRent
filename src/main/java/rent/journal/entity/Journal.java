package rent.journal.entity;

import java.util.LinkedList;
import java.util.List;

public class Journal {
    private List<Note> notes = new LinkedList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(Note note) {
        notes.remove(note);
    }

    public void editNote(Note note) {
        for (Note n : notes) {
            if (n.equals(note)) {
                n = note;
            } else {
                System.out.println("Your note doesn't exist.");
            }
        }
    }

    public void showNotes() {
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}