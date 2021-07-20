package rent.journal.entity;

public class Note {
    private String noteInfo;

    public Note(String noteInfo) {
        this.noteInfo = noteInfo;
    }

    public String getNoteInfo() {
        return noteInfo;
    }

    @Override
    public String toString() {
        return noteInfo;
    }
}