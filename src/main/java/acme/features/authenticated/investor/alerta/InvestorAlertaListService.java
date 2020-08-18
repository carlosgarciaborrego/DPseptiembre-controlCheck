
package acme.features.authenticated.investor.alerta;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alertas.Alerta;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorAlertaListService implements AbstractListService<Investor, Alerta> {

	@Autowired
	private InvestorAlertaRepository repository;


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
	}

	@Override
	public Collection<Alerta> findMany(final Request<Alerta> request) {
		assert request != null;
		Collection<Alerta> result;

		result = this.repository.findAllAlertawithInvestActive();

		return result;
	}

}
