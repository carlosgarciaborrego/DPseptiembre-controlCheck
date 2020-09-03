
package acme.features.authenticated.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.bulps.Bulp;
import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select i from InvestmentRound i where i.active = true")
	Collection<InvestmentRound> findInvestmentRoundActives();

	@Query("select a from Bulp a where a.investmentRound.id =?1")
	Bulp findAlertaToThisInvestmentRound(int id);

}
