package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.dto.Meteo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import javax.annotation.Resource;
import java.net.URI;

@Service
public class MeteoService {

	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";

	private static final Logger logger = LoggerFactory.getLogger(MeteoService.class);

	private final RestTemplate restTemplate;

	@Value("${app.weather.api.key}")
	private String apiKey;

	public MeteoService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Cacheable("weather")
	public Meteo getMeteo(String country, String city) {
		logger.info("Requesting current weather for {}/{}", country, city);
		URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
		return apiGet(url, Meteo.class);
	}


	private <T> T apiGet(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url)
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate
				.exchange(request, responseType);
		return exchange.getBody();
	}

}
