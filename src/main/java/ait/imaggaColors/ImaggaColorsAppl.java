package ait.imaggaColors;

import ait.imagga.dto.TagsResponseDto;
import ait.imaggaColors.dto.ColorInfoDto;
import ait.imaggaColors.dto.ColorsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class ImaggaColorsAppl {
    public static void main(String[] args) {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic ****************************************");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);
        URI url = builder.build().toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);

        ResponseEntity<ColorsResponseDto> response = restTemplate.exchange(request, ColorsResponseDto.class);

        List<ColorInfoDto> imageColors = response.getBody().getResult().getColors().getImage_colors();

        System.out.printf("%-25s %-25s %-20s%n", "color name", "parent color name", "coverage percent");
        System.out.println("--------------------------------------------------------------------------");

        for (ColorInfoDto color : imageColors) {
            System.out.printf("%-25s %-25s %-20.2f%n",
                    color.getClosest_palette_color(),
                    color.getClosest_palette_color_parent(),
                    color.getPercent());
        }
    }
}
