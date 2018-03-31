package org.it.step;

import java.util.ArrayList;
import java.util.List;

public class HelloPOJO {

    private String name;

    private List<String> items;

    public HelloPOJO() {
        name = "everyone";
        items = new ArrayList<>();
        items.add("String 1");
        items.add("String 3");
        items.add("String 5");
        items.add("String 2");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }


}
