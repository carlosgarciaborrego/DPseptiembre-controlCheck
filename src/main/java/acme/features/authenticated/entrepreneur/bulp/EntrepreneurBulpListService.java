
package acme.features.authenticated.entrepreneur.bulp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulps.Bulp;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EntrepreneurBulpListService implements AbstractListService<Entrepreneur, Bulp> {

	@Autowired
	private EntrepreneurBulpRepository repository;


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

		request.unbind(entity, model, "text");
	}

	@Override
	public Collection<Bulp> findMany(final Request<Bulp> request) {
		assert request != null;
		Collection<Bulp> result;

		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("=");
		request.getServletRequest().getQueryString();
		id = Integer.parseInt(aux[1]);

		result = this.repository.findAllByInvest(id);

		return result;
	}

}
