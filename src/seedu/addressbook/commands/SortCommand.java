package seedu.addressbook.commands;

import seedu.addressbook.data.person.PersonComparator;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

/**
 * Adds a person to the address book.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = "Sorts Address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Sorted Address book displayed!";

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().sortedView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
