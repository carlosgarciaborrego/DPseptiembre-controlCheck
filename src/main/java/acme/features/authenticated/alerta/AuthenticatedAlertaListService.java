
package acme.features.authenticated.alerta;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alertas.Alerta;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAlertaListService implements AbstractListService<Authenticated, Alerta> {

	@Autowired
	private AuthenticatedAlertaRepository repository;


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

		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		request.getServletRequest().getQueryString();
		id = Integer.parseInt(aux[1]);

		result = this.repository.findAllByInvest(id);

		return result;
	}

}
