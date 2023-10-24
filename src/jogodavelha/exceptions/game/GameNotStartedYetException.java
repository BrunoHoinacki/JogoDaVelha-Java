package jogodavelha.exceptions.game;

public class GameNotStartedYetException extends RuntimeException {
    public GameNotStartedYetException(String message) {
        super(message);
    }
}