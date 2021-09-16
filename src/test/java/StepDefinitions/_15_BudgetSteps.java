package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.BaseDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class _15_BudgetSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("^Navigate to Budget page$")
    public void navigateToBudgetPage() {
        ln.findAndClick("budgetBtn");
        ln.findAndClick("setupSix");
        ln.findAndClick("BudgetGroupsBtn");


    }


    @When("^Create a  \"([^\"]*)\" and Started$")
    public void createAAndStarted(String description) {
        dc.findAndClick("addButton");
        dc.findAndClick("descriptionClick");
        dc.findAndSend("descriptionClick", description);

    }

    @And("^Create a Date$")
    public void createADate() {
        dc.findAndClick("BudgetStardDate");
        holiday1(5);

        dc.findAndClick("BudgetEndDate");
        holiday1(8);
        dc.findAndClick("saveButton");
    }

    public void holiday1(int gun) {
        Actions actions = new Actions(BaseDriver.getDriver());
        for (int i = 0; i < 6 + gun; i++) {
            actions.sendKeys(Keys.TAB).build().perform();
        }
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    @When("^Create a cost centers name as \"([^\"]*)\" code as \"([^\"]*)\" and expense \"([^\"]*)\"$")
    public void createACostCentersNameAsCodeAsAndExpense(String name, String code, String expense) {
        ln.findAndClick("BudgetCostCenterBtn");
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("BudgetOrderNo");

    }
}
