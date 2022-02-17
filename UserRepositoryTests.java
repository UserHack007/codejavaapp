package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	 @Autowired
	    private TestEntityManager Manager;
	     
	    @Autowired
	    private UserRepository repo;
	    
	    
	    @Test
	    public void testCreateUser() {
	        User user = new User();
	        user.setEmail("sasikumar@gmail.com");
	        user.setPassword("sasi2020");
	        user.setFirstName("sasi");
	        
	        user.setLastName("Kumar");
	         
	        User savedUser = repo.save(user);
	         
	        User existUser = Manager.find(User.class, savedUser.getId());
	         
	        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
} 
	    @Test
	    public void testFindUserByEmail() {
	    	String email ="janap574@gmail.com";
	    	User user = repo.findByEmail(email);
	    	assertThat(user).isNotNull();
	    }
}
