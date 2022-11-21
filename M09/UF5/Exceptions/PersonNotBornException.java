package M09.UF5.Exceptions;

public class PersonNotBornException extends Exception {
    public PersonNotBornException(String msg_error_data) {
        super(msg_error_data);
    }
}
