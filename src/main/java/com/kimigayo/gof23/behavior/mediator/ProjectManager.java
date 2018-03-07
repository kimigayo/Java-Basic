package com.kimigayo.gof23.behavior.mediator;

import java.util.HashMap;
import java.util.Map;

public class ProjectManager implements Meditator {
    private Map<String,Department> map = new HashMap<>();
    @Override
    public void work(String dName) {
        map.get(dName).selfWork();
    }

    @Override
    public void relative(String dName,Department department) {
        map.put(dName,department);
    }
}
