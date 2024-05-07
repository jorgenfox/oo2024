package ee.tlu.kontrolltoo2.model.EnvironmentData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class EnvironmentRoot {
    @JsonProperty("@context")
    public String context;
    public Meta meta;
    public ArrayList<EnvironmentItem> items;
}
