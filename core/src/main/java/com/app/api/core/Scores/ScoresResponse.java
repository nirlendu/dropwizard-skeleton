package com.app.api.core.Scores;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScoresResponse {

    @JsonProperty
    private String userId = null;

    @JsonProperty
    private String score = null;

}
