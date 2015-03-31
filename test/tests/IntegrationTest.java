package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewContactPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {

  /**
   * The port to be used for testing.
   */
  private final int port = 3333;

  /**
   * Check to see that both the index and page1 pages can be retrieved.
   */
  @Test
  public void test() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("Current Contacts");

        browser.goTo("http://localhost:3333/newcontact");
        assertThat(browser.pageSource()).contains("Add");
      }
    });
  }

  /**
   * Check to see that the index page can be retrieved.
   */
  public void testRetrieveIndexPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage indexPage = new IndexPage(browser.getDriver(), port);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }

  /**
   * Check to see that the NewContact page can be retrieved, that we can create a new contact, and then verify
   * that the new contact page shows the new contact.
   */
  public void testCreateNewContact() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage indexPage = new IndexPage(browser.getDriver(), port);
        NewContactPage contactPage = new NewContactPage(browser.getDriver(), port);
        browser.goTo(contactPage);
        contactPage.isAt();
        String firstName = "David";
        String lastName = "Neely";
        String telephone = "808-808-8080";
        String telephoneType  = "Work";
        contactPage.createContact(firstName, lastName, telephone, telephoneType);
        browser.goTo(indexPage);
        indexPage.hasContact(firstName, lastName, telephone, telephoneType);
      }
    });
  }
}
