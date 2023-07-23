package in.ashokit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
//it represents all the primary keys of the table
//composite primary keys
public class AccountPK implements Serializable {
	
	private Long accNum;
	
	private String accType;

}
