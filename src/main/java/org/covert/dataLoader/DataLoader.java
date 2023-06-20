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
        String data;// = scanner.nextLine();

        // Iterate over the file
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            // Split the line to have each  column
            String[] row = data.split(",");


        var Solution = List.of(
                new Solutions(VEGETATION, "jardí Vertical", "bla bla bla bla", 5),
                new Solutions(VEGETATION, "sostre verd", "bla bla bla bla", 3),
                new Solutions(WATER, "aigua regenerada", "bla bla bla bla", 5)
        );

        solutionsRepository.saveAll(Solution);

        List<District> districtList = new ArrayList<>();
        int i = 2;
        while (i < row.length - 1) {
            String districtName = row[i];
            int levelVegetation = Integer.parseInt(row[i+1]);
            //if (levelVegetation < 0)
            District district = new District(districtName, levelVegetation,Solution);
            districtList.add(district);
            i = i + 2;
        }

        districtRepository.saveAll(districtList);

//        for(int i = 2; i < row.length; i++) {
//
//            String districtName = row[i];
//            int levelVegetation = Integer.parseInt(row[i+1]);
//            //if (levelVegetation < 0)
//            District district = new District(districtName, levelVegetation,Solution);
//        }


        }
    }
}
