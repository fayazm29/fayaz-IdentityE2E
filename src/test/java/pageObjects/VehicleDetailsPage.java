package pageObjects;

import base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VehicleDetailsPage extends BasePage {


    @FindBy(xpath = "//div[3]/div[1]/vehicle-details/div[3]/div[1]/div[2]")
    WebElement carRegElement;

    @FindBy(xpath = "//div[3]/div/vehicle-details/div[3]//div[@class='d-table-cell value']")
    List<WebElement> findMyCarElements;

    @FindBy(id = "btn-back")
    WebElement backButton;

    public List<String> getVehicleDetails() {
        List<String> vehicleDetails = new ArrayList<>();
        String carRegNumber = carRegElement.getText();
        vehicleDetails.add(carRegNumber);
        for (WebElement carReg : findMyCarElements) {
            vehicleDetails.add(carReg.getText());
        }
        System.out.println(vehicleDetails);
        return vehicleDetails;
    }

    public SearchVehiclePage goBackToSearchVehiclePage() {
        WebDriverWait wait = new WebDriverWait(DriverContext.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
        return new SearchVehiclePage();
    }


    public void compareCorrectRegMessages(List<String> websiteVehicleDetails, List<String> outputVehicleDetails) {
        Collections.sort(outputVehicleDetails);
        for (String outputDetails : outputVehicleDetails) {
            for (String websiteDetails : websiteVehicleDetails) {
                if (websiteDetails.matches(outputDetails)) {
                    System.out.println("Vehicle :" + websiteDetails +  " matches with the Output file details: " + outputDetails);

                } else {
                    System.out.println("Vehicle :" + websiteDetails +  "miss-matches with the Output file details: " + outputDetails);
                }
            }
        }


    }
}
