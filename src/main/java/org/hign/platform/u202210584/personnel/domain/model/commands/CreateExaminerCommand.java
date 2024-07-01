package org.hign.platform.u202210584.personnel.domain.model.commands;

public record CreateExaminerCommand (String firstName, String lastName){

    public CreateExaminerCommand {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("LastName cannot be null or blank");
        }
    }

}
