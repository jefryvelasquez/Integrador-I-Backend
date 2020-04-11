package co.udea.gestionproyectos.api.exception;

/**
 * Exception for duplicated data in the application
 */
public class DataDuplicatedException extends GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    public DataDuplicatedException(String message) {
        super(message);
    }

    public DataDuplicatedException(String message, String translationKey) {
        super(message, translationKey);
    }

}
