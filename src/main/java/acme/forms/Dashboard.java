
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= -4816218832536026396L;

	Double						ratioInvestmentRoundsAlerta;
	Double						ratioApplicationLink;
	Double						ratioApplicationPass;

}
