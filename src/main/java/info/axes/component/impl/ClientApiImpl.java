package info.axes.component.impl;


import info.axes.component.ClientApi;
import info.axes.model.api.UpcomingMoviesResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;





@Component
public class ClientApiImpl implements ClientApi {

    private final static String BASE_URL = "https://api.themoviedb.org/3";

    private final static String GET_UPCOMING_MOVIES_URL = "/movie/upcoming?api_key=cccb563214c6cc633ac8e5e9de9df9cb";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public UpcomingMoviesResponseDto getUpcomingMovies() {

        return restTemplate.getForObject(BASE_URL+GET_UPCOMING_MOVIES_URL, UpcomingMoviesResponseDto.class);
    }
}
