
package acme.features.authenticated.activity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activities.Activity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedActivityRepository extends AbstractRepository {

	@Query("select d from Activity d where d.id=?1")
	Activity findOneById(int id);

	@Query("select d from Activity d where d.investmentRound.id = ?1")
	Collection<Activity> findAllByInvest(int idJob);
}
