package acctMan;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//foo
public class AccountManagerTest {
	AccountManager am;
	
	@Before
	public void setUp() throws Exception {
		am = new AccountManager();
	}

	@Test
	public void testDefault() {
		assertTrue(am.checkName("Molly"));
		assertTrue(am.checkName("Patrick"));
		assertFalse(am.checkName("Bill"));
		assertFalse(am.tryLogin("Molly", "1234"));
		assertTrue(am.tryLogin("Molly", "FloPup"));
	}
	
	@Test
	public void testAdd(){
		assertTrue(am.addUser("Bill", "12345"));
		assertFalse(am.addUser("Bill", "diffpassword"));
		assertTrue(am.checkName("Bill"));
		assertTrue(am.tryLogin("Bill", "12345"));
		assertFalse(am.tryLogin("Bill", "FloPup"));
		assertFalse(am.tryLogin("Bill", "diffpassword"));
	}

}
