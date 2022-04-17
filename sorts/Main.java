package com.company.algorithms.sorts;
import java.util.Arrays;

public class Main {

    public static int[] merge(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[(arrayA.length + arrayB.length) / 2];

        int positionA = 0;
        int positionB = 0;
        for (int k = 0; k < arrayC.length; k++) {
            if (arrayA[k - positionA] < arrayB[k - positionB]) {
                arrayC[k] = arrayB[k - positionB];
                positionA++;
            } else {
                arrayC[k] = arrayA[k - positionA];
                positionB++;
            }
        }
        return arrayC;
    }

    public static int[] makeNationalTeam(int[][] teams) {
        int[] team = teams[0];
        for (int i = 1; i < teams.length; i++) {
            team = merge(team, teams[i]);
        }
        return team;

    }

    public static void main(String[] args) {

        int[][] regional = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

        int[] national = makeNationalTeam(regional);

        Arrays.stream(national).forEach(System.out::println);

    }
}
