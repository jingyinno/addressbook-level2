package seedu.addressbook.data.person;

public class Street {

    public static final String EXAMPLE = "street name";
    public static final String MESSAGE_STREET_CONSTRAINTS = "";
    public static final String STREET_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    public Street(String street, boolean isPrivate) {
        String trimmedStreet = street.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedStreet;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
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
