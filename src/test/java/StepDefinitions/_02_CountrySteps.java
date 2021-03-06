package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {

    DialogContent dc=new DialogContent();

    @Then("^Navigate to country page$")
    public void navigate_to_country_page()  {
        LeftNav ln=new LeftNav();
        ln.findAndClick("setupOne");//Setup click
        ln.findAndClick("parameters");//Parameter Click
        ln.findAndClick("Countries");//Country Click
    }

    @When("^Create a country$")
    public void create_a_country() {
        String randomGenName= RandomStringUtils.randomAlphabetic(8);//jenkis icin hata olusmamasi adina random yapildi
        String randomGenCode= RandomStringUtils.randomAlphabetic(4);
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",randomGenName);
        dc.findAndSend("codeInput",randomGenCode);
        dc.findAndClick("saveButton");
    }

    @Then("^Success message should be displayed$")
    public void success_message_should_be_displayed()  {
        dc.findAndContainsText("successMessage","success");
    }

    @When("^Create a country name as \"([^\"]*)\" code as \"([^\"]*)\"$")
    public void create_a_country_name_as_code_as(String name, String code)  {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("codeInput",code);
        dc.findAndClick("saveButton");
    }

    @When("^User edit the \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userEditTheTo(String oldWord, String newWord)  {
        dc.findAndEdit(oldWord, newWord);

    }
    @When("^User delete the \"([^\"]*)\"$")
    public void userDeleteThe(String newWord) {
        dc.findAndDelete(newWord);

    }

}

