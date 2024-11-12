package pageObjects;

import base.DriverContext;
import helpers.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SearchVehiclePage extends BasePage {

    @FindBy(id = "vehicleReg")
    WebElement carRegTextField;

    @FindBy(id = "Mileage")
    WebElement mileageTextField;

    @FindBy(id = "btn-go")
    WebElement btnCarValuation;

    @FindBy(xpath = "//h1[@class='text-focus ng-star-inserted']")
    List<WebElement> errorMessages;


    public void setValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void getMyCarValuation(String carReg) {
        setValue(carRegTextField, carReg);
        setValue(mileageTextField, Utils.generateRandomMileageNum());
        btnCarValuation.click();
    }

    public List<String> getVehicleDetails(List<String> carRegs) {
        VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage();
        List<String> outputVehicleDetails = null;
        String refinedDetails = null;
        List<String> rDetails = new ArrayList<>();
        for (int i = 0; i < carRegs.size(); i++) {
            getMyCarValuation(carRegs.get(i));
            DriverContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String currentUrl = DriverContext.driver.getCurrentUrl();
            if (currentUrl.contains("vehicle/details")) {
                outputVehicleDetails = vehicleDetailsPage.getVehicleDetails();
                refinedDetails = sortOutputVehicleDetails(outputVehicleDetails);
                rDetails.add(refinedDetails);
                vehicleDetailsPage.goBackToSearchVehiclePage();
            } else if (currentUrl.contains("check-registration")) {
                System.out.println(errorMessages.get(0).getText() + " with reg number " + carRegs.get(i));
            } else if (currentUrl.contains("not-found")) {
                vehicleDetailsPage.goBackToSearchVehiclePage();
                System.out.println(errorMessages.get(0).getText() + " with reg number " + carRegs.get(i));
            }
        }
        return rDetails;
    }

    public String sortOutputVehicleDetails(List<String> websiteVehicleDetails) {
        Collections.sort(websiteVehicleDetails);
        String space = " ";
        return websiteVehicleDetails.get(4) + space + websiteVehicleDetails.get(5) + space + websiteVehicleDetails.get(0) + space + websiteVehicleDetails.get(2);
    }

}
