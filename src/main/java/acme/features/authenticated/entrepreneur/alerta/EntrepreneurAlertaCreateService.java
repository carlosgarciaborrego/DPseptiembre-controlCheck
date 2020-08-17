
package acme.features.authenticated.entrepreneur.alerta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alertas.Alerta;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurAlertaCreateService implements AbstractCreateService<Entrepreneur, Alerta> {

	@Autowired
	private EntrepreneurAlertaRepository repository;


	@Override
	public boolean authorise(final Request<Alerta> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Alerta> request, final Alerta entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Alerta> request, final Alerta entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text");
		model.setAttribute("id", entity.getInvestmentRound().getId());

	}

	@Override
	public Alerta instantiate(final Request<Alerta> request) {
		Alerta res;
		res = new Alerta();
		int idJob = request.getModel().getInteger("id");
		InvestmentRound job = this.repository.findInvestmentRoundById(idJob);
		if (job != null) {
			res.setInvestmentRound(job);
		}

		return res;
	}

	@Override
	public void validate(final Request<Alerta> request, final Alerta entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Alerta> request, final Alerta entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
