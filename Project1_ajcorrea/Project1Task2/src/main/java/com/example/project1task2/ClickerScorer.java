// Ariane Correa
// ajcorrea

package com.example.project1task2;

import java.util.Map;
import java.util.TreeMap;

public class ClickerScorer {

    // A TreeMap is used to maintain key values in ascending order
    private Map<String,Integer> score = new TreeMap<>();


    public  Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
    }
}

