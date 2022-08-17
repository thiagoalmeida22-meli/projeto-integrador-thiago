package dh.meli.projeto_integrador.model;

import lombok.*;

import javax.persistence.*;

/**
 * Method Getter implemented by Lombok lib for get access the private attributes of the Batch Class
 */
@Getter
/**
 * Method Setter implemented by Lombok lib for set the private attributes of the Batch Class
 */
@Setter
/**
 * The @Entity annotation marks the Batch Class as an entity bean,
 * so it must have a no-argument constructor that is visible at least with a protected scope.
 */
@Entity
/**
 * The @Table annotation is used to specify table details that will be used to persist our entities in the database.
 */
@Table(name = "fidelity")
/**
 * Method builder implemented by Lombok lib
 */
@Builder
/**
 * Method Default Constructor implemented by Lombok lib
 */
@NoArgsConstructor
/**
 * Method Constructor with all arguments implemented by Lombok lib
 */
@AllArgsConstructor
/**
 * Class created for modeling the Batch entity on the database
 * @author Thiago Almeida
 * @version 0.0.1
 * @see java.lang.Object
 */
public class Fidelity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "cost")
	private Long cost;
}
