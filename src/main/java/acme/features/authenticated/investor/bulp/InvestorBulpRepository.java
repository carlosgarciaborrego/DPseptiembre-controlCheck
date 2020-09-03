
package acme.features.authenticated.investor.bulp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulps.Bulp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorBulpRepository extends AbstractRepository {

	@Query("select d from Bulp d where d.id=?1")
	Bulp findOneById(int id);

	@Query("select d from Bulp d where d.investmentRound.active = true")
	Collection<Bulp> findAllAlertawithInvestActive();

	@Query("select a.investmentRound.ticker from Bulp a where a.id = ?1")
	String findTickerOfInvest(int id);

}
