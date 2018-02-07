package seedu.addressbook.data.person;

public class Unit {
    public static final String EXAMPLE = "#01-02";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "";
    public static final String UNIT_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    public Unit(String unit, boolean isPrivate) {
        String trimmedUnit = unit.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid person unit.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
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
