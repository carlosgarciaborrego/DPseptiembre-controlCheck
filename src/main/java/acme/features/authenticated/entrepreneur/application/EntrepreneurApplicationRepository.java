
package acme.features.authenticated.entrepreneur.application;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurApplicationRepository extends AbstractRepository {

	@Query("select i from Application i where i.id = ?1")
	Application findOneById(int id);

	@Query("select i from Application i where i.investmentRound.entrepreneur.id = ?1")
	Collection<Application> findApplicationToInvestmentRound(int id);

	@Query("select i from Application i where i.investmentRound.id = ?1")
	Collection<Application> findApplicationToInvest(int id);

	@Query("select a.investmentRound.ticker from Application a where a.id = ?1")
	String findTickerOfInvestmentRoundbyIdApp(int id);

	@Query("select a.investmentRound.id from Alerta a")
	List<Integer> findIdInvestFromAlerta();
}
