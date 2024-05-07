package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * @author Ahsan Habib
 */
public class SeleniumOperationsTest {
	
	SeleniumOperations inst;
	
	@Before
	public void setup() {
		inst=new SeleniumOperations();
		System.out.println("Before...");
	}
	
    @After
    public void teardown() {
        inst.quitDriver(); // Quit WebDriver after each test
		System.out.println("Close...");
    }
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s222435189";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Samadhi Jayasinghe";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNullLoginEmailNullPasswordExceptionRules() {
		thrown.expect(IllegalArgumentException.class);
		
		String result=inst.bunnings_login_page(null,null);
		Assert.assertNull(result);
	}
	
	@Test
	public void testNullLoginEmailValidPasswordExceptionRules() {
		thrown.expect(IllegalArgumentException.class);
		
		String result=inst.bunnings_login_page(null, "Faluda@123");
		Assert.assertNull(result);
	}
	
	@Test
	public void testNullLoginEmailInvalidPasswordExceptionRules() {
		thrown.expect(IllegalArgumentException.class);
		
		String result=inst.bunnings_login_page(null, "invalidpass");
		Assert.assertNull(result);
	}
	
	@Test
	public void testLoginEmailInvalidPasswordEmptyResultLoginFails() {
		thrown.expect(IllegalArgumentException.class);
		String result=inst.bunnings_login_page("invalid@email.com", null);
		Assert.assertNull(result);
	}
	
	@Test
	public void testLoginEmailInvalidPasswordValidResultLoginFails() {
		String result=inst.bunnings_login_page("invalid@email.com", "Faluda@123");
		Assert.assertEquals(result, "Login fails");
		System.out.println("--LoginEmail Invalid + Password Valid = Result Login fails");
	}
	
	@Test
	public void testLoginEmailInvalidPasswordInvalidResultLoginFails() {
		String result=inst.bunnings_login_page("invalid@email.com", "invalidpass");
		Assert.assertEquals(result, "Login fails");
		System.out.println("--LoginEmail Invalid + Password Invalid = Result Login fails");
	}
	
	@Test
	public void testValidLoginEmailNullPasswordExceptionRules() {
		thrown.expect(IllegalArgumentException.class);
		
		String result=inst.bunnings_login_page("samadhi0727@gmail.com",null);
		Assert.assertNull(result);
	}

	@Test
	public void testLoginEmailValidPasswordValidLoginSucceed() {
		String result=inst.bunnings_login_page("samadhi0727@gmail.com", "Faluda@123");
		Assert.assertEquals(result, "Login succeed");
		System.out.println("--LoginEmail Valid + Password Valid = Result Login succeed");
	}
	
	@Test
	public void testLoginEmailValidPasswordInvalidResultLoginFails() {
		String result=inst.bunnings_login_page("samadhi0727@gmail.com", "invalidpass");
		Assert.assertEquals(result, "Login fails");
		System.out.println("--LoginEmail Valid + Password Invalid = Result Login fails");
	}
	
	

}
