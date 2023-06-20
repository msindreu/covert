package org.covert.dataLoader;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.repositories.DistrictRepository;
import org.covert.repositories.SolutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.covert.models.Type.VEGETATION;
import static org.covert.models.Type.WATER;

@Component
@Profile("load-data")
@RequiredArgsConstructor
@Log
public class DataLoader {
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    SolutionsRepository solutionsRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void loadData() throws IOException {
        log.info("loading Data to Database..");
        // Open file
        File file = new File("BarcelonaCiutat_Districtes.csv");

        // Create a scanner object to iterate over the file
        Scanner scanner = new Scanner(file);

        // Skip first line
        String data = scanner.nextLine();
        List<String> rows = new ArrayList<>();
        // Iterate over the file

        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            rows.add(data);
            // Split the line to have each  column
        }
        scanner.close();

        //String[] row = data.split(",");

        var solution = List.of(
            new Solutions(VEGETATION, "Rain Barrels", "Install", 5),
            new Solutions(VEGETATION, "Green Infrastructure", "Barcelona ", 3),
            new Solutions(WATER, "Permeable Surfaces", "Promote ", 5),
            new Solutions(VEGETATION, "Educational Campaigns", "Raise ", 5)
        );
        solutionsRepository.saveAll(solution);

        List<District> districtList = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            var district = rows.get(i).split(",");
            districtRepository.save(new District(district[0], Double.parseDouble(district[1]), solution));
        }
    }
}
