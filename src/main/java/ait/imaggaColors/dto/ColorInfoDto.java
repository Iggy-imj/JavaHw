package ait.imaggaColors.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ColorInfoDto {
    private String closest_palette_color;
    private String closest_palette_color_parent;
    private double percent;
}
