// Ariane Correa
// ajcorrea

package com.example.project1task1.controller;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.bind.DatatypeConverter;

@WebServlet(name = "ComputeHashes", value = "/compute-hashes")
public class ComputeHashes extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        // Get the hash type and input value from the request parameters
        String hashType = request.getParameter("hashType");
        String inputValue = request.getParameter("inputValue");


        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(hashType);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // Calculate the hash value
        byte[] hashValue = md.digest(inputValue.getBytes());

        // Encode the hash value as base64 and hexadecimal strings
        String base64EncodedValue = DatatypeConverter.printBase64Binary(hashValue);
        String hexEncodedValue = DatatypeConverter.printHexBinary(hashValue);

        // Set attributes to return to the JSP
        request.setAttribute("base64EncodedValue", base64EncodedValue);
        request.setAttribute("hexEncodedValue", hexEncodedValue);
        request.setAttribute("inputValue", inputValue);

        // Forward the request to the JSP for rendering
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
