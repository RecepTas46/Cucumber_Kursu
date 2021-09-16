package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement acceptCookies;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    public WebElement dashboard;

    @FindBy(xpath = "//ms-table-toolbar//ms-add-button[contains(@class, 'ng-star-inserted')]//button")
    //ms-add-button[contains(@tooltip,'TITLE.ADD')]//button
//stalElement hatasi ayni lokator den onceki sayfa da bir adet daha bulmasi..
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'error')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;
    @FindBy(xpath = "//div[contains(text(),'deleted')]")

    private WebElement cannotDeletedMsg;
    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//mat-form-field//ms-text-field[contains(@id,'ms-text-field')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(css = "div>mat-option>span")
    private List<WebElement> userTypeAllOptions;

    @FindBy(xpath = "//mat-chip-list[@formcontrolname='roles']//input")
    private WebElement userType;

    @FindBy(xpath = "(//div[@class='ps__rail-y'])[2]")
    private WebElement rightScroll;

    @FindBy(xpath = "//input[@id='ms-integer-field-0']")
    private WebElement priorityInput;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']/input")
    private WebElement priorityCode;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']/input")
    private WebElement integrationCode;
    @FindBy(xpath = "//ms-edit-button//button")
    private WebElement editBtn;

    @FindBy(xpath = "(//mat-select//div[contains(@id,'mat-select-value')])[3]")
    private WebElement subjectSelectBtn;


    @FindBy(xpath = "(//ms-text-field[contains(@placeholder,'DESCRIPTION')])[2]//input[contains(@id,'ms-text-field')]")
    private WebElement descriptionClick;

    @FindBy(css = "div>mat-option>span")
    private List<WebElement> EducatinonSubjectOptions;

    @FindBy(xpath = "(//ms-date//mat-form-field//div[contains(@class,'mat-form-field-wrapper ng-tns')])[1]")
    private WebElement BudgetStardDate;

    @FindBy(xpath = "(//ms-date//mat-form-field//div[contains(@class,'mat-form-field-wrapper ng-tns')])[2]")
    private WebElement BudgetEndDate;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'ORDER_NO')]//input")
    private WebElement BudgetOrderNo;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;


    WebElement myElement;

    public void findAndSend(String elementName, String value) {//text ise yani veri gonderecek isek buraya ekliyoruz
//        if (elementName=="username")
//            myElement=username;

        switch (elementName) {

            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
            case "nameInput":
                myElement = nameInput;
                break;

            case "codeInput":
                myElement = codeInput;
                break;
            case "shortName":
                myElement = shortName;
                break;

            case "searchInput":
                myElement = searchInput;
                break;

            case "priorityInput":
                myElement = priorityInput;
                break;

            case "priorityCode":
                myElement = priorityCode;
                break;

            case "integrationCode":
                myElement = integrationCode;
                break;


        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String elementName) {
        switch (elementName) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "addButton":
                myElement = addButton;
                break;
            case "acceptCookies":
                myElement = acceptCookies;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
            case "closeDialog":
                myElement = closeDialog;
                break;

            case "searchButton":
                myElement = searchButton;
                break;

            case "deleteButton":
                myElement = deleteButton;
                break;

            case "deleteDialogBtn":
                myElement = deleteDialogBtn;
                break;
            case "rightScroll":
                myElement = rightScroll;
                break;
            case "editBtn":
                myElement = editBtn;
                break;

            case "subjectSelectBtn":
                myElement = subjectSelectBtn;
                break;
            case "descriptionClick":
                myElement = descriptionClick;
                break;

            case "BudgetStardDate":
                myElement = BudgetStardDate;
                break;
            case "BudgetEndDate":
                myElement = BudgetEndDate;
                break;
            case "BudgetOrderNo":
                myElement = BudgetOrderNo;
                break;

        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String elementName, String msg) {
        switch (elementName) {
            case "successMessage":
                myElement = successMessage;
                break;

            case "errorMessage":
                myElement = errorMessage;
                break;
            case "alreadyExist":
                myElement = alreadyExist;
                break;

            case "cannotDeletedMsg":
                myElement = cannotDeletedMsg;
                break;
        }

        verifyContainsText(myElement, msg);
    }

    public void findAndDelete(String deleteString) {
        // tıklatma
        scrollToUpElement(rightScroll);
        findAndSend("searchInput", deleteString);
        findAndClick("searchButton");

        // çöp kovaları 5 den az olana kadar bekle: search sonucu gözükene kadar bekle
        waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"), 5);

        findAndClick("deleteButton");
        findAndClick("deleteDialogBtn");
    }


    List<WebElement> myList;

    public void ChooseListElement(String listName, String option)//choose-->secim
    {
        switch (listName) {
            case "userTypeAllOptions":
                myList = userTypeAllOptions;
                break;

            case "EducatinonSubjectOptions":
                myList = EducatinonSubjectOptions;
                break;

        }

        listSelectOption(myList, option);
    }

    public void findAndEdit(String oldWord, String newWord) {
        // tıklatma
        scrollToUpElement(rightScroll);
        findAndSend("searchInput", oldWord);
        findAndClick("searchButton");

        // çöp kovaları 5 den az olana kadar bekle: search sonucu gözükene kadar bekle
        waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"), 5);

        findAndClick("editBtn");
        findAndSend("nameInput", newWord);
        findAndClick("saveButton");
    }
}
