
package acme.features.authenticated.entrepreneur.bulp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulps.Bulp;
import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurBulpRepository extends AbstractRepository {

	@Query("select d from Bulp d where d.id=?1")
	Bulp findOneById(int id);

	@Query("select d from Bulp d where d.investmentRound.id = ?1")
	Collection<Bulp> findAllByInvest(int idJob);

	@Query("select d from InvestmentRound d where d.id=?1")
	InvestmentRound findInvestmentRoundById(int id);
}
