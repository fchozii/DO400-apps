package com.redhat.training;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.training.operation.Add;
import com.redhat.training.operation.Identity;
import com.redhat.training.operation.Multiply;
import com.redhat.training.operation.Operation;
import com.redhat.training.operation.Substract;

@ApplicationScoped
public class OperationRegistry {

    @Inject
    Add add;

    @Inject
    Substract substract;

    @Inject
    Identity identity;

    @Inject
    Multiply multiply;

    private List<Operation> operations;

    @PostConstruct
    public void buildOperationList() {
        operations = List.of(substract, add, multiply, identity);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(final List<Operation> operationsParam) {
        this.operations = operationsParam;
    }

}
