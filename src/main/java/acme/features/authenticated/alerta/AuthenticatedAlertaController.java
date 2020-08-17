
package acme.features.authenticated.alerta;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.alertas.Alerta;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/alerta/")
public class AuthenticatedAlertaController extends AbstractController<Authenticated, Alerta> {

	@Autowired
	private AuthenticatedAlertaListService	listService;

	@Autowired
	private AuthenticatedAlertaShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
