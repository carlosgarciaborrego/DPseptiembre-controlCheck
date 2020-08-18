
package acme.features.authenticated.investor.alerta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alertas.Alerta;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorAlertaShowService implements AbstractShowService<Investor, Alerta> {

	@Autowired
	InvestorAlertaRepository repository;


	@Override
	public boolean authorise(final Request<Alerta> request) {
		assert request != null;

		return true;
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
