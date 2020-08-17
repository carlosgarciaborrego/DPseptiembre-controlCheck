
package acme.entities.alertas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Alerta extends DomainEntity {

	private static final long	serialVersionUID	= -1261048987757999873L;

	@NotBlank
	@Length(min = 1, max = 256)
	private String				text;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private InvestmentRound		investmentRound;

}