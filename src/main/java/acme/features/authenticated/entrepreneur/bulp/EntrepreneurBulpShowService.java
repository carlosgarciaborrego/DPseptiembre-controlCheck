
package acme.features.authenticated.entrepreneur.bulp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulps.Bulp;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurBulpShowService implements AbstractShowService<Entrepreneur, Bulp> {

	@Autowired
	EntrepreneurBulpRepository repository;


	@Override
	public boolean authorise(final Request<Bulp> request) {
		assert request != null;

		boolean result;
		int alertaId;
		Bulp alerta;
		InvestmentRound investmentRound;
		Principal principal;
		Entrepreneur entrepreneur;

		alertaId = request.getModel().getInteger("id");
		alerta = this.repository.findOneById(alertaId);
		investmentRound = alerta.getInvestmentRound();
		entrepreneur = investmentRound.getEntrepreneur();
		principal = request.getPrincipal();

		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return result;
	}
	@Override
	public void unbind(final Request<Bulp> request, final Bulp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text");
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
