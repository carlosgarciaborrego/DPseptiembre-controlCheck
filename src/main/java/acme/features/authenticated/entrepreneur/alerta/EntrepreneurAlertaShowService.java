
package acme.features.authenticated.entrepreneur.alerta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alertas.Alerta;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurAlertaShowService implements AbstractShowService<Entrepreneur, Alerta> {

	@Autowired
	EntrepreneurAlertaRepository repository;


	@Override
	public boolean authorise(final Request<Alerta> request) {
		assert request != null;

		boolean result;
		int alertaId;
		Alerta alerta;
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
	public void unbind(final Request<Alerta> request, final Alerta entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text");
		model.setAttribute("finalMode", entity.getInvestmentRound().getActive());

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
}
