class ArrayOperations {
    public static int[][][] createCube() {
        // write your code here
        int[][][] newArray = new int[3][3][3];
        int element = 0;

        for (int i = 0; i < newArray.length; i++) {
            element = 0;
            for (int j = 0; j < newArray[i].length; j++) {
                for (int k = 0; k < newArray[i][j].length; k++) {
                    newArray[i][j][k] = element;
                    element++;
                }
            }
        }
        return newArray;
    }
}

