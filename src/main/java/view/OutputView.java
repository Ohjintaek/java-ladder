package view;

import java.util.List;

public class OutputView {

    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String BLANK_LINE = "        ";
    private static final String CONNECTED_LINE = "--------";
    private static final String LADDER = "|";
    private static final String RESULT_MESSAGE = "실행결과";


    public static void printResultMessage() {
        System.out.println(LADDER_MESSAGE);
        System.out.println();
    }

    public static void printUserNames(final List<String> userNames) {
        String formattedUserNames = formatUserNames(userNames);
        System.out.println(formattedUserNames);
    }

    public static void printLadder(final List<List<Boolean>> lines) {
        for (List<Boolean> line : lines) {
            System.out.println(renderLine(line));
        }
    }

    public static void printResultNames(final List<String> resultNames) {
        String formattedResultNames = formatResultNames(resultNames);
        System.out.println(formattedResultNames);
        System.out.println();
    }

    public static void printUserResult(final String result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResult(final List<String> userNames, final List<String> resultNames) {
        System.out.println(RESULT_MESSAGE);
        for (int index = 0; index < userNames.size(); index++) {
            System.out.printf("%s : %s", userNames.get(index), resultNames.get(index));
            System.out.println();
        }
    }

    private static String formatUserNames(final List<String> userNames) {
        StringBuilder builder = new StringBuilder();
        for (String userName : userNames) {
            String formattedUserName = String.format("%9s", userName);
            builder.append(formattedUserName);
        }
        return builder.toString();
    }

    private static String renderLine(final List<Boolean> line) {
        StringBuilder builder = new StringBuilder();
        builder.append(BLANK_LINE);
        builder.append(LADDER);
        for (boolean connected : line) {
            renderLink(builder, connected);
            builder.append(LADDER);
        }
        return builder.toString();
    }

    private static void renderLink(final StringBuilder builder, final boolean connected) {
        if (connected) {
            builder.append(CONNECTED_LINE);
            return;
        }
        builder.append(BLANK_LINE);
    }

    private static String formatResultNames(final List<String> resultNames) {
        StringBuilder builder = new StringBuilder();
        for (String resultName : resultNames) {
            String formattedResultName = String.format("%9s", resultName);
            builder.append(formattedResultName);
        }
        return builder.toString();
    }
}
