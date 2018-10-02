package com.app.api.core.Quiz;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuizResponse {

    @JsonProperty
    private String questionId = null;

    @JsonProperty
    private String question = null;

    @JsonProperty
    private String optionOne = null;

    @JsonProperty
    private String optionTwo = null;

    @JsonProperty
    private String optionThree = null;

    @JsonProperty
    private String optionFour = null;

    @JsonProperty
    private String correctOption = null;

}
