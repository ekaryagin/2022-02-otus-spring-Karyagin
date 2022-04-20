package ru.otus.spring.ekaryagin.utility;

public class Message {

    private Message() {
    }

    public static final String WELCOME = "\n############## < Welcome to the quiz! > ##############";
    public static final String INPUT_LAST_NAME = "Input your last name: ";
    public static final String INPUT_FIRST_NAME = "Input your first name: ";
    public static final String REPEAT_TEST = "\nDo you want to repeat test?";
    public static final String BAY = "\n################ < Have a good day! > ################";
    public static final String SUM_UP = "\n##################### < sum up > #####################";
    public static final String APPEAL = "Dear ";
    public static final String PASSED_TEST = "\nYou have successfully passed the test.";
    public static final String FAILED_TEST = "\nYou failed the test.";
    public static final String YOUR_CHOICE = "Input your choice (Yes/No): ";

    public static final String START_TESTING = "\n############### < Will start testing! > ##############";
    public static final String ANSWER_OPTIONS = "\tAnswer options:";
    public static final String ENTER_ANSWER = "\t\tEnter the correct answer numbers separated by commas: ";
    public static final String ONLY_NUM_AND_COMMAS = "\t\tPlease enter numbers separated by commas, no other characters.";
    public static final String TEST_OVER = "\n################# < Testing is over > ################";
    public static final String YOUR_MARK = " - this is the percentage of your correct answers";

    public static final String EXCEPT_NO_QUESTIONS = "There are no quiz questions in the source.";
    public static final String EXCEPT_FILE_NOT_FOUND = "The quiz file was not found or damaged.";
}
