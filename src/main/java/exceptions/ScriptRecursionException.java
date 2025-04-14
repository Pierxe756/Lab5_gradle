package exceptions;

public class ScriptRecursionException extends RuntimeException {
    public ScriptRecursionException(String message) {
        super(message);
    }

  @Override
  public String getMessage() {
    return "Запущена защита от рекурсии : файл не должен вызывать сам себя";
  }
}
