package info.axes.component.impl;


import info.axes.component.ClientApi;
import info.axes.model.api.UpcomingMoviesResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;




@Component
public class ClientApiImpl implements ClientApi {

    private final static String BASE_URL = "https://api.themoviedb.org/3";

    private final static String GET_UPCOMING_MOVIES_URL = "/movie/upcoming?api_key={value}";

    private final static String KEY = "api_key";

    private final static String API_KEY = "cccb563214c6cc633ac8e5e9de9df9cb";


    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public UpcomingMoviesResponseDto getUpcomingMovies() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("value", API_KEY);

        String URI = UriComponentsBuilder
                .fromUriString(BASE_URL + GET_UPCOMING_MOVIES_URL)
                .queryParams(params)
                .toUriString();


        return restTemplate.getForObject(URI, UpcomingMoviesResponseDto.class);
    }
}
