package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Town road 1, #01-01, 12345";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTAL_INDEX = 3;
    public static final int SIZE = 4;

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
        String[] addressArr = trimmedAddress.split(",");

        if (!isValidAddress(addressArr)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
//        this.value = trimmedAddress;

        Block block = new Block(addressArr[BLOCK_INDEX], isPrivate);
        Street street = new Street(addressArr[STREET_INDEX], isPrivate);
        Unit unit = new Unit(addressArr[UNIT_INDEX], isPrivate);
        PostalCode postal = new PostalCode(addressArr[POSTAL_INDEX], isPrivate);
        String addr = block.toString() + ", " + street.toString() + ", " + unit.toString() + ", " + postal.toString();
        this.value = addr;

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String[] test) { return test.length == SIZE; }

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
