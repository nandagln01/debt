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
public class PaymentPlan {
    @Id
    @Generated
    private long id;

    private long debt_id;

    private BigDecimal amountToPay;

    private BigDecimal installment_amount;

    private String installment_frequency;

    private Date start_date;
}
