package seedu.addressbook.data.person;

public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "";
    public static final String BLOCK_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    public Block(String block, boolean isPrivate) {
        String trimmedBlock = block.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedBlock;
    }

    /**
     * Returns true if a given string is a valid person block.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
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