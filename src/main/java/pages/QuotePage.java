package pages;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class QuotePage {
    private WebDriver driver;

    public QuotePage(WebDriver driver) {
        this.driver = driver;
    }

    private By quoteIcon = By.cssSelector("ul[id='side-menu']>li:nth-child(4)");
    private By displayedMessage = By.xpath("//div[@id='page-wrapper']/div[3]/div/h2");

    private By addQuoteButton = By.xpath("//div[@class=' tooltip-demo pull-right']/a[2]");

    private By messageOnAddQuotePage = By.xpath("//div[@id='page-wrapper']/div[3]/div/h2");

    private By monthlyPremiumColumn = By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[16]");

    private By microchipButton = By.xpath("//div[@class='form-group pull-right']/div/a[3]");

    private By productListDropDown = By.xpath("//div[@class='ibox-content']/div/div/div[4]/div/div/span");

    private By quoteStatusDropDown = By.xpath("//div[@class='ibox-content-search m-b-sm']/div/div/div[5]/div/div/div/button");

    private By statusOpen = By.xpath("//div[@class='ms-drop']/ul/li[1]");

    //Fetch quote list based upon product dropdown options

    private By productDropdown = By.xpath("//div[@class='ibox-content-search m-b-sm']/div[1]/div[1]/div[2]/div/span");

    private By optionsFromProductDD = By.xpath("//ul[@id='ProductId_listbox']/li[3]");

    private By isReferredDropdown = By.xpath("//div[@class='ibox-content-search m-b-sm']/div[1]/div[1]/div[3]/div/span");

    private By optionsFromIsReferredDD = By.xpath("//ul[@id='IsReferRequired_listbox']/li[2]");

    private By divisionDropdown = By.xpath("//div[@class='ibox-content-search m-b-sm']/div[1]/div[2]/div[3]/div/span");

    private By optionsFromDivisionDD = By.xpath("//ul[@id='DivisionId_listbox']/li[2]");


    private By detailsOfQuotes = By.xpath("//div[@id='gridName']/table/tbody/tr");
    private By searchButton = By.cssSelector("button[id='SearchGrid']");

    //Fetch quote on manage quote page based on quote number

    private By quoteSearchBox = By.cssSelector("input[id='QuoteNumber']");

    //Verify include payment feature of quote module for Qa

    private By includePaymentCheckBox = By.cssSelector("div[id='search']>:nth-child(2)>:nth-child(4)>:nth-child(1)>div[class^='icheckbox_square-green']");

    private By petIdCheckBox = By.cssSelector("div[id='search']>:nth-child(2)>:nth-child(5)>:nth-child(1)>div");

    //Upload Microchip page

    private By fileNameLinkOnUploadMicrochipPage = By.xpath("//div[@id='MicrochipFileUploadAuditGrid']/table/tbody/tr");

    private By cancelIconOnUploadWindow = By.xpath("//div[@class='k-widget k-window']/div/div/a/span");

    private By chooseFileButton = By.cssSelector("input[type='file']");

    private By uploadFileButton = By.xpath("//div[@class='row search-row']/div[2]/div/button");

    private By pendingMicrochipButton=By.xpath("//div[@class='form-group pull-right']/div/a[4]");

    private By detailsOnPendingMicrochipPage=By.xpath("//div[@id='PendingMicrochipFileUploadAuditGrid']/table/tbody/tr/td");


    //Edit quote information and verifies the same

    private By selectCogIcon = By.xpath("//div[@id='gridName']/table/tbody/tr[1]/td[20]/ul/li/a");

    private By selectEditQuoteIcon = By.xpath("//div[@id='gridName']/table/tbody/tr[1]/td[20]/ul/li/ul/li[1]/a");

    private By enterPostCodeInAddressDropDown = By.cssSelector("input[id='Address1']");

    private By selectPostCodeFromDD = By.xpath("//div[@id='cc_c2a']/ul/li[3]");

    private By hearAboutUsDropDown = By.xpath("//div[@id='divhear']");

    private By selectOptionFromHearAboutUsDD = By.xpath("//ul[@id='HearAboutUs_listbox']/li[3]");

    private By petSpeciesDropDown = By.xpath("//div[@id='Div_138']/div/div/span");

    private By selectOptionFromPetSpeciesDD = By.xpath("//ul[@id='Question_138_listbox']/li[6]");

    private By petName=By.xpath("//div[@id='Div_139']/div/div/input");

    private By petGenderDropDown = By.xpath("//div[@id='Div_140']/div/div/span");

    private By selectOptionsFromPetGDD = By.xpath("//ul[@id='Question_140_listbox']/li[2]");

    private By petBirthDate = By.cssSelector("input[id='Question_141']");

    private By petPurchaseAmount = By.xpath("//div[@id='Div_142']/div/div/span/span/input[@id='Question_142']");

    private By petAdminFees = By.cssSelector("input[id='Question_231']");

    private By calculateButton = By.xpath("//button[@id='btnCalculate']");

    // private By closeButton = By.xpath("//button[@class='btn btn-primary' and @data-dismiss='modal']");

    // private By saveButton = By.xpath("//div[@id='divQuoteSavebutton']/div[2]/div/button[2]");

    // private By fetchPetBreed = By.xpath("//div[@class='col-lg-4 view-column form-group ']/div[3] /div/label");

    //Quote Information with status code
    private By quoteLinkOnManageQuotePage=By.xpath("//div[@id='gridName']/table/tbody/tr[1]/td[2]/a");
    private By quoteCodeOnManageQuotePage=By.xpath("//div[@id='gridName']/table/tbody/tr[1]/td[5]/div");
    private By quoteStatusCode=By.xpath("button[class='btn boxcolor boxcolor-blue']");




    public String verifyManageQuotePage() {
        driver.findElement(quoteIcon).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(displayedMessage).getText();
    }

    public String fetchAndDisplayedData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalRow = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody/tr")));
        String array = " ";
        for (WebElement rEle : totalRow) {
            array = array + " " + rEle.getText();
        }
        return array;
    }

    public String verifyQuoteDateColumnForamt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> quoteDateColumn = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[3]")));
        String date = "";
        for (WebElement quoteDate : quoteDateColumn) {
            date = date + " " + quoteDate.getText().toString();

        }
        return date;

    }

    public String verifyExpireDateColumnFormat() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> expireDateColumn = eWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[4]")));
        String date = "";
        for (WebElement expireDate : expireDateColumn) {
            date = date + " " + expireDate.getText().toString();

        }
        return date;

    }

    public void clickOnAddQuoteButton() {
        driver.findElement(addQuoteButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String verifyAddQuotePage() {
        return driver.findElement(messageOnAddQuotePage).getText();
    }

    public String verifyTotalPremiumColumn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView();", driver.findElement(monthlyPremiumColumn));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> yearlyPremiumColum = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[15]")));
        String yPremium = " ";
        for (WebElement amountP : yearlyPremiumColum) {
            yPremium = yPremium + " " + amountP.getText().toString();
        }
        return yPremium;
    }

    public String verifyMonthlyPremiumColumn() {
        WebDriverWait mWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> monthlyPremiumColumn = mWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[16]")));
        String yPremium = " ";
        for (WebElement amountP : monthlyPremiumColumn) {
            yPremium = yPremium + " " + amountP.getText().toString();
        }
        return yPremium;

    }

    public String clickOnMicrochipButton() {
        driver.findElement(microchipButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(displayedMessage).getText();
    }

    public String verifyDataOnMicrochipPage() {
        WebDriverWait rWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalRow = rWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='MicrochipFileUploadAuditGrid']/table/tbody/tr")));
        String data = " ";
        for (WebElement rEle : totalRow) {
            data = data + " " + rEle.getText();
        }
        return data;
    }

    public String verifyProductList() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(productListDropDown).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> pList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul[id='PrimaryProductId_listbox']>li")));
        System.out.println(pList.size());

        String verfiy = " ";
        for (WebElement product : pList) {

            verfiy = verfiy + product.getText() + " ";

        }
        return verfiy;
    }

    public String fetchDataOfQuoteInformation() {
        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody[1]/tr/td[2]/a")));
        String displayMessage = " ";
        for (WebElement cEle : totalColumn) {
            System.out.println(cEle.getText());

            cEle.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            //System.out.println(driver.getCurrentUrl());

            System.out.println(driver.getCurrentUrl());
            displayMessage = displayMessage + driver.findElement(displayedMessage).getText();

            driver.close();
            driver.switchTo().window(tabs2.get(0));
        }

        return displayMessage;
    }

    //Items on manage quote page displays upon option selects from quote status dropdown
    public void SelectItemFromDropDown() {
        driver.findElement(quoteStatusDropDown).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(statusOpen).click();
        driver.findElement(searchButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String fetchAndVerifyDataAgainstDropDown() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalRow = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody/tr")));
        String array = " ";
        for (WebElement rEle : totalRow) {
            array = array + " " + rEle.getText();
        }
        return array;
    }

    //Fetch list of quote based upon product drop down

    public void selectOptionFromProductDropDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(productDropdown).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(optionsFromProductDD).click();

    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<WebElement> verifyListOfQuoteBasedOnProductDD() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> listOfProduct = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridName']/table/tbody/tr")));
        return listOfProduct;

    }

    //Fetch list of quote based on option from Is referred dropdown on manage quote page

    public void selectOptionFromIsReferredDropDown() {

        driver.findElement(isReferredDropdown).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(optionsFromIsReferredDD).click();

    }


    public String verifyListOfQuoteBasedOnIsReferredDD() {
        return driver.findElement(detailsOfQuotes).getText();

    }


    //Fetch list of quote based on option from division dropdown on manage quote page

    public void selectOptionFromDivisionDropDown() {

        driver.findElement(divisionDropdown).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(optionsFromDivisionDD).click();

    }


    public String verifyListOfQuoteBasedOnDivisionDD() {
        return driver.findElement(detailsOfQuotes).getText();

    }

    //Verify include payment feature of quote module for Qa

    public void selectPetIdCheckBox() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(petIdCheckBox).click();


    }

    public String verifyPetIdDetailsOfQuote() {
        return driver.findElement(detailsOfQuotes).getText();
    }

    //Upload details window should open by clicking on file name link on microchip file upload page

    public void clickOnFileNameLink() {
        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> totalColumn = cWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='MicrochipFileUploadAuditGrid']/table/tbody/tr")));

        for (WebElement cEle : totalColumn) {

            cEle.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            break;
        }

    }

    public void clickOnCancelButtonOnUploadWindow() {
        //WebDriverWait wait=new WebDriverWait(driver,10);
        // WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        //element.click();

        WebElement m = driver.findElement(By.xpath("//div[@class='k-window-titlebar k-header']/div/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", m);
    }

    //verify functionality of upload file feature  on microchip upload file page

    public String uploadFile() {
        driver.findElement(chooseFileButton).sendKeys("C:\\Users\\prowe\\Desktop\\bug.PNG");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(uploadFileButton).submit();
        String fileUpload = driver.getPageSource();
        /*if(driver.getPageSource().contains("File Uploaded!")) {
            System.out.println("file uploaded");
        }
        else{
            System.out.println("file not uploaded");
        }*/
        return fileUpload;
    }

    //Pending Microchip displays with details by clicking on pending microchip button on manage quote page
    public void clickOnPendingMicrochipButton(){
        driver.findElement(pendingMicrochipButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String verifyPendingMicrochipPage(){
       return driver.findElement(detailsOnPendingMicrochipPage).getText();

    }


    //Fetch quote on manage quote page based on quote number for UK2 Qa

    public void enterQuoteNumberInsideSearchBox() {
        driver.findElement(quoteSearchBox).sendKeys("Q0042274");
    }

    public String verifyQuoteDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quoteInfo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='gridName']/table/tbody/tr[1]")));
        return quoteInfo.getText();
    }


    //Fetch quote on manage quote page based on quote number for stage

    public void enterQuoteNumberInsideSearchBoxStage() {
        driver.findElement(quoteSearchBox).sendKeys("Q0064379");
    }


    //Verify include payment feature of quote module for Qa

    public void selectIncludePaymentCheckBox() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(includePaymentCheckBox).click();


    }

    public String verifyIncludePaymentDetailsOfQuote() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement quoteInfoIncludePayment = driver.findElement(By.xpath("//div[@id='gridName']/table/tbody/tr"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quoteInfoIncludePayment);
        //WebDriverWait wait=new WebDriverWait(driver,10);
        // WebElement quoteInfoIncludePayment=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return quoteInfoIncludePayment.getText();
    }

    //Edit quote information and verifies the same

    public void clickOnQuoteNumber() {

        WebDriverWait cWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quoteNumber = cWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='gridName']/table/tbody/tr[1]/td[2]/a")));
        quoteNumber.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectEditQuoteOption() {
        WebElement cogIcon = driver.findElement(By.xpath("//div[@id='gridName']/table/tbody/tr[1]/td[20]/ul/li/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cogIcon);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(selectCogIcon)).perform();
        driver.findElement(selectEditQuoteIcon).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void editQuoteDetails() {
        //Scroll up
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(enterPostCodeInAddressDropDown).clear();
        driver.findElement(enterPostCodeInAddressDropDown).sendKeys("RM8 2TE");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(selectPostCodeFromDD).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(hearAboutUsDropDown).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(selectOptionFromHearAboutUsDD).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Scroll up
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,-150)", "");
        driver.findElement(petSpeciesDropDown).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(selectOptionFromPetSpeciesDD).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(petName).clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(petName).sendKeys("TestEditQuote");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(petGenderDropDown).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(selectOptionsFromPetGDD).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(petBirthDate).clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(petBirthDate).sendKeys("02.08.2020");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        ((JavascriptExecutor) driver).executeScript("document.getElementById('Question_142').style.display='block';");
        driver.findElement(petPurchaseAmount).clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((JavascriptExecutor) driver).executeScript("document.getElementById('Question_142').style.display='block';");
        driver.findElement(petPurchaseAmount).sendKeys("500");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ((JavascriptExecutor) driver).executeScript("document.getElementById('Question_231').style.display='block';");
        driver.findElement(petAdminFees).clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((JavascriptExecutor) driver).executeScript("document.getElementById('Question_231').style.display='block';");
        driver.findElement(petAdminFees).sendKeys("20");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver.findElement(calculateButton).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(calculateButton));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,150)", "");

        //driver.findElement(closeButton).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(closeButton));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/


    }

    //Verify that quote information page displays with sane status code on by clicking on quote code on manage quote page

    public void clickOnQuoteCodeLink(){
        //String code=driver.findElement(quoteCodeOnManageQuotePage).getText();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(quoteLinkOnManageQuotePage).click();

        //return code;

    }

    public String verifyQuoteCode(){
        return driver.findElement(quoteStatusCode).getText();

    }


}
