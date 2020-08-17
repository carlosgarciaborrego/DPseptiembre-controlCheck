
package acme.features.authenticated.entrepreneur.alerta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alertas.Alerta;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EntrepreneurAlertaDeleteService implements AbstractDeleteService<Entrepreneur, Alerta> {

	@Autowired
	EntrepreneurAlertaRepository repository;


	@Override
	public boolean authorise(final Request<Alerta> request) {
		assert request != null;
		boolean result;
		int investId;
		Alerta alerta;
		InvestmentRound invest;
		Principal principal;
		Entrepreneur entre;

		investId = request.getModel().getInteger("id");
		alerta = this.repository.findOneById(investId);
		invest = alerta.getInvestmentRound();
		entre = invest.getEntrepreneur();
		principal = request.getPrincipal();

		result = entre.getUserAccount().getId() == principal.getAccountId();

		return result;
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
	}

	@Override
	public Alerta findOne(final Request<Alerta> request) {
		assert request != null;

		Alerta result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Alerta> request, final Alerta entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Alerta> request, final Alerta entity) {

		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
