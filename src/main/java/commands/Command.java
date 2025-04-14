package commands;


public abstract class Command {
    private int wordsCount;

    public Command(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public int getWordsCount() {
        return wordsCount;
    }
}
