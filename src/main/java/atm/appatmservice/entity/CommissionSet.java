package atm.appatmservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import atm.appatmservice.entity.template.AbsIntegerEntity;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommissionSet extends AbsIntegerEntity {
    private Double commissionToWithdraw;
    private Double commissionToReplenish;
    private Double commissionToWithdrawForOtherBank;
    private Double commissionToReplenishForOtherBank;
}
