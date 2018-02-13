package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import static org.junit.Assert.*;

public class SortCommandTest {

    private AddressBook addressbook;
    private List<Person> expectedOrderList = new ArrayList<Person>();

    @Test
    public void execute_sortCommand() {
        SortCommand command = new SortCommand();
        Person a = TestUtil.generateTestPerson("a");
        Person b = TestUtil.generateTestPerson("b");
        Person c = TestUtil.generateTestPerson("c");
        addressbook = TestUtil.createAddressBook(c, b, a);

        expectedOrderList = Arrays.asList(c, b, a);

        UniquePersonList peopleList = addressbook.getAllPersons();
        UniquePersonList expectedList = null;

        try {
            command.setData(addressbook, Collections.emptyList());
            command.execute();
            expectedList = new UniquePersonList(expectedOrderList);

        } catch (UniquePersonList.DuplicatePersonException e) {
            e.printStackTrace();
        }

        assertTrue(peopleList.equals(expectedList));
    }
}
