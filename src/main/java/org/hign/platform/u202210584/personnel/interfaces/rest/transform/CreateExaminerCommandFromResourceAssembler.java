package org.hign.platform.u202210584.personnel.interfaces.rest.transform;

import org.hign.platform.u202210584.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202210584.personnel.interfaces.rest.resources.CreateExaminerResource;

public class CreateExaminerCommandFromResourceAssembler{
    public static CreateExaminerCommand toCommandFromResource (CreateExaminerResource resource){
        return new CreateExaminerCommand(resource.firstName(), resource.lastName());

    }
}
