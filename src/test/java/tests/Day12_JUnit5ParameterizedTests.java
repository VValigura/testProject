package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Day12_JUnit5ParameterizedTests {

    @BeforeEach
    void beforeEach(){
        open("https://www.google.com/");
    }

    @DisplayName("for 'maven central' search in google show 'Central Repository' result ")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("UI")
    })
    @Test
    void withoutSourse(){
        $("[name=q]").setValue("maven central").pressEnter();
        $("#rso").shouldHave(text("Central Repository"));
    }


    @CsvSource({
            "maven central, Central Repository",
            "Java, Oracle"
    })
    @ParameterizedTest(name = "for {0} search in google show {1} result ")
    @Tags({ @Tag("BLOCKER"), @Tag("UI") })
    void csvSource(String productName, String result){
        $("[name=q]").setValue(productName).pressEnter();
        $("#rso").shouldHave(text(result));
    }


    @ValueSource(strings = {
            "maven central","Java"
    })
    @ParameterizedTest(name = "for {1} search in google show result more 5 ")
    @Tags({ @Tag("BLOCKER"), @Tag("UI") })
    void valueSource(String productName){
        $("[name=q]").setValue(productName).pressEnter();
        $$("div[class='MjjYud']").shouldHave(sizeGreaterThan(5));
    }


    @MethodSource("methodSource1")
    @ParameterizedTest(name = "for {0} search in google show {1} result ")
    @Tags({ @Tag("BLOCKER"), @Tag("UI") })
    void methodSource(String productName, String result){
        $("[name=q]").setValue(productName).pressEnter();
        $("#rso").shouldHave(text(result));
    }

    static Stream<Arguments> methodSource1() {
        return Stream.of(
                Arguments.of("maven central", "Central Repository"),
                Arguments.of("Java", "Oracle")
        );
    }
}
