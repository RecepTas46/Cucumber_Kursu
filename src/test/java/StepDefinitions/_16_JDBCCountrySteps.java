package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _16_JDBCCountrySteps {


    @When("^Send the query the database \"([^\"]*)\" and Control Match$")
    public void sendTheQueryTheDatabaseAndControlMatch(String query) {
        // DB den Gelen List
        List<List<String>> dbList= DBUtility.getListData(query);
        System.out.println("dbList = " + dbList);

        // UI (WEB) den gelen list
        DialogContent dc=new DialogContent();
        List<WebElement> uiList=dc.waitVisibleListAllElemenet(dc.nameList);
        for (WebElement e:uiList)
        {
            System.out.println("e.getText() = " + e.getText());
        }

        for (int i = 0; i <dbList.size() ; i++)
        {
            System.out.println(dbList.get(i).get(1)+" "+uiList.get(i).getText());
            Assert.assertEquals(dbList.get(i).get(1),uiList.get(i).getText());
        }

    }
}
