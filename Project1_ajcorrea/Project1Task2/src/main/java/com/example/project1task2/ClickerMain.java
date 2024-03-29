// Ariane Correa
// ajcorrea

package com.example.project1task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "clicker-controls", urlPatterns = {"/submit", "/getResults"})
public class ClickerMain extends HttpServlet {
    private String outputText;
    private ClickerScorer clickerScorer = new ClickerScorer();

    public void init() {
        outputText = "";
        clickerScorer.setScore(new HashMap<>());
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // If the path is "/submit"
        if (request.getServletPath().equals("/submit")) {
            String choice = request.getParameter("choice");

            // Create an output message for the user
            outputText = "Your \"" + choice + " \" has been registered";
            Map<String, Integer> score = clickerScorer.getScore();

            // Get the value of the "choice" parameter and update the map accordingly.
            // If the value is already contained in the map, update its count; otherwise, add a new entry.
            score.put(choice, score.containsKey(choice) ? score.get(choice) + 1 : 1);

            clickerScorer.setScore(score);
            request.setAttribute("outputText", outputText);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

        // If the path is "/getResults"
        if (request.getServletPath().equals("/getResults")) {

            //Set map attribute as object and retrieve in the servlet page
            request.setAttribute("choiceMap", clickerScorer.getScore());
            request.getRequestDispatcher("result.jsp").forward(request, response);
            clickerScorer.setScore(new HashMap<>());
        }

    }

    public void destroy() {
    }
}