package ait.imaggaColors.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ColorsDto {
    private List<ColorInfoDto> image_colors;
    private List<ColorInfoDto> background_colors;
    private List<ColorInfoDto> foreground_colors;
}
