import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private int score;
    private String playerName;
    private int frameIterator = 1;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.playerName;
    }

    public void play() throws InterruptedException {
        int max = 0;
        int totalPinsKnocked = 0;

        int chance1 = randomNum(10);

        if (chance1 == 10) {
            this.score += 20;
            displayScoreInfo(frameIterator, 10, 1, 20, this.score);
            Thread.sleep(2000);
        } else {
            max = 10 - chance1;

            int chance2 = randomNum(max);

            totalPinsKnocked = chance1 + chance2;

            if (totalPinsKnocked == 10) {
                this.score += 15;
                displayScoreInfo(frameIterator, 10, 2, 15, this.score);
                Thread.sleep(2000);
            } else {
                this.score += totalPinsKnocked;
                displayScoreInfo(frameIterator, totalPinsKnocked, 2, totalPinsKnocked, this.score);
                Thread.sleep(2000);
            }
        }
        this.frameIterator++;
    }

    private void displayScoreInfo(int frame, int totalPinsKnocked, int tries, int frameScore, int totalScore) {
        System.out.println("FRAME " + frame);
        System.out.printf("Player: %s \nPins Knocked: %s\nTries: %s\nScore: %s\nTotal Score: %s\n\n", this.getName(),
                totalPinsKnocked, tries, frameScore, totalScore);
    }

    private int randomNum(int max) {
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }
}
