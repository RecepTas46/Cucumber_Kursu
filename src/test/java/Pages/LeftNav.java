package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {

    public LeftNav() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Countries']")
    private WebElement country;

    @FindBy(xpath = "//span[text()='Citizenships']")
    private WebElement citizenShip;

    @FindBy(xpath = "(//span[text()='Inventory'])[1]")
    private WebElement inventory;

    @FindBy(xpath = "(//span[text()='Setup'])[4]")
    private WebElement setupTwo;

    @FindBy(xpath = "(//span[text()='Item Categories'])[1]")
    private WebElement itemCategories;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamsOne;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupTree;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsTwo;
    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResources;

    @FindBy(xpath = "//span[text()='Employees']")
    private WebElement Employees;

    @FindBy(xpath = "//span[text()='Education']")
    private WebElement EducationBtn;

    @FindBy(xpath = "(//span[text()='Setup'])[5]")
    private WebElement setupfive;

    @FindBy(xpath = "//span[text()='Subject Categories']")
    private WebElement subjectCategoriesBtn;

    @FindBy(xpath = "(//span[text()='Subjects'])[1]")
    private WebElement subjectBtn;

    @FindBy(xpath = "//span[text()='Budget']")
    private WebElement budgetBtn;

    @FindBy(xpath = "(//span[text()='Setup'])[6]")
    private WebElement setupSix;

    @FindBy(xpath = "//span[text()='Budget Groups']")
    private WebElement BudgetGroupsBtn;

    @FindBy(xpath = "//span[text()='Cost Centers']")
    private WebElement BudgetCostCenterBtn;


    WebElement myElement;

    public void findAndClick(String elementName) {
        switch (elementName) {
            case "setupOne":
                myElement = setupOne;
                break;

            case "parameters":
                myElement = parameters;
                break;

            case "Countries":
                myElement = country;
                break;

            case "citizenShip":
                myElement = citizenShip;
                break;

            case "inventory":
                myElement = inventory;
                break;

            case "setupTwo":
                myElement = setupTwo;
                break;

            case "itemCategories":
                myElement = itemCategories;
                break;

            case "nationalities":
                myElement = nationalities;
                break;

            case "fees":
                myElement = fees;
                break;
            case "entranceExamsOne":
                myElement = entranceExamsOne;
                break;
            case "setupTree":
                myElement = setupTree;
                break;

            case "entranceExamsTwo":
                myElement = entranceExamsTwo;
                break;
            case "humanResources":
                myElement = humanResources;
                break;
            case "Employees":
                myElement = Employees;
                break;
            case "EducationBtn":
                myElement = EducationBtn;
                break;
            case "setupfive":
                myElement = setupfive;
                break;
            case "subjectCategoriesBtn":
                myElement = subjectCategoriesBtn;
                break;
            case "subjectBtn":
                myElement = subjectBtn;
                break;

            case "budgetBtn":
                myElement = budgetBtn;
                break;
            case "setupSix":
                myElement = setupSix;
                break;
            case "BudgetGroupsBtn":
                myElement = BudgetGroupsBtn;
                break;
            case "BudgetCostCenterBtn":
                myElement = BudgetCostCenterBtn;
                break;

        }

        clickFunction(myElement);
    }
}
