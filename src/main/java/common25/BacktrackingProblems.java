package common25;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 *
 */
public class BacktrackingProblems {
    /**
     * <b>18. Regular expression matching
     * <br>
     * Problem Statement:</b> Given a text and a pattern, determine if the
     * pattern matches the text completely or not at all using regular
     * expression matching. Assume the pattern contains only two operators: . and *.
     * Operator * in the pattern means that the character preceding * may not
     * appear or may appear any number of times in the text.
     * Operator . matches with any character in the text exactly once.
     * <br>
     * <br>
     * <b>Using Dynamic programming</b>
     * @param regex Regular expression
     * @param input input string
     * @return true if input satisfies the regex, false otherwise
     */
    public static boolean regexMatch(String regex, String input) {
        char [] r = regex.toCharArray();
        char [] s = input.toCharArray();

        /*
         * initialize as -
         *
         * true, false, false
         * false
         * false
         **/
        boolean [][] dp = new boolean[s.length + 1][r.length + 1];
        dp[0][0] = true;

        /*
         * for cases like a*, a*b* etc.
         **/
        for (int i = 1; i < dp[0].length; i++) {
            if (r[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s[i-1] == r[j-1] || r[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (r[j-1] == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (r[j-2]=='.' || r[j-2] == s[i-1]) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length][r.length];
    }

    public static boolean fsaMatch(String regex, String input) {
        char[] r = regex.toCharArray();
        char[] s = input.toCharArray();
        ArrayList<State> Q = fsa(r);
        State finalState = match(Q.get(0), s, 0);
        return finalState == Q.get(1);
    }

    private static ArrayList<State> fsa(char[] reg) {
        ArrayList<State> Q = new ArrayList<>();
        State S = new State(1);
        Q.add(S);
        for (int i = 0; i < reg.length; i++) {
            State newS = null;
            char r = reg[i];
            if (i + 1 < reg.length && reg[i + 1] == '*') {
                newS = S;
                i++;
            } else {
                newS = new State(S.state + 1);
            }
            S.addTransition(r, newS);
            S = newS;
        }

        Q.add(S);

        return Q;
    }

    private static State match(State curState, char[] input, int index) {
        if (index >= input.length) {
            return curState;
        }

        ArrayList<State> transitions = curState.consumeAndTransition(input[index]);
        if (transitions == null) {
            return null;
        }

        for (State S : transitions) {
            State finalState = match(S, input, index + 1);
            if (finalState != null) {
                return finalState;
            }
        }
        return null;
    }

    /**
     * <b>19. Rat in a Maze
     * <br>
     * Problem Statement:</b> Consider a rat placed in a square n*n matrix
     * at position (0, 0). Find all possible paths the rat can take to reach
     * its destination (N-1, N-1) from its starting position.
     *<br>
     * The rat can move vertically and horizontally. Cells with a value of 1
     * can be traversed, while cells with a value of 0 cannot.
     * The rat cannot visit a cell more than once.
     * @param maze
     * @return
     */
    public static int mazeTraversal(int[][] maze) {
        int[][] visits = new int[maze.length][maze[0].length];
        return dfsMaze(maze, 0, 0, visits);
    }

    private static int dfsMaze(int[][] nodes, int curRow, int curCol, int[][] visits) {
        if (curRow == nodes.length - 1 && curCol == nodes[0].length - 1) {
            return 1;
        }
        visits[curRow][curCol] = 1;
        int paths = 0;
        if (curRow > 0 && nodes[curRow - 1][curCol] == 1 && visits[curRow - 1][curCol] == 0) {
            paths += dfsMaze(nodes, curRow - 1, curCol, visits);
        }
        if (curCol > 0 && nodes[curRow][curCol - 1] == 1 && visits[curRow][curCol - 1] == 0) {
            paths += dfsMaze(nodes, curRow, curCol - 1, visits);
        }
        if (curRow + 1 < nodes.length && nodes[curRow + 1][curCol] == 1 && visits[curRow + 1][curCol] == 0) {
            paths += dfsMaze(nodes, curRow + 1, curCol, visits);
        }
        if (curCol + 1 < nodes[0].length  && nodes[curRow][curCol + 1] == 1 && visits[curRow][curCol + 1] == 0) {
            paths += dfsMaze(nodes, curRow, curCol + 1, visits);
        }

        visits[curRow][curCol] = 0;
        return paths;
    }
}

class State{
    int state = 0;
    private HashMap<Character, ArrayList<State>> transitions = new HashMap<>();

    public State(int state) {
        this.state = state;
    }

    public State addTransition(char input, State S) {
        ArrayList<State> states = transitions.computeIfAbsent(input, k->new ArrayList<>());
        states.add(S);
        return this;

    }

    public ArrayList<State> consumeAndTransition(char input) {
        ArrayList<State> states = this.transitions.get(input);
        if (states == null) {
            states = this.transitions.get('.');
        }
        return states;
    }
}
