import org.junit.Assert;
import org.mockito.Mockito;

import com.avenue.model.Product;
import com.avenue.repository.ProductRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The Class ValidaProtestoBeneficiarioTest.
 */
public class InsertProductTest {

	private Product product;

	private ProductRepository productRepository;

	/**
	 * Configure the Product and Repository with values
	 */
	@Given("^The Product params")
	public void configureProductAndRepository() {

		productRepository = Mockito.mock(ProductRepository.class);
		product = new Product();
		product.setName("teste");

	}

	/**
	 * Save the product with success
	 */
	@When("^Save the product with success")
	public void saveProduct() {

		Mockito.when(productRepository.save(product)).thenReturn(product);

	}

	/**
	 * Verify is there was Value on Product Type
	 */
	@Then("^Verify is there was Value on Product Name")
	public void verifyTypeValue() {

		boolean notEmpty = !"".equals(product.getName());

		Assert.assertEquals(notEmpty, true);

	}
}