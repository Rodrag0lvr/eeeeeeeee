package org.hign.platform.u202210584.personnel.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.u202210584.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202210584.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202210584.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202210584.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Embedded
    @Column(name = "national_provider_identifier")
    private NationalProviderIdentifier nationalProviderIdentifier;
    @OneToMany(mappedBy = "examiner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MentalStateExam> mentalStateExams;
    public Examiner() {
        this.nationalProviderIdentifier = new NationalProviderIdentifier();
    }

    public Examiner(CreateExaminerCommand command) {
        this();
        this.firstName = command.firstName();
        this.lastName = command.lastName();
    }
}