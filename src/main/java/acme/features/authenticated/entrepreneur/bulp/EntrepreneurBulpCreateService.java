
package acme.features.authenticated.entrepreneur.bulp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulps.Bulp;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurBulpCreateService implements AbstractCreateService<Entrepreneur, Bulp> {

	@Autowired
	private EntrepreneurBulpRepository repository;


	@Override
	public boolean authorise(final Request<Bulp> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Bulp> request, final Bulp entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Bulp> request, final Bulp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text");
		model.setAttribute("id", entity.getInvestmentRound().getId());

	}

	@Override
	public Bulp instantiate(final Request<Bulp> request) {
		Bulp res;
		res = new Bulp();
		int idJob = request.getModel().getInteger("id");
		InvestmentRound job = this.repository.findInvestmentRoundById(idJob);
		if (job != null) {
			res.setInvestmentRound(job);
		}

		return res;
	}

	@Override
	public void validate(final Request<Bulp> request, final Bulp entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Bulp> request, final Bulp entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
