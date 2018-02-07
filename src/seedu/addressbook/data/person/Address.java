package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
//        if (!isValidAddress(trimmedAddress)) {
//            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
//        }
//        this.value = trimmedAddress;

        String[] addressArr = trimmedAddress.split(",");
        Block block = new Block(addressArr[0], isPrivate);
        Street street = new Street(addressArr[1], isPrivate);
        Unit unit = new Unit(addressArr[2], isPrivate);
        PostalCode postal = new PostalCode(addressArr[3], isPrivate);
        String addr = block.toString() + " " + street.toString() + " " + unit.toString() + " " + postal.toString();
        this.value = addr;

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
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
