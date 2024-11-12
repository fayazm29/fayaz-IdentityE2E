package stepDefinitions;

import helpers.DataFile;
import helpers.FileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchVehiclePage;
import pageObjects.VehicleDetailsPage;

import java.util.List;

public class CarValuationStepDefinitions {

    SearchVehiclePage searchVehiclePage = new SearchVehiclePage();

    VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage();

    List<String> carRegs;
    String inputFile;
    List<String> outputVehicleDetails;
    DataFile dataFile = new DataFile();

    @Given("I have a car {string} containing vehicle reg numbers")
    public void i_have_a_car_input_file_version_containing_vehicle_reg_numbers(String fileName) {
        inputFile = dataFile.getFile(fileName);
    }

    @Given("I have all the vehicle registration numbers extracted from it")
    public void i_have_all_the_vehicle_registration_numbers_extracted_from_it() {
        if (inputFile != null) {
            carRegs = FileReader.getCarRegistrationNumbers(inputFile);
        }
    }

    @When("I get the all vehicle details from the website search with the vehicle reg number and mileage")
    public void i_search_for_vehicle_details_on_the_website_with_the_vehicle_reg_number_and_mileage() {
        outputVehicleDetails = searchVehiclePage.getVehicleDetails(carRegs);
    }


    @Then("I compare the website vehicle details with {string} details for any mismatches")
    public void i_compare_the_vehicle_details_from_the_website_with_the_output_file(String outputFile) {
        List<String> outputFileDetails = FileReader.readFile(dataFile.getFile(outputFile));
        vehicleDetailsPage.compareCorrectRegMessages(outputVehicleDetails, outputFileDetails);


    }

}
