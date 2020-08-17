
package acme.features.authenticated.entrepreneur.alerta;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.alertas.Alerta;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/alerta/")
public class EntrepreneurAlertaController extends AbstractController<Entrepreneur, Alerta> {

	@Autowired
	private EntrepreneurAlertaListService	listService;

	@Autowired
	private EntrepreneurAlertaShowService	showService;

	@Autowired
	private EntrepreneurAlertaCreateService	createService;

	@Autowired
	private EntrepreneurAlertaUpdateService	updateService;

	@Autowired
	private EntrepreneurAlertaDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
