package helpers;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {
    public static List<String> getCarRegistrationNumbers(String inputFile) {
        List<String> allMatches = new ArrayList<>();

        try {
            List<String> allLines = Files.readAllLines(Paths.get(inputFile));
            Matcher matcher;

            for (String line : allLines) {
                String carRegRegex = "^(([A-Z]{1,2}[ ]?[0-9]{1,4})|([A-Z]{3}[ ]?[0-9]{1,3})|([0-9]{1,3}[ ]?[A-Z]{3})|([0-9]{1,4}[ ]?[A-Z]{1,2})|([A-Z]{3}[ ]?[0-9]{1,3}[ ]?[A-Z])|([A-Z][ ]?[0-9]{1,3}[ ]?[A-Z]{3})|([A-Z]{2}[ ]?[0-9]{2}[ ]?[A-Z]{3})|([A-Z]{3}[ ]?[0-9]{4}))$";
                Pattern pattern = Pattern.compile(carRegRegex);

                String[] parts = line.split(" ");
                String groupItems;
                if (!StringUtils.isEmpty(line)) {
                    for (int i = 0; i < parts.length; i++) {
                        matcher = pattern.matcher(parts[i]);
                        if (matcher.find()) {
                            if (parts[i].length() < 5) {
                                groupItems = parts[i] + parts[i + 1].replaceAll("\\.", "");
                                allMatches.add(groupItems);
                            } else {
                                allMatches.add(matcher.group());

                            }

                        }
                    }
                }


            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return allMatches;

    }

    public static List<String> readFile(String outputFile) {
        List<String> allMatches = new ArrayList<>();

        try {
            List<String> allLines = Files.readAllLines(Paths.get(outputFile));

            for (int i = 1; i < allLines.size(); i++) {
                if (!StringUtils.isEmpty(allLines.get(i))) {
                    allMatches.add(allLines.get(i).replaceAll(",", " "));
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return allMatches;

    }
}
