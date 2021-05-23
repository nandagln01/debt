package com.interview.project.debt.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Payment {

    @Id
    @Generated
    private long payment_plan_id;

    private Date date;

    private BigDecimal amount;
}
