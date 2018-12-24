package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job {
    private String skillSet;
    private String location;
}
