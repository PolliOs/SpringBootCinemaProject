package com.example.demo.service.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ContainerException extends Exception {

    private List<Exception> exeptions = new ArrayList<>();

    // some constructors

    public void add(Exception e) {
        exeptions.add(e);
    }

    public Collection<Exception> getExceptions() {
        return exeptions;
    }
}
