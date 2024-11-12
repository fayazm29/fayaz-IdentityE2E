package helpers;

import org.junit.Assert;

public class DataFile {

    String dir_path = System.getProperty("user.dir");

    public String getFile(String fileName) {

        String file = null;

        switch (fileName.toLowerCase()) {

            case "input file version 1":
                file = dir_path + "/src/main/java/testData/inputFiles/car_input_v1.txt";
                break;
            case "output file version 1":
                file = dir_path + "/src/main/java/testData/outputFiles/car_output_v1.txt";
                break;
            case "input file version 2":
                file = dir_path + "/src/main/java/testData/inputFiles/car_input_v2.txt";
                break;
            case "output file version 2":
                file = dir_path + "/src/main/java/testData/outputFiles/car_output_v2.txt";
                break;
            default:
                Assert.assertFalse("No fileName is passed or not matched.Please check the file name ", false);

        }

        return file;
    }
}
