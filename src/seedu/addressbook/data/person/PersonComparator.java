package seedu.addressbook.data.person;

import java.util.Comparator;

public class PersonComparator implements Comparator<ReadOnlyPerson> {
    public int compare(ReadOnlyPerson person, ReadOnlyPerson otherPerson) {
        return person.getName().compareTo(otherPerson.getName());
    }
}
