package rent.journal;

import rent.journal.entity.Journal;
import rent.journal.entity.Note;

public class App {
    public static void main(String[] args) {
        Journal journal = new Journal();
        Note note = new Note("First note");
        journal.addNote(note);

        Note note1 = new Note("Maybe it's something great. Who knows?");

        journal.addNote(note1);

        journal.showNotes();

    }
}