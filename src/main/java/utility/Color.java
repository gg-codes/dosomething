package utility;

public enum Color {

    RESET("\033[0m"),  // Text Reset

    BOLD("1"),
    ITALICS("3"),
    UNDERLINE("4"),

    // Regular Colors
    BLACK("30"),   // BLACK
    RED("31"),     // RED
    GREEN("32"),   // GREEN
    YELLOW("33"),  // YELLOW
    BLUE("34"),    // BLUE
    PURPLE("35"),  // PURPLE
    CYAN("36"),    // CYAN
    WHITE("37"),   // WHITE

    BLACK_BRIGHT("90"),  // BLACK
    RED_BRIGHT("91"),    // RED
    GREEN_BRIGHT("92"),  // GREEN
    YELLOW_BRIGHT("93"), // YELLOW
    BLUE_BRIGHT("94"),   // BLUE
    PURPLE_BRIGHT("95"), // PURPLE
    CYAN_BRIGHT("96"),   // CYAN
    WHITE_BRIGHT("97"),  // WHITE

    BLACK_BACKGROUND("40"),  // BLACK
    RED_BACKGROUND("41"),    // RED
    GREEN_BACKGROUND("42"),  // GREEN
    YELLOW_BACKGROUND("43"), // YELLOW
    BLUE_BACKGROUND("44"),   // BLUE
    PURPLE_BACKGROUND("45"), // PURPLE
    CYAN_BACKGROUND("46"),   // CYAN
    WHITE_BACKGROUND("47"),  // WHITE

    BLACK_BACKGROUND_BRIGHT("100"),// BLACK
    RED_BACKGROUND_BRIGHT("101"),// RED
    GREEN_BACKGROUND_BRIGHT("102"),// GREEN
    YELLOW_BACKGROUND_BRIGHT("103"),// YELLOW
    BLUE_BACKGROUND_BRIGHT("104"),// BLUE
    PURPLE_BACKGROUND_BRIGHT("105"), // PURPLE
    CYAN_BACKGROUND_BRIGHT("106"),  // CYAN
    WHITE_BACKGROUND_BRIGHT("107");  // WHITE

    private final String ANSICode;

    public String getANSICode() {
        return ANSICode;
    }

    Color(String ANSICode) {
        this.ANSICode = ANSICode;
    }
}
