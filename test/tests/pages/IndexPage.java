package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides testing support for the Index page.
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Home Digits");
  }

  /**
   * Checks to see that the Index page has the contacts that we input.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   */
  public void hasContact(String firstName, String lastName, String telephone, String telephoneType) {
    assertThat(pageSource().contains(firstName));
    assertThat(pageSource().contains(lastName));
    assertThat(pageSource().contains(telephone));
    assertThat(pageSource().contains(telephoneType));
  }

}
