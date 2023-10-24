package jogodavelha.exceptions.game;

public class GameAlreadyOverException extends RuntimeException {
    public GameAlreadyOverException(String message) {
        super(message);
    }
}
