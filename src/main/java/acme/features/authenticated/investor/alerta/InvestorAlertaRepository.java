
package acme.features.authenticated.investor.alerta;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.alertas.Alerta;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorAlertaRepository extends AbstractRepository {

	@Query("select d from Alerta d where d.id=?1")
	Alerta findOneById(int id);

	@Query("select d from Alerta d where d.investmentRound.active = true")
	Collection<Alerta> findAllAlertawithInvestActive();

	@Query("select a.investmentRound.ticker from Alerta a where a.id = ?1")
	String findTickerOfInvest(int id);

}
