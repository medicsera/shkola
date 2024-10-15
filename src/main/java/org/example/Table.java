package org.example;

public class Table {
    private int[][] data;

    public Table(int rows, int cols) {
        this.data = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int rows() {
        return data.length;
    }

    public int cols() {
        return data[0].length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < cols(); col++) {
                sb.append(data[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public double average() {
        int sum = 0;
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < cols(); col++) {
                sum += data[row][col];
            }
        }
        return (double) sum / (rows() * cols());
    }
}
