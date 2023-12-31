package in.ashokit;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Account;
import in.ashokit.entity.AccountPK;
import in.ashokit.repo.AccountRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = 
				SpringApplication.run(Application.class, args);
		
		AccountRepo bean = ctxt.getBean(AccountRepo.class);
		
		//setting composite key values
		AccountPK pk = new AccountPK();
		pk.setAccNum(365547676l);
		pk.setAccType("Savings");
	
		//setting entity data
		Account acc =new Account();
		acc.setHolderName("Ashok");
		acc.setBranch("Ammerpet");
		acc.setAccountPK(pk);//setting pk obj
		
		bean.save(acc);//saving the entity obj
		
		System.out.println("Record saved.....");
		
		/*
		AccountPK pk = new AccountPK();
		pk.setAccNum(365547676l);
		pk.setAccType("Savings");
		
		Optional<Account> findById = bean.findById(pk);
		if(findById.isPresent()) {
			System.out.println(findById.get());
		}
		*/
	}

}
