
package acme.features.authenticated.investmentRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alertas.Alerta;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Investor;
import acme.features.authenticated.investor.AuthenticatedInvestorRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedInvestmentRoundShowService implements AbstractShowService<Authenticated, InvestmentRound> {

	@Autowired
	AuthenticatedInvestmentRoundRepository	repository;

	@Autowired
	AuthenticatedInvestorRepository			repoInvestor;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		boolean result;
		int investmentRoundId;
		InvestmentRound investmentRound;

		investmentRoundId = request.getModel().getInteger("id");
		investmentRound = this.repository.findOneById(investmentRoundId);

		result = investmentRound.getActive();

		return result;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		int investorId = request.getPrincipal().getAccountId();
		Investor investor = this.repoInvestor.findOneInvestorByUserAccountId(investorId);

		if (investor != null) {
			entity.setIsInvestor(true);
		} else {
			entity.setIsInvestor(false);
		}

		Alerta a = this.repository.findAlertaToThisInvestmentRound(entity.getId());
		if (a == null) {
			entity.setAyuda(false);
		} else {
			entity.setAyuda(true);
		}

		request.unbind(entity, model, "ticker", "creation", "kindRound", "title", "description", "amount", "link", "active", "hasApp", "isInvestor", "entrepreneur", "ayuda");

	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {

		assert request != null;

		InvestmentRound result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
