
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select avg(select count(a) from Alerta a where a.investmentRound.id = ua.id) from InvestmentRound ua")
	Double getRatioInvestmentRoundAlerta();

	@Query("select avg(select a.pass !='' from Application a where a.id = ua.id) from Application ua")
	Double getRatioApplicationPassword();

	@Query("select avg(select a.link !='' from Application a where a.id = ua.id) from Application ua")
	Double getRatioApplicationLink();

}
