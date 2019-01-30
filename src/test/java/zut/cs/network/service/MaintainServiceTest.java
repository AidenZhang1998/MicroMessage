package zut.cs.network.service;



import org.junit.Before;
import org.junit.Test;

public class MaintainServiceTest {
	MaintainService maintainService;
	@Before
	public void setUp() throws Exception {
	 maintainService =new MaintainService();
		
	}

	@Test
	public void testDeleteOne() {

	}

	@Test
	public void testDeleteBatch() {
	
	}

	@Test
	public void testCreateOne() {
		maintainService.CreateOne("test", "test", "test");
	}

}
