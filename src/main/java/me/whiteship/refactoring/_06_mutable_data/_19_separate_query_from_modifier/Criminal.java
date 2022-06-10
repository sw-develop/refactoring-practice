package me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;

public class Criminal {

    public void alertForMiscreant(List<Person> people) {
        if (!findMiscreant(people).isBlank()) {
            setOffAlarms();
        }
    }

    public String findMiscreant(List<Person> people) { //조회만 수행
        for (Person p : people) {
            if (p.getName().equals("Don")) {
                return "Don";
            }

            if (p.getName().equals("John")) {
                return "John";
            }
        }

        return "";
    }

    private void setOffAlarms() {
        System.out.println("set off alarm");
    }
}
