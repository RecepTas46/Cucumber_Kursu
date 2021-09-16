package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class _10_EducationSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("^Navigate to education page$")
    public void navigateToEducationPage() {
        ln.findAndClick("EducationBtn");
        ln.findAndClick("setupfive");
    }

    @When("^Create a education name as \"([^\"]*)\" code as \"([^\"]*)\"$")
    public void createAEducationNameAsCodeAs(String SubCategName, String code) {
        ln.findAndClick("subjectCategoriesBtn");
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", SubCategName);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("saveButton");
    }


    @When("^User delete the education \"([^\"]*)\"$")
    public void userDeleteTheEducation(String newWord) {
        ln.findAndClick("subjectCategoriesBtn");
        dc.findAndDelete(newWord);
    }

    @When("^User edit the education \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userEditTheToEducation(String oldWord, String newWord) {
        ln.findAndClick("subjectCategoriesBtn");
        dc.findAndEdit(oldWord, newWord);

    }


    @When("^Create a subject education name as \"([^\"]*)\" code as \"([^\"]*)\"$")
    public void createASubjectEducationNameAsCodeAs(String name, String code) {
        ln.findAndClick("subjectBtn");
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("subjectSelectBtn");
        dc.ChooseListElement("EducatinonSubjectOptions", "Mathematics");
        dc.findAndClick("saveButton");
    }


    @Then("^Can not be deleted message should be displayed$")
    public void canNotBeDeletedMessageShouldBeDisplayed() {
        dc.findAndContainsText("cannotDeletedMsg", "deleted");
    }

    @When("^User delete the subject education \"([^\"]*)\"$")
    public void userDeleteTheSubjectEducation(String name) {
        ln.findAndClick("subjectBtn");
        dc.findAndDelete(name);
    }

    @When("^Create a subject new education name as \"([^\"]*)\" code as \"([^\"]*)\"$")
    public void createASubjectNewEducationNameAsCodeAs(String name, String code)  {
        ln.findAndClick("subjectBtn");
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("subjectSelectBtn");
        dc.ChooseListElement("EducatinonSubjectOptions", "MySubjectCat");
        dc.findAndClick("saveButton");
    }
}
