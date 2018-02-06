package seedu.addressbook.data.person;

public class PostalCode {
    public static final String EXAMPLE = "12345";
    public static final String MESSAGE_POSTAL_CONSTRAINTS = "";
    public static final String POSTAL_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    public PostalCode(String postal, boolean isPrivate) {
        String trimmedPostal = postal.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedPostal;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidPostal(String test) {
        return test.matches(POSTAL_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
