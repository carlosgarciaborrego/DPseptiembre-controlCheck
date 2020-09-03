
package acme.features.authenticated.investor.bulp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulps.Bulp;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorBulpShowService implements AbstractShowService<Investor, Bulp> {

	@Autowired
	InvestorBulpRepository repository;


	@Override
	public boolean authorise(final Request<Bulp> request) {
		assert request != null;

		return true;
	}
	@Override
	public void unbind(final Request<Bulp> request, final Bulp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		String tickerOfInvestmentRound = this.repository.findTickerOfInvest(entity.getId());
		entity.setTickerInvest(tickerOfInvestmentRound);

		request.unbind(entity, model, "text", "tickerInvest");
		model.setAttribute("finalMode", entity.getInvestmentRound().getActive());

	}
	@Override
	public Bulp findOne(final Request<Bulp> request) {
		assert request != null;

		Bulp result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
