package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("abra@kadabra.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8999888776");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $("[aria-label='Choose Wednesday, March 15th, 2000']").click();
        $("#subjectsInput").setValue("Computer Science");
        $("#subjectsInput").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("./src/test/java/../resources/For_test.jpg"));
        $("#currentAddress").setValue("some text2");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Alex"),
                text("Smith"),
                text("abra@kadabra.com"),
                text("Male"),
                text("8999888776"),
                text("15 March,2000"),
                text("Computer Science"),
                text("Sports"),
                text("For_test.jpg"),
                text("some text2"),
                text("NCR"),
                text("Delhi"));
    }
}
