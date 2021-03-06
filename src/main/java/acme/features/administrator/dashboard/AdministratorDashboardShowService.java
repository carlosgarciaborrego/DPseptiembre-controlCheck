
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ratioInvestmentRoundsAlerta", "ratioApplicationLink", "ratioApplicationPass");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {

		Dashboard res = new Dashboard();

		Double ratioInvestmentRoundsAlerta = this.repository.getRatioInvestmentRoundAlerta();
		Double ratioApplicationLink = this.repository.getRatioApplicationLink();
		Double ratioApplicationPass = this.repository.getRatioApplicationPassword();

		res.setRatioInvestmentRoundsAlerta(ratioInvestmentRoundsAlerta);
		res.setRatioApplicationLink(ratioApplicationLink);
		res.setRatioApplicationPass(ratioApplicationPass);

		return res;
	}

}
