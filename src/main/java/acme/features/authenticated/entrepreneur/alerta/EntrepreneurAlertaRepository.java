
package acme.features.authenticated.entrepreneur.alerta;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.alertas.Alerta;
import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurAlertaRepository extends AbstractRepository {

	@Query("select d from Alerta d where d.id=?1")
	Alerta findOneById(int id);

	@Query("select d from Alerta d where d.investmentRound.id = ?1")
	Collection<Alerta> findAllByInvest(int idJob);

	@Query("select d from InvestmentRound d where d.id=?1")
	InvestmentRound findInvestmentRoundById(int id);
}
