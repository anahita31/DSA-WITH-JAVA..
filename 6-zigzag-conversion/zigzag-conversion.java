class Solution {
    public String convert(String s, int numRows) {
        // If only one row, return the string as it is
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create an array of StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;     // current row index
        boolean down = true; // direction flag (down or up)

        // Traverse each character in the string
        for (char c : s.toCharArray()) {
            rows[index].append(c);

            // Change direction at the top or bottom
            if (index == 0) {
                down = true;
            } else if (index == numRows - 1) {
                down = false;
            }

            // Move index up or down
            index += down ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
