package ee.tlu.kontrolltoo2.controller;

import ee.tlu.kontrolltoo2.model.EnvironmentData.EnvironmentItem;
import ee.tlu.kontrolltoo2.model.EnvironmentData.EnvironmentRoot;
import ee.tlu.kontrolltoo2.model.MarineRegions;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class RestTemplateController {

    @GetMapping("marineregions")
    public List<MarineRegions> getMarineRegions() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://marineregions.org/rest/getGazetteerTypes.json/";
        ResponseEntity<MarineRegions[]> response = restTemplate.exchange(url, HttpMethod.GET, null, MarineRegions[].class);
        return List.of(response.getBody());
    }

    @GetMapping("marineregions/{input}")
    public List<MarineRegions> getMarineRegionsByInput(@PathVariable String input) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://marineregions.org/rest/getGazetteerTypes.json/";
        ResponseEntity<MarineRegions[]> response = restTemplate.exchange(url, HttpMethod.GET, null, MarineRegions[].class);

        List<MarineRegions> marineRegions = new ArrayList<>();

        for (MarineRegions item : response.getBody()) {
            if (input.contains(item.getDescription())) {
                marineRegions.add(item);
            }
        }

        return marineRegions;

        /*List<MarineRegions> marineRegions = new ArrayList<>();
        for (MarineRegions m : response.getBody()) {
            if (m.getType().equals(input)) {
                marineRegions.add(m);
            }
        }
        return marineRegions;*/
    }

    @GetMapping("enviromentdata")
    public EnvironmentRoot getEnvironmentData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://environment.data.gov.uk/flood-monitoring/id/floods";
        ResponseEntity<EnvironmentRoot> response = restTemplate.exchange(url, HttpMethod.GET, null, EnvironmentRoot.class);
        return response.getBody();
    }

    @GetMapping("environmentdata/{area}")
    public List<EnvironmentItem> getEnvironmentItemByArea(@PathVariable String area) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://environment.data.gov.uk/flood-monitoring/id/floods";
        ResponseEntity<EnvironmentRoot> response = restTemplate.exchange(url, HttpMethod.GET, null, EnvironmentRoot.class);

        List<EnvironmentItem> environmentItems = new ArrayList<>();

        // Iterate over the list of environment items and filter the data
        for (EnvironmentItem item : response.getBody().getItems()) {
            if (area.equals(item.getEaAreaName())) {
                environmentItems.add(item);
            }
        }

        return environmentItems;
    }

}
