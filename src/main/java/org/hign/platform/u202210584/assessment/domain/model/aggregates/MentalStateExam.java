package org.hign.platform.u202210584.assessment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.u202210584.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202210584.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202210584.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202210584.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "examiner_id", nullable = false)
    private Examiner examiner;

    @Column(nullable = false)
    private String examinerNationalProviderIdentifier;


    @Column(nullable = false)
    private Integer attentionAndCalculationScore;

    @Column(nullable = false)
    private Integer orientationScore;

    @Column(nullable = false)
    private Integer registrationScore;

    @Column(nullable = false)
    private Integer recallScore;

    @Column(nullable = false)
    private Date examDate;

    @Column(nullable = false)
    private Integer languageScore;
    @Column(nullable = false)
    private Long patientId;

    public MentalStateExam() {}
    public MentalStateExam(CreateMentalStateExamCommand command ){
        this. attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.recallScore = command.recallScore();
        this.examDate = command.examDate();
        this.languageScore = command.languageScore();
    }
}
