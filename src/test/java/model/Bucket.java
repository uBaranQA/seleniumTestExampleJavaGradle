package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bucket {
    private String name;
    private String description;
}
