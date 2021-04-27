package Models;

public class Hobbies {
    boolean music;
    boolean sports;
    boolean travelling;
    boolean reading;
    boolean videoGames;

    public Hobbies(boolean music, boolean sports, boolean travelling, boolean reading, boolean videoGames) {
        this.music = music;
        this.sports = sports;
        this.travelling = travelling;
        this.reading = reading;
        this.videoGames = videoGames;
    }


    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isTravelling() {
        return travelling;
    }

    public void setTravelling(boolean travelling) {
        this.travelling = travelling;
    }

    public boolean isReading() {
        return reading;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }

    public boolean isVideoGames() {
        return videoGames;
    }

    public void setVideoGames(boolean videoGames) {
        this.videoGames = videoGames;
    }
}
