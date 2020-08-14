
package acme.features.authenticated.overture;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.overtures.Overture;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedOvertureRepository extends AbstractRepository {

	@Query("select o from Overture o where o.id = ?1")
	Overture findOneById(int id);

	@Query("select o from Overture o where o.deadline >= now()")
	Collection<Overture> findOvertureActives();
}
