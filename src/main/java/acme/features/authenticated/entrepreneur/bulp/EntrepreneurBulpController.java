
package acme.features.authenticated.entrepreneur.bulp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulps.Bulp;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/bulp/")
public class EntrepreneurBulpController extends AbstractController<Entrepreneur, Bulp> {

	@Autowired
	private EntrepreneurBulpListService		listService;

	@Autowired
	private EntrepreneurBulpShowService		showService;

	@Autowired
	private EntrepreneurBulpCreateService	createService;

	@Autowired
	private EntrepreneurBulpUpdateService	updateService;

	@Autowired
	private EntrepreneurBulpDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
