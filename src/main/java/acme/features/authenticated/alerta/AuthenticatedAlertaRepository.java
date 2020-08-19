
package acme.features.authenticated.alerta;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.alertas.Alerta;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAlertaRepository extends AbstractRepository {

	@Query("select d from Alerta d where d.id=?1")
	Alerta findOneById(int id);

	@Query("select d from Alerta d where d.investmentRound.id = ?1")
	Collection<Alerta> findAllByInvest(int idJob);

}
