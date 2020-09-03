
package acme.features.authenticated.bulp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulps.Bulp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedBulpRepository extends AbstractRepository {

	@Query("select d from Bulp d where d.id=?1")
	Bulp findOneById(int id);

	@Query("select d from Bulp d where d.investmentRound.id = ?1")
	Collection<Bulp> findAllByInvest(int idJob);

}
