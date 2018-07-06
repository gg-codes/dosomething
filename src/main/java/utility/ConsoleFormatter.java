package utility;
class ConsoleFormatterTest {

    public static void main(String args[]) {
        ConsoleFormatter.BuildFormatter builder = new ConsoleFormatter.BuildFormatter();
        System.out.println(builder

                .COLOR(Color.RED)
                .append("String in color")

                .BOLD()
                .append("\nColored String in bold")

                .COLOR(Color.BLUE_BRIGHT)
                .append("\nString in different color")

                .RESET_ALL()
                .append("\nConsole Reset")

                .COLOR(Color.RED).BACKGROUND(Color.GREEN_BACKGROUND_BRIGHT)
                .append("\nBackground without bold")

                .BOLD()
                .append("\nBackground with bold")

                .COLOR(Color.WHITE_BRIGHT).BACKGROUND(Color.BLUE_BACKGROUND_BRIGHT).UNDERLINE()
                .append("\nWhite underlined in blue background")

                .RESET_COLOR()
                .append("\nColor reset but still with background color")

                .RESET_BACKGROUND()
                .append("\nBackground reset")

                .RESET_BOLD().RESET_UNDERLINE().RESET_ITALICS()
                .append("\nReset bold, italics and underline")

                .RESET_ALL().UNDERLINE().BOLD()
                .append("\nUnderlined and Bold")

                .RESET_UNDERLINE()
                .append("\nUnderline removed but still bold")

                .RESET_BOLD()
                .append("\nBold also removed")

                .toString());

        System.out.println(builder.COLOR(Color.RED).append("Red, ")
                .COLOR(Color.GREEN).append("Green, ")
                .COLOR(Color.YELLOW).append("Yellow, ")
                .COLOR(Color.BLUE).append("Blue")
                .toString());
    }
}

public class ConsoleFormatter {

    private boolean isNormalConsole;
    private Color color;
    private Color background;
    private boolean bold;
    private boolean underline;
    private boolean italics;

    private ConsoleFormatter() {
        this.isNormalConsole = true;
    }

    public static class BuildFormatter {

        private ConsoleFormatter consoleFormatter;
        private StringBuilder stringBuilder;
        private String COMMA = ";";

        public BuildFormatter() {
            stringBuilder = new StringBuilder();
            this.consoleFormatter = new ConsoleFormatter();
        }

        @Override
        public String toString() {
            String str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            return str;
        }

        public BuildFormatter COLOR(Color color) {
            consoleFormatter.color = color;
            consoleFormatter.isNormalConsole = false;
            return this;
        }

        public BuildFormatter RESET_COLOR() {
            consoleFormatter.color = null;
            return this;
        }

        public BuildFormatter BOLD() {
            consoleFormatter.bold = true;
            consoleFormatter.isNormalConsole = false;
            return this;
        }

        public BuildFormatter RESET_BOLD() {
            consoleFormatter.bold = false;
            return this;
        }

        public BuildFormatter ITALICS() {
            consoleFormatter.italics = true;
            consoleFormatter.isNormalConsole = false;
            return this;
        }

        public BuildFormatter RESET_ITALICS() {
            consoleFormatter.italics = false;
            return this;
        }

        public BuildFormatter UNDERLINE() {
            consoleFormatter.underline = true;
            consoleFormatter.isNormalConsole = false;
            return this;
        }

        public BuildFormatter RESET_UNDERLINE() {
            consoleFormatter.underline = false;
            return this;
        }

        public BuildFormatter BACKGROUND(Color background) {
            consoleFormatter.background = background;
            return this;
        }

        public BuildFormatter RESET_BACKGROUND() {
            consoleFormatter.background = null;
            return this;
        }

        public BuildFormatter RESET_ALL() {
            consoleFormatter = null;
            consoleFormatter = new ConsoleFormatter();
            return this;
        }

        private String getColoredString(String stringToColor) {
            if (consoleFormatter.isNormalConsole) {
                return stringToColor;
            }
            StringBuilder builder = new StringBuilder();
            if (stringToColor.startsWith("\n")) {
                builder.append("\n");
                stringToColor = stringToColor.substring(1);
            }

            builder.append("\033[");
            if (consoleFormatter.color != null) {
                builder.append(consoleFormatter.color.getANSICode());
            }
            if (consoleFormatter.bold) {
                builder.append(COMMA).append(Color.BOLD.getANSICode());
            }
            if (consoleFormatter.italics) {
                builder.append(COMMA).append(Color.ITALICS.getANSICode());
            }
            if (consoleFormatter.underline) {
                builder.append(COMMA).append(Color.UNDERLINE.getANSICode());
            }
            if (consoleFormatter.background != null) {
                builder.append(COMMA).append(consoleFormatter.background.getANSICode());
            }
            builder.append("m");
            builder.append(stringToColor);
            builder.append(Color.RESET.getANSICode());
            return builder.toString();
        }

        public BuildFormatter append(String str) {
            stringBuilder.append(getColoredString(str));
            return this;
        }
    }
}

