
package acme.entities.toolRecords;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "stars")
})
public class ToolRecord extends DomainEntity {

	private static final long	serialVersionUID	= 5818960712486903853L;

	@NotBlank
	private String				title;

	@NotBlank
	private String				activitySector;

	@NotBlank
	private String				inventorName;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				website;

	@NotBlank
	@Email
	private String				email;

	private Boolean				openSource;

	@NotNull
	@Range(min = -5, max = 5)
	private int					stars;

}
