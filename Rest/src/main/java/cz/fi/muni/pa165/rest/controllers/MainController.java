package cz.fi.muni.pa165.rest.controllers;

import cz.fi.muni.pa165.rest.ApiUris;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> getResources() {

        Map<String, String> resourcesMap = new HashMap<>();

        resourcesMap.put("trainers_uri", ApiUris.ROOT_URI_TRAINERS);
        resourcesMap.put("badges_uri", ApiUris.ROOT_URI_BADGES);
        resourcesMap.put("tournaments_uri", ApiUris.ROOT_URI_TOURNAMENTS);
        resourcesMap.put("gyms_uri", ApiUris.ROOT_URI_GYMS);
        resourcesMap.put("pokemons_uri", ApiUris.ROOT_URI_POKEMONS);

        return Collections.unmodifiableMap(resourcesMap);

    }
}
