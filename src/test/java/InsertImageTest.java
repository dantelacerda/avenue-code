import org.junit.Assert;
import org.mockito.Mockito;

import com.avenue.model.Image;
import com.avenue.repository.ImageRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The Class ValidaProtestoBeneficiarioTest.
 */
public class InsertImageTest {

	private Image image;

	private ImageRepository imageRepository;

	/**
	 * Configure the Image and Repository with values
	 */
	@Given("^The Image params")
	public void configureImageAndRepository() {

		imageRepository = Mockito.mock(ImageRepository.class);
		image = new Image();
		image.setType("test");

	}

	/**
	 * Save the image with success
	 */
	@When("^Save the image with success")
	public void saveImage() {

		Mockito.when(imageRepository.save(image)).thenReturn(image);

	}

	/**
	 * Verify is there was Value on Image Type
	 */
	@Then("^Verify is there was Value on Image Type")
	public void verifyTypeValue() {

		boolean notEmpty = !"".equals(image.getType());

		Assert.assertEquals(notEmpty, true);

	}
}